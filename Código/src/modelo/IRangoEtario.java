package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Interfaz que representa el rango etario que posee un paciente.
 *Para determinar las prioridades de los pacientes se utiliza Double Dispatch.
 */

public interface IRangoEtario {

	/**
	 * Método que decide quién tiene prioridad para quedarse en la sala privada de la clínica, si el paciente que ya estaba allí o el que recién llega.
	 * <br>
	 * <b>Pre: </b> El parámetro otro debe ser distinto de null.<br>
	 * @param otro: parámetro de tipo Persona, contra el que se decidirá la prioridad.
	 */
	
	boolean prioridad(Paciente otro);
	
	/**
	 * Método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un niño que recién ingresa a la clínica.
	 */
	
	boolean prioridadNiño();
	
	/**
	 * Método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un joven que recién ingresa a la clínica.
	 */
	
	boolean prioridadJoven();
	
	/**
	 * Método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un mayor que recién ingresa a la clínica.
	 */
	
	boolean prioridadMayor();
}
