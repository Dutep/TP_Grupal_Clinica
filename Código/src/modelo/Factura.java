package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import decorators.IMedico;

public class Factura {
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();
	private Paciente paciente;
	private IMedico medico;
	private Habitacion habitacion;
	private int cantDias;
	private int cantConsultas;
	private double SubtotalConsultas;
	private double SubtotalInternación;
	
	public Factura(Paciente paciente, IMedico medico, Habitacion habitacion,
			int cantDias, int cantConsultas) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.medico = medico;
		this.habitacion = habitacion;
		this.cantDias = cantDias;
		this.cantConsultas = cantConsultas;
		this.SubtotalConsultas = this.medico.getHonorario() * 1.2 * cantConsultas;
		this.SubtotalInternación = this.habitacion.getCosto(cantDias);
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public IMedico getMedico() {
		return medico;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public int getCantDias() {
		return cantDias;
	}

	public int getCantConsultas() {
		return cantConsultas;
	}

	@Override
	public String toString() {
		return "Factura: \n"
			+ "prestacion \t valor \t\t cantidad \t subtotal\n"
			+ this.medico.getNombre() + " \t\t " + this.medico.getHonorario() * 1.2 + " \t " + this.cantConsultas + " \t\t " + this.SubtotalConsultas + "\n"
			+ this.habitacion.getNumeroHabitacion() + " \t\t " + this.habitacion.getCostoHabitacion() + " \t " + this.cantDias + " \t\t " + this.SubtotalInternación;
	}
	
	
}
