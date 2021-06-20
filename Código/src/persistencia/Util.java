package persistencia;

import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

import modelo.Asociado;
import modelo.Clinica;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Medico;
import modelo.Paciente;

public class Util
{
       
    public static ClinicaDTO clinicaDTOFromCLinica() 
    {
	ClinicaDTO respuesta = new ClinicaDTO();
	String nombre = Clinica.getInstance().getNombre();
	String direccion = Clinica.getInstance().getDireccion();
	String telefono = Clinica.getInstance().getTelefono();
	String ciudad = Clinica.getInstance().getCiudad();
	Paciente salaPrivada = Clinica.getInstance().getSalaPrivada();
	HashMap<String,Paciente> patio = Clinica.getInstance().getPatio();
	HashMap<Long,Paciente> listaAtencion = Clinica.getInstance().getListaAtencion();
	HashMap<Long,Habitacion> habitaciones = Clinica.getInstance().getHabitaciones();
	HashMap<String,Paciente> pacientesRegistrados = Clinica.getInstance().getPacientesRegistrados();
	HashMap<Long,Medico> medicos = Clinica.getInstance().getMedicos();
	Set<Factura> facturas = Clinica.getInstance().getFacturas();
	Queue<Paciente> listaEspera = Clinica.getInstance().getListaEspera();
	HashMap<String,Asociado> asociados = Clinica.getInstance().getAsociados();
	respuesta.setNombre(nombre);
	respuesta.setDireccion(direccion);
	respuesta.setTelefono(telefono);
	respuesta.setCiudad(ciudad);
	respuesta.setSalaPrivada(salaPrivada);
	respuesta.setPatio(patio);
	respuesta.setListaAtencion(listaAtencion);
	respuesta.setHabitaciones(habitaciones);
	respuesta.setPacientesRegistrados(pacientesRegistrados);
	respuesta.setMedicos(medicos);
	respuesta.setFacturas(facturas);
	respuesta.setListaEspera(listaEspera);
	respuesta.setAsociados(asociados);
	return respuesta;
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
	Clinica.getInstance().setSalaPrivada(clinicaDTO.getSalaPrivada());
	Clinica.getInstance().setPatio(clinicaDTO.getPatio());
	Clinica.getInstance().setListaAtencion(clinicaDTO.getListaAtencion());
	Clinica.getInstance().setHabitaciones(clinicaDTO.getHabitaciones());
	Clinica.getInstance().setPacientesRegistrados(clinicaDTO.getPacientesRegistrados());
	Clinica.getInstance().setMedicos(clinicaDTO.getMedicos());
	Clinica.getInstance().setFacturas(clinicaDTO.getFacturas());
	Clinica.getInstance().setListaEspera(clinicaDTO.getListaEspera());
	Clinica.getInstance().setAsociados(clinicaDTO.getAsociados());
    }
    
    
    
    
    
}
