package modelo;

public abstract class Prestacion {

	private int cantidad;
	protected double subtotal;
	
	public double getSubtotal(){
		return this.subtotal;
	}

	public Prestacion(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	@Override
	public abstract String toString();

	public abstract long getPrestacion();
}
