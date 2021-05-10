package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Clinica {
	private static Clinica instance = null;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	private Paciente salaPrivada;
	private HashMap<String,Paciente> patio = new HashMap<String,Paciente>();
	private Queue<Paciente> listaEspera = new LinkedList();
	private HashMap<Long,Paciente> listaAtencion = new HashMap<Long,Paciente>();
	private HashMap<Long,Habitacion> habitaciones = new HashMap<Long,Habitacion>();
	private HashMap<String,Paciente> pacientesRegistrados = new HashMap<String,Paciente>();
	private HashMap<Long,Medico> medicos = new HashMap<Long,Medico>();
	
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Colón 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
		this.salaPrivada = null;
	}
	
	public static Clinica getInstance() {
		if (Clinica.instance == null) {
			Clinica.instance = new Clinica();
		}
		return instance;
	}
	
	
	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	public void addMedico(Medico medico) {
		this.medicos.put(medico.getNroMatricula(), medico);
	}
	
	public void Ingreso(Paciente paciente) {
		if (!pacientesRegistrados.containsKey(paciente.getDni())) 
			pacientesRegistrados.put(paciente.getDni(), paciente);
		listaEspera.add(paciente);
		if (this.salaPrivada == null || paciente.prioridad(salaPrivada))
			salaPrivada = paciente;
		else
			patio.put(paciente.getDni(), paciente);
	}
	
	//Usar un único parámetro para los HashMaps. DNI o NroHistoria.
	
	public void Atencion() {
		Paciente p = listaEspera.poll();
		listaAtencion.put(p.getNroHistoria(), p);
		if (salaPrivada.equals(p))
			salaPrivada = null;
		else
			patio.remove(p.getDni());
	}
	
	public void EgresoYFacturacion(Paciente paciente, ArrayList<Prestacion> prestaciones) {
		listaAtencion.remove(paciente.getNroHistoria()); //Exception para verificar
	}
	
	
}