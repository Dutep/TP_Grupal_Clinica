package modelo;

public class Niño extends Paciente {

	public Niño(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,
			long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
		// TODO Auto-generated constructor stub
	}

	public boolean prioridad(Paciente otro) {
		return otro.prioridadNiño();
	}
	
	@Override
	public boolean prioridadNiño() {
		return false;
	}

	@Override
	public boolean prioridadJoven() {
		return false;
	}

	@Override
	public boolean prioridadMayor() {
		return true;
	}
}

	
