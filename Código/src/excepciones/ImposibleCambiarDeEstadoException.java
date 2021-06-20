
package excepciones;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una excepción cuando no se puede cambiar de estado la ambulancia.
 */
public class ImposibleCambiarDeEstadoException extends Exception {
	/**
	 * Constructor con un parametro para setear la excepción
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepción
	 */
	public ImposibleCambiarDeEstadoException (String message) {
		super(message);
	}
}
