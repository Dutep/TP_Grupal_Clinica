package modelo;

public class ConsultaMedica extends Prestacion {

	private Medico medico;
	private static double valorConsulta;

	public ConsultaMedica(int cantidad, Medico medico) {
		super(cantidad);
		this.medico = medico;
		super.subtotal = ConsultaMedica.valorConsulta * cantidad;
	}
	//Posible excepcion por si no seteaste valorConsulta.
	
	public Medico getMedico() {
		return medico;
	}

	public static void setValorConsulta(double valor) {
		ConsultaMedica.valorConsulta = valor;
	}
	
	@Override
	public String toString() {
		return this.medico.getNombre() + " \t\t " + ConsultaMedica.valorConsulta + " \t " + super.getCantidad() + " \t\t " + super.subtotal + "\n";
	}

	@Override
	public long getPrestacion() {
		return this.medico.getNroMatricula();
	}

}
