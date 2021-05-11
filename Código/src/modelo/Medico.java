package modelo;

import decorators.IMedico;

public class Medico extends Persona implements IMedico{
	
	private long nroMatricula;
	private static double honorarioBase;


	public Medico(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroMatricula) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroMatricula = nroMatricula;
	}

	public static void setHonorarioBase(double h) {
		Medico.honorarioBase = h;
	}
	
	@Override
	public long getNroMatricula() {
		return nroMatricula;
	}

	@Override
	public double getHonorario() {
		return honorarioBase;
	}
}
