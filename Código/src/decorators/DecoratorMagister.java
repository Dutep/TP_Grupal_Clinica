package decorators;

public class DecoratorMagister extends DecoratorPosgrado {
	
	public DecoratorMagister(IMedico encapsulado) {
		super(encapsulado);
	
	}

	@Override
	public double getHonorario() {
	
		return this.encapsulado.getHonorario() * 1.05;
	}
	
}
