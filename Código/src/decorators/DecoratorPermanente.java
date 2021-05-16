package decorators;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase decoradora que representa la contratación permanente
 */
public class DecoratorPermanente extends DecoratorMedico {
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorPermanente(IMedico encapsulado) {
		super(encapsulado);

	}
	/**
	 * Devuelve el honorario del médico con un aumento del 10% por su contratación permanente
	 * @return el honorario del medico más el 10% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.1;
	}
	
}
