package modelo;

import java.util.HashMap;

public class Clinica {
	private static Clinica instance = null;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	private Paciente salaPrivada;
	private HashMap<Long,Paciente> patio = new HashMap<Long,Paciente>();
	private HashMap<Long,Habitacion> habitaciones = new HashMap<Long,Habitacion>();
	
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Colón 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
	}
	
	public static Clinica getInstance() {
		if (Clinica.instance == null) {
			Clinica.instance = new Clinica();
		}
		return instance;
	}
	
	
}
