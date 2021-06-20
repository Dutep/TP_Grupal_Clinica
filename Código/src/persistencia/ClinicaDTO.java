package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import modelo.Medico;
import modelo.Asociado;
import modelo.Clinica;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Paciente;

public class ClinicaDTO implements Serializable
{
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
    private HashMap<String,Asociado> asociados = new HashMap<String,Asociado>();

    public HashMap<String, Asociado> getAsociados() {
		return asociados;
	}

	public void setAsociados(HashMap<String, Asociado> asociados) {
		this.asociados = asociados;
	}

	public ClinicaDTO()
    {
    }
    
//    public ClinicaDTO(String nombre, String direccion, String telefono, String ciudad, Paciente salaPrivada,
//			HashMap<String, Paciente> patio, Queue<Paciente> listaEspera, HashMap<Long, Paciente> listaAtencion,
//			HashMap<Long, Habitacion> habitaciones, HashMap<String, Paciente> pacientesRegistrados,
//			HashMap<Long, Medico> medicos, Set<Factura> facturas) {
//		this.nombre = nombre;
//		this.direccion = direccion;
//		this.telefono = telefono;
//		this.ciudad = ciudad;
//		this.salaPrivada = salaPrivada;
//		this.patio = patio;
//		this.listaEspera = listaEspera;
//		this.listaAtencion = listaAtencion;
//		this.habitaciones = habitaciones;
//		this.pacientesRegistrados = pacientesRegistrados;
//		this.medicos = medicos;
//		this.facturas = facturas;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	public void setSalaPrivada(Paciente salaPrivada) {
		this.salaPrivada = salaPrivada;
	}

	public HashMap<String, Paciente> getPatio() {
		return patio;
	}

	public void setPatio(HashMap<String, Paciente> patio) {
		this.patio = patio;
	}

	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(Queue<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}

	public HashMap<Long, Paciente> getListaAtencion() {
		return listaAtencion;
	}

	public void setListaAtencion(HashMap<Long, Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}

	public HashMap<Long, Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(HashMap<Long, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public HashMap<String, Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}

	public void setPacientesRegistrados(HashMap<String, Paciente> pacientesRegistrados) {
		this.pacientesRegistrados = pacientesRegistrados;
	}

	public HashMap<Long, Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(HashMap<Long, Medico> medicos) {
		this.medicos = medicos;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

}
