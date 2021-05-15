package decorators;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase decoradora que representa la especialidad en cirugia
 */
public class DecoratorCirugia extends DecoratorMedico {

	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorCirugia(IMedico encapsulado)
	{
		super(encapsulado);
	}

	/**
	 * Devuelve el honorario del con un aumento del 10% por su especialidad en cirujia
	 * @return el honorario del medico más el 10% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() *1.1;
	}

}
