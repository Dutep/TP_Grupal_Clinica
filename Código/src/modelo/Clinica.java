package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
	public Set<Factura> facturas = new TreeSet<>();
	
	DecimalFormat df = new DecimalFormat("#.00");
	
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
		Factura f1 =  null;
		//Posible exception por si te pasan la fecha2 < fecha1
		double total = 0;
		
		boolean condicion = true;
		while (itFacturas.hasNext() && condicion) {
			f1 = itFacturas.next();
			if (f1.getFecha().compareTo(fecha1) >= 0) {
				condicion = false;
			}
		}
		condicion = true;
		
		System.out.println("Paciente \t Cantidad de consultas \t Honorario total \t Fecha");
		while (itFacturas.hasNext() && condicion && f1.getFecha().compareTo(fecha2) < 0) {
			if(f1.getPrestaciones().containsKey(medico.getNombre())) {
				System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
				total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
			}
			f1 = itFacturas.next();
			if (f1.getFecha().compareTo(fecha2) > 0) {
				condicion = false;
			}
		}
		if(f1.getPrestaciones().containsKey(medico.getNombre()) && f1.getFecha().compareTo(fecha2) < 0) {
			System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
			total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
		}
		System.out.println("Total= " + total);
	}
	
}