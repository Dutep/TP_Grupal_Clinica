package modelo;

import states.Ambulancia;

public class Operario extends Persona{

	private Ambulancia ambulancia;

	public Operario(Ambulancia ambulancia,String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.ambulancia = ambulancia;
	}
	
	public void solicitaAmbulancia() {
		this.ambulancia.solicitaRepararAmbulancia();
	}
}
