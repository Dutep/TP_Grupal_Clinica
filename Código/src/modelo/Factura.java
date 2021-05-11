package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Factura implements Comparable{
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();
	private Paciente paciente;
	private HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
	private double total;
	
	public Factura(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		this.calculaTotal(prestaciones);
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

	public double getTotal() {
		return this.total;
	}
	
	public HashMap<String, Prestacion> getPrestaciones() {
		return prestaciones;
	}

	private void calculaTotal(HashMap<String, Prestacion> prestaciones) {
		this.total = 0;
		for (Prestacion p : prestaciones.values()) {
			this.total += p.getSubtotal();
		}
	}
	
	@Override
	public int compareTo(Object o) {
		Factura f = (Factura) o;
		if(this.fecha.compareTo(f.getFecha()) > 0) {
			return 1;
		}
		else if (this.fecha.compareTo(f.getFecha()) < 0){
			return -1;
		}
		else {
			return (f.getNroFactura() - this.nroFactura);
		}
	}
	
	public void mostrarFactura() {
		System.out.println("Factura: \n"
		+ "prestacion \t valor \t\t cantidad \t subtotal\n");
		for (Prestacion p : prestaciones.values()) {
			System.out.println(p);
		}
		System.out.println("\t\t\t\t\t TOTAL:  " + this.total);
	}
	
}
