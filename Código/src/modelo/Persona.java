package modelo;

public abstract class Persona {
	private String dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String ciudad;
	private String telefono;
	
	
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
