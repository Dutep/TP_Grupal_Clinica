package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero
 * Clase abstracta Paciente que se extiende de Persona e implementa la interfaz IRangoEtario
 *
 */
public abstract class Paciente extends Persona implements IRangoEtario{
	private static long siguienteNumero = 0;
	private long nroHistoria;
	
	/**
	 * Constructor de la clase con 7 parametros donde se setean los atributos de un paciente, se usa super para llamar al constructor
	 * de la clase Persona.<br>
	 * <b> Pre: </b> El dni debe ser positivo y entero, debe tener al menos 7 digitos, no se debe escribir con puntos ni comas, solo numeros.
	 * El telefono debe ser entero y positivo, debe tener al menos 7 digitos (va con prefijo). El nrohistoria debe ser positivo y mayor a 0(cero)<br>
	 * <b>Post: </b> El constructor crea el objeto con los parametros dados<br> 
	 * @param dni String que representa el dni de un paciente
	 * @param nombre String que representa el nombre de un paciente
	 * @param apellido String que representa el apellido de un paciente
	 * @param domicilio String que representa el domicilio de una persona
	 * @param ciudad String que representa la ciudad de un paciente
	 * @param telefono String que representa el numero de telefono de un paciente
	 * @param nroHistoria long que representa el numero de historia clinica de un paciente
	 */
	public Paciente(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroHistoria = nroHistoria;
	}

	/**
	 * Constructor de 6 parametros donde se setean los atributos de un paciente, se usa super para llamar 
	 * al constructor de la clase Persona. Se le asigna el nroHistoia (numero de historia clinica) con el numero correspondiente<br>
	 * <b> Pre: </b> El dni debe ser positivo y entero, debe tener al menos 7 digitos, no se debe escribir con puntos ni comas, solo numeros.
	 * El telefono debe ser entero y positivo, debe tener al menos 7 digitos (va con prefijo). <br>
	 * <b>Post: </b> Se crea el obejeto con los parametros dados<br>
	 * @param dni String que representa el dni de un paciente
	 * @param nombre String que representa el nombre de un paciente
	 * @param apellido String que representa el apellido de un paciente
	 * @param domicilio String que representa el domicilio de una persona
	 * @param ciudad String que representa la ciudad de un paciente
	 * @param telefono String que representa el numero de telefono de un paciente
	 */
	public Paciente(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		Paciente.siguienteNumero++;
		this.nroHistoria = Paciente.siguienteNumero;
	}
	
	public long getNroHistoria() {
		return nroHistoria;
	}

	/**
	 * Se sobreescribe el metodo equals. Compara un paciente con otro a traves de su dni, si ambos tienen el mismo numero de dni
	 * significa que son la misma persona, caso contrario no lo son<br>
	 * <b> Pre: </b> El parámetro obj debe ser distinto de null.
	 * @return devuelve un boolean correspondiente a si los DNIs son iguales o no.
	 */
	@Override
	public boolean equals(Object obj) {
		Paciente otro = (Paciente) obj;
		return super.getDni().equals(otro.getDni());
	}
	
}
