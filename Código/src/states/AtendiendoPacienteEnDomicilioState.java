package states;

public class AtendiendoPacienteEnDomicilioState implements IState {
	private Ambulancia ambulancia;
	
	
	
	public AtendiendoPacienteEnDomicilioState(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}

	@Override
	public String solicitaAtencionDomicilio() {
		return "Imposible realizar esa acci�n. Se est� atendiendo un paciente en su domicilio";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acci�n. Se est� atendiendo un paciente en su domicilio";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		return "Regresando de una atenci�n a domicilio sin paciente.";
		
	}

	@Override
	public String solicitaRepararAmbulancia() {
		this.ambulancia.setEstado(new RegresandoDeDomicilioSinPacienteState(this.ambulancia));
		return "Imposible realizar esa acci�n. Se est� atendiendo un paciente en su domicilio";
	}


}
