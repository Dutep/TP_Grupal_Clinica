package modelo;

public class Compartida extends Habitacion {

	private static double costoCompartida = 0;
	
	public Compartida(String numeroHabitacion) {
		super(numeroHabitacion);
	}
	
	public static void setCostoCompartida(double costo) {
		Compartida.costoCompartida = costo;
	}
	
	@Override
	public double getCostoHabitacion() {
		return costoCompartida;
	}

	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + costoCompartida * dias;
	}

}
