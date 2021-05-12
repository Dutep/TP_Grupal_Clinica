package modelo;

public abstract class Paciente extends Persona implements IRangoEtario{
	private static long siguienteNumero = 0;
	private long nroHistoria;
	
	public Paciente(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroHistoria = nroHistoria;
	}

	public Paciente(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		Paciente.siguienteNumero++;
		this.nroHistoria = Paciente.siguienteNumero;
	}
	
	public long getNroHistoria() {
		return nroHistoria;
	}

	@Override
	public boolean equals(Object obj) {
		Paciente otro = (Paciente) obj;
		return super.getDni().equals(otro.getDni());
	}
	
	

}
