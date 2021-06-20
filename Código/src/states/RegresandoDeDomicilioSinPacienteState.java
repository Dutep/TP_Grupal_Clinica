package states;

public class RegresandoDeDomicilioSinPacienteState implements IState {
	private Ambulancia ambulancia;
	
	public RegresandoDeDomicilioSinPacienteState(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}

	@Override
	public String solicitaAtencionDomicilio() {
		this.ambulancia.setEstado(new AtendiendoPacienteEnDomicilioState(this.ambulancia));
		return "Atendiendo paciente en domicilio.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acción. Regresando de una atención a domicilio sin paciente.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		return "Disponible en la clínica.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		return "Imposible realizar esa acción. Regresando de una atención a domicilio sin paciente.";
	}



}
