package modelo;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase representa una habitacion privada, extiende de habitacion.
 */
public class Privada extends Habitacion {

	private static double costoPrivada = 0;
	/**
	 * Constructor con un parametro para setear la habitacion privada.
	 * <br>
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
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
	/**
	 * Modulo que devuelve el costo de una habitacion privada segun los dias más el costo de asginación.
	 * <br>
	 * <b> Pre: </b> El parámetro dias debe ser positivo.
	 * @param dias: parametro de tipo int que representa los dias que estuvo el paciente. 
	 * @return devuelve costo de la habitacion privada más el costo de asginacion si estuvo un dia <br>
	 * o devuelve costo de la habitacion privada multiplicada por la cantidad de dias y por 1,3 si estuvo entre 2 y 5 dias,  más el costo de asginación <br>
	 * o devuelve costo de la habitacion privada multiplicada por la cantidad de dias y por 2 si estuvo más de 5 dias,  más el costo de asginación <br>
	 * 
	 */
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
