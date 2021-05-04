package modelo;

public class TerapiaIntensiva extends Habitacion {

	public TerapiaIntensiva(int numeroHabitacion) {
		super(numeroHabitacion);
	}

	private static final double costoTerapiaIntensiva = 2000;
	
	@Override
	public double getCostoHabitacion() {
		return costoTerapiaIntensiva;
	}
	
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + Math.pow(costoTerapiaIntensiva, dias);
	}

}
