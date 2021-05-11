package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

import decorators.IMedico;

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
	Set<Factura> facturas = new TreeSet<>();
	
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
	
	public void EgresoYFacturacion(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura f = new Factura(paciente, prestaciones);
		this.facturas.add(f);
		f.mostrarFactura();
		listaAtencion.remove(paciente.getNroHistoria()); //Exception para verificar
	}
	
	public void ReporteActividadMedica(IMedico medico, Calendar fecha1, Calendar fecha2) {
		Iterator<Factura> itFacturas = facturas.iterator();
		//Posible exception por si te pasan la fecha2 < fecha1
		double total = 0;
		while (itFacturas.hasNext() && itFacturas.next().getFecha().compareTo(fecha1) < 0) {
			itFacturas.next();
		}
		System.out.println("Paciente \t\t Cantidad de consultas \t\t Honorario total \t\t Fecha");
		while (itFacturas.hasNext() && itFacturas.next().getFecha().compareTo(fecha2) < 0) {
			if(itFacturas.next().getPrestaciones().containsKey(medico.getNombre())) {
				System.out.println(itFacturas.next().getPaciente().getNombre() + " " + itFacturas.next().getPaciente().getApellido() + " \t\t " + itFacturas.next().getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + itFacturas.next().getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario() + " \t\t "+ itFacturas.next().getFecha());
				total += itFacturas.next().getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
			}
			itFacturas.next();
		}
		System.out.println("Total= " + total);
	}
	
}