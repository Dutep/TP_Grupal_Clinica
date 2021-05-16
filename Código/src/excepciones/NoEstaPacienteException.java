package excepciones;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una excepción que el paciente no se encuentra.
 */
public class NoEstaPacienteException extends Exception{
	/**
	 * Constructor con un parametro para setear la excepción.
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepción.
	 */
	public NoEstaPacienteException(String message) {
		super(message);
	}

}
