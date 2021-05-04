package modelo;

public class Privada extends Habitacion {

	public Privada(int numeroHabitacion) {
		super(numeroHabitacion);
	}

	private static final double costoPrivada = 1000;
	
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
