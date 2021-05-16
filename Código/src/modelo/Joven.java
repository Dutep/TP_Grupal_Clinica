package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa a una persona joven. Se extiene de Paciente.
 */

public class Joven extends Paciente {

	/**
	 * Constructor de 7 parámetros donde se setean los atributos de un paciente joven. Se usa super para llamar al constructor de la clase Paciente.
	 * <br>
	 * <b> Pre: </b> El dni debe ser positivo y entero, debe tener al menos 8 digitos, no se debe escribir con puntos ni comas, sólo números.
	 * El teléfono debe ser entero y positivo, debe tener al menos 7 dígitos. <br>
	 * <b> Post: </b> Se crea el obejeto con los parametros dados<br>
	 * @param dni : String que representa el dni de un paciente.
	 * @param nombre : String que representa el nombre de un paciente.
	 * @param apellido : String que representa el apellido de un paciente.
	 * @param domicilio : String que representa el domicilio de una persona.
	 * @param ciudad : String que representa la ciudad de un paciente.
	 * @param telefono : String que representa el numero de telefono de un paciente.
	 */
	
	public Joven(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono, long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
	}
	
	/**
	 * Se sobreescribe el método que decide quién tiene prioridad para quedarse en la sala privada de la clínica, si el paciente que ya estaba allí o el que recién llega.
	 * <br>
	 * <b>Pre: </b> El parámetro otro debe ser distinto de null.<br>
	 * @param otro: parámetro de tipo Persona, contra el que se decidirá la prioridad.
	 * @return devuelve si el paciente que recién llega tiene prioridad contra un joven.
	 */

	@Override
	public boolean prioridad(Paciente otro) {
		return otro.prioridadJoven();
	}
	
	/**
	 * Se sobreescribe método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un niño que recién ingresa a la clínica.
	 * @return verdadero. Se tiene prioridad contra un niño.
	 */
	
	@Override
	public boolean prioridadNiño() {
		return true;
	}

	/**
	 * Se sobreescribe método que decide si el paciente que ya está en la sala privada tiene prioridad de quedarse allí, contra un joven que recién ingresa a la clínica.
	 * @return falso. no se tiene prioridad contra un joven.
	 */
	
	@Override
	public boolean prioridadJoven() {
		return false;
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
