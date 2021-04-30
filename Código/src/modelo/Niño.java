package modelo;

public class Ni�o extends Paciente {

	public Ni�o(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,
			long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
		// TODO Auto-generated constructor stub
	}

	public boolean prioridad(Paciente otro) {
		return otro.prioridadNi�o();
	}
	
	@Override
	public boolean prioridadNi�o() {
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

	
