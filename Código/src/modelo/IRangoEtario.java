package modelo;

public interface IRangoEtario {

	
	boolean prioridad(Paciente otro);
	
	boolean prioridadNiño();
	
	boolean prioridadJoven();
	
	boolean prioridadMayor();
}
