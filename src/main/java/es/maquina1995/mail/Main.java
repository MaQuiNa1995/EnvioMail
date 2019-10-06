package es.maquina1995.mail;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina1995.mail.configuration.ConfiguracionProperties;
import es.maquina1995.mail.gestor.GestorMail;
import es.maquina1995.mail.gestor.GestorMailImpl;

public class Main {

	public static void main(String... args) {

		PropertyConfigurator.configure("log4j.properties");

		try (AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(
				ConfiguracionProperties.class)) {

			GestorMail gestorMail = (GestorMailImpl) contexto
					.getBean("gestorMail");
			gestorMail.envioCorreo("Asunto",
					"Descripcion del mensaje c(*_*c) ");
		}
	}
}
