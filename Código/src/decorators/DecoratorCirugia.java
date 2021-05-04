package decorators;

public class DecoratorCirugia extends DecoratorMedico {

	public DecoratorCirugia(IMedico encapsulado)
	{
		super(encapsulado);
	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.1;
	}

}
