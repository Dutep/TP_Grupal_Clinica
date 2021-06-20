package modelo;

public class MedicoCirujano extends Medico {

	public MedicoCirujano(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,
			long nroMatricula) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroMatricula);
	}
	
	@Override
	public double getHonorario() {
		return super.getHonorario() *1.1;
	}
}
