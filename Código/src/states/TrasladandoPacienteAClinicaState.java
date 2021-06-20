package states;

public class TrasladandoPacienteAClinicaState implements IState {
	private Ambulancia ambulancia;
	
	
	public TrasladandoPacienteAClinicaState(Ambulancia ambulancia) {

		this.ambulancia = ambulancia;
	}

	@Override
	public String solicitaAtencionDomicilio() {
		return "Imposible realizar esa acción. Se está trasladando un paciente a la clínica.";
	}

	@Override
	public String solicitaTrasladoClinica() {
		return "Imposible realizar esa acción. Ya se está trasladando un paciente a la clínica.";
	}

	@Override
	public String esTiempoDeVolverALaClinica() {
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		return "Disponible en la clínica.";
	}

	@Override
	public String solicitaRepararAmbulancia() {
		return "Imposible realizar esa acción. Se está trasladando un paciente a la clínica.";
	}



}
