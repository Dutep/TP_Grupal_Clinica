package states;

public class DisponibleState implements IState {
	private Ambulancia ambulancia;
	
	public DisponibleState(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}


	@Override
	public String solicitaAtencionDomicilio() {
		this.ambulancia.setEstado(new AtendiendoPacienteEnDomicilioState(this.ambulancia));
		return "Saliendo de la clínica hacia el domicilio.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		this.ambulancia.setEstado(new TrasladandoPacienteAClinicaState(this.ambulancia));
		return "Trasladando paciente a la clínica.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		return "La ambulancia ya se encuetra disponible en la clínica.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		this.ambulancia.setEstado(new EnElTallerState(this.ambulancia));
		return "En el taller.";
	}

}
