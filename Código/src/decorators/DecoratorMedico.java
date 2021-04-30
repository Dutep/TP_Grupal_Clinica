package decorators;

public abstract class DecoratorMedico implements IMedico{
	
	protected IMedico encapsulado;

	public DecoratorMedico(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
}
