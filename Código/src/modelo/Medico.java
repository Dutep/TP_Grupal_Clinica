package modelo;

import decorators.IMedico;

public class Medico extends Persona implements IMedico{
	
	private long nroMatricula;
	private double honorario;


	public Medico(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroMatricula) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroMatricula = nroMatricula;
		this.honorario = 10000;
	}


	public long getNroMatricula() {
		return nroMatricula;
	}


	public double getHonorario() {
		return honorario;
	}
}
