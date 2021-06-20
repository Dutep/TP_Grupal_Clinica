package decorators;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Se utiliza el Patrón Decorator.
 *Clase abstacta padre de todos los decoradores de medico
 */
public abstract class DecoratorMedico implements IMedico{

    /**
     * @aggregation shared
     */
    protected IMedico encapsulado;
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorMedico(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	@Override
	public long getNroMatricula() {
		return this.encapsulado.getNroMatricula();
	}
	
	@Override
	public String getNombre() {
		return this.encapsulado.getNombre();
	}
	
}
