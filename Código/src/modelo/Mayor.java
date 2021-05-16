package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa a una persona mayor. Se extiene de Paciente.
 */

public class Mayor extends Paciente {

	public Mayor(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono, long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
	}

	/**
	 * Se sobreescribe el método que decide quién tiene prioridad para quedarse en la sala privada de la clínica, si el paciente que ya estaba allí o el que recién llega.
	 * <br>
	 * <b>Pre: </b> El parámetro otro debe ser distinto de null.<br>
	 * @param otro: parámetro de tipo Persona, contra el que se decidirá la prioridad.
	 * @return devuelve si el paciente que recién llega tiene prioridad contra un mayor.
	 */
	
	@Override
	public boolean prioridad(Paciente otro) {
		return otro.prioridadMayor();
	}

	/**
	 * Se sobreescribe método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un niño que recién ingresa a la clínica.
	 * @return falso. no se tiene prioridad contra un niño.
	 */
	
	@Override
	public boolean prioridadNiño() {
		return false;
	}

	/**
	 * Se sobreescribe método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un joven que recién ingresa a la clínica.
	 * @return verdadero. Se tiene prioridad contra un joven.
	 */
	
	@Override
	public boolean prioridadJoven() {
		return true;
	}

	/**
	 * Se sobreescribe método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un mayor que recién ingresa a la clínica.
	 * @return falso. No se tiene prioridad contra un mayor.
	 */
	
	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
