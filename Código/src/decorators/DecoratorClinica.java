package decorators;

public class DecoratorClinica extends DecoratorMedico {

	public DecoratorClinica(IMedico encapsulado)
	{
		super(encapsulado);
	}
	
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.05;
	}

}
