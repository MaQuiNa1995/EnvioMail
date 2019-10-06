package es.maquina1995.mail.gestor;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:mail.properties")
public class GestorMailImpl implements GestorMail {

	private static final Logger LOGGER = Logger.getLogger(GestorMailImpl.class);

	@Value("${mail.remitente}")
	private String correoRemitente;

	@Value("${mail.pass}")
	private String contrasennaRemitente;

	@Value("${mail.destinatario}")
	private String correoDestinatario;

	@Resource(name = "properties")
	private Properties configuracionProperties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.maquina1995.mail.gestor.GestorMail#envioCorreo(java.lang.String,
	 * java.lang.String)
	 */
	public void envioCorreo(String asunto, String mensaje) {

		Session session = Session.getInstance(configuracionProperties,
				autenticarCorreo());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(correoDestinatario));
			message.setSubject(asunto);

			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);

			MimeMultipart multiParte = new MimeMultipart();
			// DataSource fuente = new FileDataSource(adjunto);
			// texto.setDataHandler(new DataHandler(fuente));
			// texto.setFileName(adjunto);

			multiParte.addBodyPart(texto);
			message.setContent(multiParte);

			Transport.send(message);

			LOGGER.info("Se ha mandado el correo");
		} catch (MessagingException exception) {
			LOGGER.error(
					"Se ha producido una excepción: " + exception.getMessage());
		}
	}

	private Authenticator autenticarCorreo() {

		return new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(correoRemitente,
						contrasennaRemitente);
			}
		};

	}
}
