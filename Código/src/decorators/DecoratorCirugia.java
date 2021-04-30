package decorators;

public class DecoratorCirugia extends DecoratorEspecialidades {

	public DecoratorCirugia(IMedico encapsulado)
	{
		super(encapsulado);
	}



	@Override
	public double getHonorario() {
		// TODO Auto-generated method stub
		return this.encapsulado.getHonorario() *1.1;
	}
}
