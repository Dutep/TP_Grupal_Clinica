package modelo;

public class Internacion extends Prestacion {

	private Habitacion habitacion;

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
