package modelo;

import decorators.IMedico;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una consulta médica realizada por un paciente, se extiende de la clase Prestación.
 */
public class ConsultaMedica extends Prestacion {
	private IMedico medico;
	private static double valorConsulta = 800;
	private static double porcentajeExtra = 1.2;

	/**
     * Constructor con dos parametros para setear la cantidad de consultas y el médico que las atendió.<br>
     * <b> Pre: </b> El parámetro cantidad debe ser entero positivo. <br>
     * @param cantidad : parametro de tipo int que representa la cantidad de consultas realizadas por el medico.
     * @param medico : parametro de tipo IMedico que representa el médico que atendió la consulta.
     */
	public ConsultaMedica(int cantidad, IMedico medico) {
		super(cantidad);
		this.medico = medico;
		super.subtotal = ConsultaMedica.valorConsulta * cantidad + this.medico.getHonorario() * ConsultaMedica.porcentajeExtra;
	}
	
	public IMedico getMedico() {
		return medico;
	}

	public static void setValorConsulta(double valor) {
		ConsultaMedica.valorConsulta = valor;
	}
	
	public static void setPorcentajeExtra(double porcentaje) {
		ConsultaMedica.porcentajeExtra = 1 + porcentaje/100;
	}
	
	@Override
	public String toString() {
		return this.medico.getNombre() + " \t\t " + ConsultaMedica.valorConsulta + " \t\t " + super.getCantidad() + " \t\t " + super.subtotal + "\n";
	}

	@Override
	public long getPrestacion() {
		return this.medico.getNroMatricula();
	}

}
