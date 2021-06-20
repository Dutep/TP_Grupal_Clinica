package states;

public class TrasladandoPacienteAClinicaState implements IState {
	private Ambulancia ambulancia;
	
	
	public TrasladandoPacienteAClinicaState(Ambulancia ambulancia) {

		this.ambulancia = ambulancia;
	}

	@Override
	public String solicitaAtencionDomicilio() {
		return "Imposible realizar esa acci�n. Se est� trasladando un paciente a la cl�nica.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acci�n. Ya se est� trasladando un paciente a la cl�nica.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		return "Disponible en la cl�nica.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		return "Imposible realizar esa acci�n. Se est� trasladando un paciente a la cl�nica.";
	}



}
