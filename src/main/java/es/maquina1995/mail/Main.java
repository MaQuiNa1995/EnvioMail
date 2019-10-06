package es.maquina1995.mail;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina1995.mail.configuration.ConfiguracionSpring;
import es.maquina1995.mail.gestor.GestorMail;
import es.maquina1995.mail.gestor.GestorMailImpl;

/**
 * Clase main que inicia la aplicación
 * 
 * @author MaQuiNa1995
 *
 */
public class Main {

	/**
	 * Método principal de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String... args) {

		// Configuración de la ruta del properties
		PropertyConfigurator.configure("log4j.properties");

		try (AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(
				ConfiguracionSpring.class)) {

			GestorMail gestorMail = (GestorMailImpl) contexto
					.getBean("gestorMail");

			gestorMail.envioCorreo("Asunto",
					"Descripcion del mensaje c(*_*c) ");
		}
	}
}
