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
import excepciones.NoEstaPacienteException;
import excepciones.NoHayConsultaException;
import excepciones.OrdenFechasIncorrectoException;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa a la clínica.
 */

public class Clinica {
    /**
     * @aggregation composite
     */
    private static Clinica instance = null;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;

    /**
     * @aggregation shared
     */
    private Paciente salaPrivada;
	private HashMap<String,Paciente> patio = new HashMap<String,Paciente>();
	
	private HashMap<Long,Paciente> listaAtencion = new HashMap<Long,Paciente>();
	private HashMap<Long,Habitacion> habitaciones = new HashMap<Long,Habitacion>();
	private HashMap<String,Paciente> pacientesRegistrados = new HashMap<String,Paciente>();
	private HashMap<Long,Medico> medicos = new HashMap<Long,Medico>();
	private HashMap<String,Asociado> asociados = new HashMap<String,Asociado>();

	/**
     * @aggregation composite
     */
    public Set<Factura> facturas = new TreeSet<>();

    /**
     * @aggregation shared
     */
    private Queue<Paciente> listaEspera = new LinkedList();
    
    
	public void setSalaPrivada(Paciente salaPrivada) {
		this.salaPrivada = salaPrivada;
	}

	public void setPatio(HashMap<String, Paciente> patio) {
		this.patio = patio;
	}

	public void setListaEspera(Queue<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}

	public void setListaAtencion(HashMap<Long, Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}

	public void setHabitaciones(HashMap<Long, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setPacientesRegistrados(HashMap<String, Paciente> pacientesRegistrados) {
		this.pacientesRegistrados = pacientesRegistrados;
	}

	public void setMedicos(HashMap<Long, Medico> medicos) {
		this.medicos = medicos;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}


    public HashMap<String, Asociado> getAsociados() {
		return asociados;
	}

	public void setAsociados(HashMap<String, Asociado> asociados) {
		this.asociados = asociados;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public HashMap<String, Paciente> getPatio() {
		return patio;
	}

	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}

	public HashMap<Long, Paciente> getListaAtencion() {
		return listaAtencion;
	}

	public HashMap<Long, Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public HashMap<String, Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}

	public HashMap<Long, Medico> getMedicos() {
		return medicos;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public DecimalFormat getDf() {
		return df;
	}

	
	DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * Constructor para crear la Clínica, con valores ya establecidos.
	 */
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Colón 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
		this.salaPrivada = null;
	}
	
	/**
	 * Se aplicó Patrón Singleton.
	 * Se obtiene (o se crea en caso que no esté creada) la instancia a la clínica.
	 */
	
	public static Clinica getInstance() {
		if (Clinica.instance == null) {
			Clinica.instance = new Clinica();
		}
		return instance;
	}
	
	
	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	/**
	 * Agrega un médico al Hashmap de médicos, con su número de matrícula como clave.<br>
	 * <b>Pre: </b> El parametro medico debe ser distinto de null.<br>
	 * <b>Post: </b> Se agrega un medico mas al HashMap de médicos.<br>
	 * @param medico: Parámetro que será agregado al HashMap de médicos.
	 */
	
	public void addMedico(Medico medico) {
		this.medicos.put(medico.getNroMatricula(), medico);
	}
	
	/**
	 * Módulo de ingreso de un paciente a la clínica.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null<br>
	 * <b>Post: </b> Si el paciente no estaba registrado, se lo registra con su DNI.<br>
	 * Se agrega al paciente a la lista de espera.<br>
	 * Si la sala privada estaba vacía o si el paciente entrante tiene prioridad sobre el que ya estaba allí, se lo asigna a la sala privada, si no, se lo manda al patio.
	 * @param paciente: Paciente que ingresa a la clínica.
	 */
	
	public void Ingreso(Paciente paciente) {
		if (!pacientesRegistrados.containsKey(paciente.getDni()))
			pacientesRegistrados.put(paciente.getDni(), paciente);
		listaEspera.add(paciente);
		if (this.salaPrivada == null || paciente.prioridad(salaPrivada))
			salaPrivada = paciente;
		else
			patio.put(paciente.getDni(), paciente);
	}
	
	/**
	 * Módulo que retira al paciente de la espera y lo ubica en la Lista de Pacientes en Atención.<br>
	 * <b>Pre: </b> Debe haber al menos un paciente en la lista de espera.
	 * <b>Post: </b> Se retira al siguiente paciente de la lista de espera y se lo pone en atención.
	 */
	
	public void Atencion() {
		Paciente p = listaEspera.poll();
		listaAtencion.put(p.getNroHistoria(), p);
		if (salaPrivada != null && salaPrivada.equals(p))
			salaPrivada = null;
		else
			patio.remove(p.getDni());
	}
	
	/**
	 * Módulo que elige un paciente, lo retira de la lista de atención y realiza la facturación correspondiente.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Se crea una factura, se la agrega a la lista de facturas de la clínica y se retira al paciente de la lista de atención.
	 * @param paciente: Paciente que se retira de atención y al cual se le genera la factura.
	 * @param prestaciones: Prestaciones que recibió el paciente y que figurarán en la factura.
	 */
	
	public void EgresoYFacturacion(Paciente paciente, HashMap<String, Prestacion> prestaciones) throws NoEstaPacienteException{
		if (listaAtencion.containsKey(paciente.getNroHistoria())) {
			Factura f = new Factura(paciente, prestaciones);
			this.facturas.add(f);
			f.mostrarFactura();
			listaAtencion.remove(paciente.getNroHistoria());
		}
		else
			throw new NoEstaPacienteException("El paciente no se encuentra en la lista de atención.");
	}
	
	/**
	 * Módulo que reporta la actividad de un médico entre dos fechas dadas, enumerando los pacientes atendidos.<br>
	 * <b>Pre: </b> Todos los parámetros deben ser distintos de null.<br>
	 * <b>Post: </b> Se muestran las facturas correspondientes al período dado.<br>
	 * @param medico: Médico del cual se realice el reporte de actividad.
	 * @param fecha1: Fecha desde la cual se solicita el reporte.
	 * @param fecha2: Fecha hasta la cual se solicita el reporte.
	 */
	
	public void ReporteActividadMedica(IMedico medico, Calendar fecha1, Calendar fecha2) throws NoHayConsultaException, OrdenFechasIncorrectoException {
		if (fecha1.compareTo(fecha2) <= 0) {
			Iterator<Factura> itFacturas = facturas.iterator();
			Factura f1 =  null;
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
			if(f1 != null && f1.getPrestaciones().containsKey(medico.getNombre()) && f1.getFecha().compareTo(fecha2) < 0) {
				System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
				total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
			}
			if (total != 0)
				System.out.println("Total= " + total);
			else
				throw new NoHayConsultaException("No hay ninguna consulta entre esas fechas.");
		}
		else
			throw new OrdenFechasIncorrectoException("El orden de las fechas ingresadas es incorrecto.");
	}
	
}