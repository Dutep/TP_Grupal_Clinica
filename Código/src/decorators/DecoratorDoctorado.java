package decorators;

public class DecoratorDoctorado extends DecoratorMedico {

	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);

	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.1;
	}
	
}
