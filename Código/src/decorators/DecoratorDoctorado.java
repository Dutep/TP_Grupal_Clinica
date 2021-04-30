package decorators;

public class DecoratorDoctorado extends DecoratorPosgrado {

	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);
	
	}

	@Override
	public double getHonorario() {
	
		return this.encapsulado.getHonorario() * 1.1;
	}

}
