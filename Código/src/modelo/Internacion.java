package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una internación de un paciente en una habitación, se extiende de la clase Prestación.
 */
public class Internacion extends Prestacion {

    /**
     * @aggregation shared
     */
    private Habitacion habitacion;
	
	/**
     * Constructor con dos parametros para setear la cantidad de consultas y la habitación en la que se lo internó.<br>
     * <b> Pre: </b> El parámetro cantidad debe ser un entero positivo.<br>
     * El parámetro habitacion debe ser distinto de null.
     * @param cantidad : parametro de tipo int que representa la cantidad de días que el paciente permaneció internado.
     * @param habitacion : parametro de tipo Habitacion que representa la habitación en la que el paciente permaneció internado.
     */
	public Internacion(int cantidad, Habitacion habitacion) {
		super(cantidad);
		this.habitacion = habitacion;
		super.subtotal = this.habitacion.getCosto(cantidad);
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}

	@Override
	public String toString() {
		return this.habitacion.getNumeroHabitacion() + " \t\t " + this.habitacion.getCosto(1) + " \t " + super.getCantidad() + " \t\t " + super.subtotal + "\n";
	}

	@Override
	public long getPrestacion() {
		return -1;
	}
}
