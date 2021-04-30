package decorators;

public class DecoratorPediatria extends DecoratorMedico {

	public DecoratorPediatria(IMedico encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.07;
	}
}
