package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero <br>
 *	Clase abstracta que representa a una persona 
 */
public abstract class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String ciudad;
	private String telefono;
	
	
	/**
	 * Constructor de la clase, con 6 paramtros para inicializar a un objeto persona<br>
	 * <b> Pre: </b> El dni debe ser positivo y entero, debe tener al menos 7 digitos, no se debe escribir con puntos ni comas, solo numeros.
	 * El telefono debe ser entero y positivo, debe tener al menos 7 digitos (va con prefijo).
	 * <b> Post: </b> El constructor crea el objeto con los paramentros dados 
	 * @param dni String que representa el dni de una persona<br>
	 * @param nombre String que representa el nombre de una persona<br>
	 * @param apellido String que representa el apellido de una persona<br>
	 * @param domicilio String que representa el domicilio de una persona<br>
	 * @param ciudad String que representa el nombre de la ciudad de una persona<br>
	 * @param telefono String que representa el numero de telefono de una persona<br>
	 */
	public Persona(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
}
