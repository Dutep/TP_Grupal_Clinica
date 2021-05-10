package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura {
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();
	private Paciente paciente;
	private ArrayList<Prestacion> prestaciones = new ArrayList<Prestacion>();
//	private IMedico medico;
//	private Habitacion habitacion;
//	private int cantDias;
//	private int cantConsultas;
//	private double SubtotalConsultas;
//	private double SubtotalInternación;
	private double total = 0;
	
	public Factura(Paciente paciente, ArrayList<Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.prestaciones = prestaciones;
//		this.medico = medico;
//		this.habitacion = habitacion;
//		this.cantDias = cantDias;
//		this.cantConsultas = cantConsultas;
//		this.SubtotalConsultas = this.prestaciones. getHonorario() * 1.2 * cantConsultas;
//		this.SubtotalInternación = this.habitacion.getCosto(cantDias);
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

//	public IMedico getMedico() {
//		return medico;
//	}
//
//	public Habitacion getHabitacion() {
//		return habitacion;
//	}
//
//	public int getCantDias() {
//		return cantDias;
//	}
//
//	public int getCantConsultas() {
//		return cantConsultas;
//	}

	public void mostrarFactura() {
		System.out.println("Factura: \n"
		+ "prestacion \t valor \t\t cantidad \t subtotal\n");
		for (Prestacion p : prestaciones) {
			System.out.println(p);
			this.total += p.getSubtotal();
		}
		System.out.println(this.total);
	}
	
}
