package decorators;

public class DecoratorPermanente extends DecoratorMedico {

	public DecoratorPermanente(IMedico encapsulado) {
		super(encapsulado);

	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.1;
	}
	
}
