package es.maquina1995.mail;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina1995.mail.configuration.ConfiguracionSpring;

public class Main {

	public static void main(String... args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				ConfiguracionSpring.class)) {

		}
	}

}
