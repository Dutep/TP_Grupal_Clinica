package decorators;

public abstract class DecoratorMedico implements IMedico{
	
	protected IMedico encapsulado;

	public DecoratorMedico(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	@Override
	public long getNroMatricula() {
		return this.encapsulado.getNroMatricula();
	}
	
	@Override
	public String getNombre() {
		return this.encapsulado.getNombre();
	}
	
}
