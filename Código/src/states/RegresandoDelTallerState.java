
package states;

public class RegresandoDelTallerState implements IState {
	private Ambulancia ambulancia;
	
	public RegresandoDelTallerState(Ambulancia ambulancia) {
		super();
		this.ambulancia = ambulancia;
	}

	@Override
	public String solicitaAtencionDomicilio() {
		return "Imposible realizar esa acción. Regresando del Taller.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acción. Regresando del Taller.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		return "Disponible en la clínica.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		return "Imposible realizar esa acción. Regresando del Taller.";
	}



}
