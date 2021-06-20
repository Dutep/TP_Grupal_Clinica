package modelo;

public class Asociado extends Persona implements Runnable{

	public Asociado(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
	}

	@Override
	public void run() {
		
	}

}
