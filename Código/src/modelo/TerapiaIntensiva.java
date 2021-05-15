package modelo;

public class TerapiaIntensiva extends Habitacion {

	private static double costoTerapiaIntensiva = 0;
	
	public TerapiaIntensiva(String numeroHabitacion) {
		super(numeroHabitacion);
	}
	
	public static void setCostoTerapiaIntensiva(double costo) {
		TerapiaIntensiva.costoTerapiaIntensiva = costo;
	}
	
	@Override
	public double getCostoHabitacion() {
		return costoTerapiaIntensiva;
	}
	
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + Math.pow(costoTerapiaIntensiva, dias);
	}

}
