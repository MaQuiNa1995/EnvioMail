package es.maquina1995.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.maquina1995.mail.service.MailService;
import lombok.RequiredArgsConstructor;

/**
 * Clase main que inicia la aplicación
 * 
 * @author MaQuiNa1995
 *
 */
@RequiredArgsConstructor
@SpringBootApplication
public class Main implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Autowired
	private final MailService mailService;

	@Override
	public void run(String... args) throws Exception {
		mailService.enviarEmail("maquina1995Prueba@gmail.com", "Prueba Asunto", "Contenido de prueba");
	}
}
