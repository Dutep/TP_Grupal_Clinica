package decorators;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase decoradora que representa la especialidad en clinica
 */
public class DecoratorClinica extends DecoratorMedico {
	
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorClinica(IMedico encapsulado)
	{
		super(encapsulado);
	}
	/**
	 * Devuelve el honorario del con un aumento del 5% por su especialidad en clinica
	 * @return el honorario del medico más el 5% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.05;
	}

}
