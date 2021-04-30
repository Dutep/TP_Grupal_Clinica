package modelo;

public class Joven extends Paciente {

	public Joven(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,
			long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean prioridad(Paciente otro) {
		return otro.prioridadJoven();
	}
	

	@Override
	public boolean prioridadNiño() {
		return true;
	}

	@Override
	public boolean prioridadJoven() {
		return false;
	}

	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
