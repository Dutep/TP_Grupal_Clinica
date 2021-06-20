package states;

public class EnElTallerState implements IState {

	private Ambulancia ambulancia;
	
	public EnElTallerState(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}
	
	
	@Override
	public String solicitaAtencionDomicilio() {
		return "Imposible realizar esa acción. En el taller.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acción. En el taller.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		this.ambulancia.setEstado(new RegresandoDelTallerState(this.ambulancia));
		return "Regresando del Taller.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		return "Imposible realizar esa acción. En el taller.";
	}

	

}
