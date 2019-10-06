package es.maquina1995.mail.gestor;

/**
 * Clase encargada del envío de correos
 * 
 * @author MaQuiNa1995
 *
 */
public interface GestorMail {

	/**
	 * Método usado para enviar correos
	 * 
	 * @param asunto
	 *            String que contiene el asunto del correo
	 * @param mensaje
	 *            String que contiene el cuerpo del mensaje
	 */
	void envioCorreo(String asunto, String mensaje);

}