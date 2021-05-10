package modelo;

public class Privada extends Habitacion {

	private static double costoPrivada;
	
	public Privada(String numeroHabitacion) {
		super(numeroHabitacion);
	}
	
	public static void setCostoPrivada(double costo) {
		Privada.costoPrivada = costo;
	}
	
	@Override
	public double getCostoHabitacion() {
		return costoPrivada;
	}
	
	@Override
	public double getCosto(int dias) {
		double resultado = 0;
		if (dias == 1) 
			resultado = costoPrivada;
		else if (dias >= 2 && dias <= 5)
			resultado = dias*costoPrivada*1.3;
		else
			resultado = dias*costoPrivada*2;
		return Habitacion.costoAsignacion + resultado;
	}

}
