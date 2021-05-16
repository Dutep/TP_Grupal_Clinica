package modelo;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero
 * Clase abstracta de una Prestacion
 *
 */
public abstract class Prestacion {

	private int cantidad;
	protected double subtotal;
	
	/**
	 * Constructor de un unico parametro, se incializa el atributo cantidad con la cantidad pasada por parametro<br>
	 * <b>Pre: </b> El parametro cantidad debe ser positivo.<br>
	 * <b>Post: </b> Se setea la cantidad de la prestacion<br>
	 * @param cantidad int que representa la cantidad de una prestacion(en el caso de una consulta sera la cantidad de consultas, en caso
	 * de una internacion sera la cantidad de dias internado)<br>
	 */
	public Prestacion(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal(){
		return this.subtotal;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 *Se sobreescribe el metodo toString de la clase object y se lo pone de tipo abstract para que luego se deba implementar 
	 *en las clases hijas de Prestacion.<br>
	 */
	@Override
	public abstract String toString();

	/**
	 * Metodo abstract que debe implementarse en las clases hijas de Prestacion, retornara la prestancion dada<br>
	 */
	public abstract long getPrestacion();
}
