package es.maquina1995.mail.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import es.maquina1995.mail.gestor.GestorMail;
import es.maquina1995.mail.gestor.GestorMailImpl;

@Configuration
@PropertySource("classpath:mailProperties.properties")
public class ConfiguracionProperties {

	@Value("${mail.servidorSmtp}")
	private String servidorSMTP;

	@Value("${mail.puerto}")
	private String puertoEnvio;

	@Value("${mail.tls.activo}")
	private String tlsActivo;

	@Value("${mail.autenticacion}")
	private String autenticacion;

	@Bean(name = "properties")
	public Properties crearProperties() {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", autenticacion);
		properties.put("mail.smtp.starttls.enable", tlsActivo);
		properties.put("mail.smtp.host", servidorSMTP);
		properties.put("mail.smtp.port", puertoEnvio);

		return properties;
	}

	@Bean(name = "gestorMail")
	public GestorMail gestorMail() {
		return new GestorMailImpl();
	}
}
