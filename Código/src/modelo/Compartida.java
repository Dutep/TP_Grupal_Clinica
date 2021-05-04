package modelo;

public class Compartida extends Habitacion {

	public Compartida(int numeroHabitacion) {
		super(numeroHabitacion);
	}

	private static final double costoCompartida = 500;
	
	@Override
	public double getCostoHabitacion() {
		return costoCompartida;
	}

	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + costoCompartida * dias;
	}

}
