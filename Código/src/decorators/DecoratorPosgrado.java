package decorators;

public abstract class DecoratorPosgrado implements IMedico{

	protected IMedico encapsulado;

	public DecoratorPosgrado(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	
	
}
