package decorators;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase decoradora que representa la posgrado de Magister
 */
public class DecoratorMagister extends DecoratorMedico {
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorMagister(IMedico encapsulado) {
		super(encapsulado);

	}
	/**
	 * Devuelve el honorario del con un aumento del 5% por su posgrado de Magister
	 * @return el honorario del medico m�s el 5% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.05;
	}
	
}
