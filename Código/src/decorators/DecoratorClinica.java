package decorators;

public class DecoratorClinica extends DecoratorEspecialidades {

	public DecoratorClinica(IMedico encapsulado)
	{
		super(encapsulado);
	}
	


	@Override
	public double getHonorario() {
		// TODO Auto-generated method stub
		return this.encapsulado.getHonorario() *1.05;
	}

}
