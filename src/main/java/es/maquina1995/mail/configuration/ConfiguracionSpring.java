package es.maquina1995.mail.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import es.maquina1995.mail.gestor.GestorMail;
import es.maquina1995.mail.gestor.GestorMailImpl;

/**
 * Clase encargada de la configuracion de los beans de Spring
 * 
 * @author MaQuiNa1995
 *
 */
@Configuration
@PropertySource("classpath:mailProperties.properties")
public class ConfiguracionSpring {

	/**
	 * Protocolo Smtp a usar
	 */
	@Value("${mail.protocoloSmtp}")
	private String protocoloSmtp;

	/**
	 * Puerto
	 */
	@Value("${mail.puerto}")
	private String puertoEnvio;

	/**
	 * Uso del Tls (Booleano)
	 */
	@Value("${mail.tls.activo}")
	private String tlsActivo;

	/**
	 * Es necesaria autenticación (Booleano)
	 */
	@Value("${mail.autenticacion}")
	private String autenticacion;

	/**
	 * Bean que crea la configuracion del correo
	 * 
	 * @return java.util.Properties que contiene la configuracion a usar del
	 *         correo
	 */
	@Bean(name = "properties")
	public Properties crearProperties() {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", autenticacion);
		properties.put("mail.smtp.starttls.enable", tlsActivo);
		properties.put("mail.smtp.host", protocoloSmtp);
		properties.put("mail.smtp.port", puertoEnvio);

		return properties;
	}

	/**
	 * Creación del bean encargado de enviar mails
	 * 
	 * @return es.maquina1995.mail.gestor.GestorMail objeto encargador de envío
	 *         de mails
	 */
	@Bean(name = "gestorMail")
	public GestorMail gestorMail() {
		return new GestorMailImpl();
	}
}
