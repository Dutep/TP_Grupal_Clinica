package modelo;

import excepciones.ValorNoEstablecidoException;

public abstract class Habitacion {
	
	protected static double costoAsignacion;
	private String numeroHabitacion;
	
	public Habitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public static void setCostoAsignacion(double costo) throws ValorNoEstablecidoException{
			Habitacion.costoAsignacion = costo;
	}
	
	public static double getCostoasignacion() {
		return costoAsignacion;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	public abstract double getCostoHabitacion();
	
	public abstract double getCosto(int dias);
	
	
}
