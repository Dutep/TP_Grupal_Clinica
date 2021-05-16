package modelo;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase representa una habitacion compartida, extiende de habitacion.
 */
public class Compartida extends Habitacion {

	private static double costoCompartida = 0;
	/**
	 * Constructor con un parametro para setear la habitacion compartida.
	 * <br>
	 * <b> Pre: </b> El parámetro numeroHabitacion debe ser un número entero positivo.
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
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
	/**
	 * Modulo que devuelve el costo de una habitacion compartida segun los dias más el costo de asginación.
	 * <br>
	 * <b> Pre: </b> El parámetro dias debe ser positivo.
	 * @param dias: parametro de tipo int que representa los dias que estuvo el paciente. 
	 * @return devuelve costo de la habitacion compartida multiplicado por la cantidad de dias más el costo de asiganción.
	 * 
	 */
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + costoCompartida * dias;
	}

}
