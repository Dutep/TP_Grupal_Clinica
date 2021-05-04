package modelo;

public abstract class Habitacion {
	
	protected static final double costoAsignacion = 1000;
	private int numeroHabitacion;
	
	public Habitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public static double getCostoasignacion() {
		return costoAsignacion;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	public abstract double getCostoHabitacion();
	
	public abstract double getCosto(int dias);
	
	
}
