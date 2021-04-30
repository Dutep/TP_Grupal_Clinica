package modelo;

public class Paciente extends Persona {
	private long nroHistoria;
	private String rangoEtario;
	
	public Paciente(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroHistoria, String rangoEtario) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroHistoria = nroHistoria;
		this.rangoEtario = rangoEtario;
	}

	public long getNroHistoria() {
		return nroHistoria;
	}

	public String getRangoEtario() {
		return rangoEtario;
	}
	
	
	
}
