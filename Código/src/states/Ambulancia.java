package states;



public class Ambulancia {
	private String Patente;
	private IState estado;
	
	private Ambulancia(String patente) {
		Patente = patente;
		this.estado = new DisponibleState(this);
	}

	public String getPatente() {
		return Patente;
	}

	public IState getEstado() {
		return estado;
	}

	public void setPatente(String patente) {
		Patente = patente;
	}

	protected void setEstado(IState estado) {
		this.estado = estado;
	}
	

	public String solicitaAtencionDomicilio() {
		return this.estado.solicitaAtencionDomicilio();
		
	}


	public String solicitaTrasladoClinica() {
		return this.estado.solicitaTrasladoClinica();
		
	}


	public String esTiempoDeVolverALaClinica() {
		return this.estado.esTiempoDeVolverALaClinica();
		
	}


	public String solicitaRepararAmbulancia() {
		return this.estado.solicitaRepararAmbulancia();
	}

	

}
