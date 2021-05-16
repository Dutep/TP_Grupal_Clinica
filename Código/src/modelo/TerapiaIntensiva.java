package modelo;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase representa una habitacion de terapia intensiva, extiende de habitacion.
 */
public class TerapiaIntensiva extends Habitacion {

	private static double costoTerapiaIntensiva = 0;
	/**
	 * Constructor con un parametro para setear la habitacion de terapia intensiva.
	 * <br>
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
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
	/**
	 * Modulo que devuelve el costo de una habitacion de terapia intensiva segun los dias más el costo de asginación.
	 * <br>
	 * <b> Pre: </b> El parámetro dias debe ser positivo.
	 * @param dias: parametro de tipo int que representa los dias que estuvo el paciente. 
	 * @return devuelve costo de la habitacion compartida elevado por la cantidad de dias más el costo de asiganción.
	 * 
	 */	
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + Math.pow(costoTerapiaIntensiva, dias);
	}

}
