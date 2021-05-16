package excepciones;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una excepción que no se encontro ninguna consulta.
 */
public class NoHayConsultaException extends Exception{
	/**
	 * Constructor con un parametro para setear la excepción.
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepción.
	 */
	public NoHayConsultaException(String message) {
		super(message);
	}
}
