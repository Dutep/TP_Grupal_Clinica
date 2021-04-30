package modelo;

public abstract class Habitacion {
	
	private static final double costoAsignacion = 1000; 
	private int numeroHabitacion;
	private int dias;
	protected double costo;
	
	public static double getCostoasignacion() {
		return costoAsignacion;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public int getDias() {
		return dias;
	}


	
	
	
	public abstract void getCosto();
	
	
	
}
