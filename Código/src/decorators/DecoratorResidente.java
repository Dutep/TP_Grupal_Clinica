package decorators;

public class DecoratorResidente extends DecoratorMedico {

	public DecoratorResidente(IMedico encapsulado) {
		super(encapsulado);

	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.05;
	}
	
}
