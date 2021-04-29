package decorators;

public abstract class DecoratorEspecialidades implements IMedico{
	
	protected IMedico encapsulado;

	public DecoratorEspecialidades(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	
	public abstract void aumentoHonorario();
	
}
