package decorators;

public abstract class DecoratorContratacion  implements IMedico{

	protected IMedico encapsulado;

	public DecoratorContratacion(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	
	
}
