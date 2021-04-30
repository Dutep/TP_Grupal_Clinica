package modelo;

public class Mayor extends Paciente {

	public Mayor(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,
			long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean prioridad(Paciente otro) {
		return otro.prioridadMayor();
	}

	@Override
	public boolean prioridadNiño() {
		return false;
	}

	@Override
	public boolean prioridadJoven() {
		return true;
	}

	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
