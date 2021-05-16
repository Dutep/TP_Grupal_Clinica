package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una factura realizada a un paciente ya atendido.
 */
public class Factura implements Comparable{
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();
	private Paciente paciente;
	private HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
	private double total;
	
	/**
     * Constructor con dos parametros para setear el paciente al que se le adjudica la factura y su lista de prestaciones.<br>
     * <b> Pre: </b> El parámetro paciente debe ser distinto de null.<br>
     * <b> Post: </b> el atributo estático siguienteNumero se incrementa en 1.<br>
     * @param paciente : parámetro de tipo Paciente que representa al paciente al que se le realiza la facturación.
     * @param prestaciones : parámetro de tipo HashMap que representa un listado de las prestaciones pertenecientes al paciente.
     */
	public Factura(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		this.calculaTotal(prestaciones);
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public double getTotal() {
		return this.total;
	}
	
	public HashMap<String, Prestacion> getPrestaciones() {
		return prestaciones;
	}

	/**
     *Se calcula el total a abonar por las prestaciones tomadas.<br>
     *<b>Post: </b> Se guarda en la variable total la suma de los subtotales de cada prestación. <br>
     *@param prestaciones : parámetro de tipo HashMap que representa un listado de las prestaciones efectuadas por el paciente.
     */
	private void calculaTotal(HashMap<String, Prestacion> prestaciones) {
		this.total = 0;
		for (Prestacion p : prestaciones.values()) {
			this.total += p.getSubtotal();
		}
	}
	
	/**
     *Se compara la factura actual con otra por su fecha y, en el caso de que coincidan, por su número de factura.<br>
     *@param o : parámetro de tipo Object que representa un objeto que será casteado para su comparación.
     *@return int con el valor que determina el resultado de la comparación.
     */
	@Override
	public int compareTo(Object o) {
		Factura f = (Factura) o;
		if(this.fecha.compareTo(f.getFecha()) > 0) {
			return 1;
		}
		else if (this.fecha.compareTo(f.getFecha()) < 0){
			return -1;
		}
		else {
			return (f.getNroFactura() - this.nroFactura);
		}
	}
	
	/**
     *Se imprime la factura mostrando en cada línea: tipo, valor, cantidad y subtotal de cada prestación.
     */
	public void mostrarFactura() {
		System.out.println("Factura: \n"
		+ "prestacion \t valor \t\t cantidad \t subtotal\n");
		for (Prestacion p : prestaciones.values()) {
			System.out.println(p);
		}
		System.out.println("\t\t\t\t\t TOTAL:  " + this.total);
	}
	
}
