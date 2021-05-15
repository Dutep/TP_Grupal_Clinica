package prueba;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import decorators.IMedico;
import excepciones.NoEstaPacienteException;
import excepciones.NoHayConsultaException;
import excepciones.OrdenFechasIncorrectoException;
import modelo.Clinica;
import modelo.Compartida;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Habitacion;
import modelo.Internacion;
import modelo.Joven;
import modelo.Mayor;
import modelo.Medico;
import modelo.MedicoFactory;
import modelo.Paciente;
import modelo.Prestacion;
import modelo.Privada;
import modelo.TerapiaIntensiva;

public class PruebaClinica {

	public static void main(String[] args) {
		
		Habitacion.setCostoAsignacion(1000);
		Compartida.setCostoCompartida(500);
		Privada.setCostoPrivada(1000);
		TerapiaIntensiva.setCostoTerapiaIntensiva(1500);
		ConsultaMedica.setValorConsulta(800);
		ConsultaMedica.setPorcentajeExtra(90);
		Medico.setHonorarioBase(1200);
		
		IMedico Medico1 = MedicoFactory.getMedico("Pediatria","Residente","Magister", "11234532", "Pepe", "Pepe", "San Luis 1234", "Batan", "5551234", 2345);
		IMedico Medico2 = MedicoFactory.getMedico("Cirugia","Residente","Magister", "88234532", "Lolo", "Lolo", "San Juan 8234", "Miramar", "8881234", 8888);
		Habitacion h1 = new Privada("55");
		Paciente p1 = new Joven("111", "nini", "nono", "112233", "mdp", "123", 123123);
		Paciente p2 = new Mayor("222", "ninooo", "nunu", "445566", "balcarce", "456", 456456);
		
		HashMap<String, Prestacion> prestaciones1 = new HashMap<String, Prestacion>();
		HashMap<String, Prestacion> prestaciones2 = new HashMap<String, Prestacion>();
		
		ConsultaMedica consulta1 = new ConsultaMedica(3, Medico1);
		ConsultaMedica consulta2 = new ConsultaMedica(5, Medico2);
		ConsultaMedica consulta3 = new ConsultaMedica(4, Medico1);
		
		Internacion internacion1 = new Internacion(7, h1);
		Internacion internacion2 = new Internacion(6, h1);
		
		prestaciones1.put(internacion1.getHabitacion().getNumeroHabitacion(), internacion1);
		prestaciones1.put(consulta1.getMedico().getNombre(), consulta1);
		prestaciones1.put(consulta2.getMedico().getNombre(), consulta2);
		
		prestaciones2.put(consulta3.getMedico().getNombre(), consulta3);
		prestaciones2.put(internacion2.getHabitacion().getNumeroHabitacion(), internacion2);
		
		Calendar fecha1 = new GregorianCalendar(2020, 6, 26);
		Calendar fecha2 = new GregorianCalendar(2021, 12, 24);

		Clinica.getInstance().Ingreso(p1);
		Clinica.getInstance().Ingreso(p2);
		
		Clinica.getInstance().Atencion();
		Clinica.getInstance().Atencion();
		
		try {
			Clinica.getInstance().EgresoYFacturacion(p1, prestaciones1);
		} catch (NoEstaPacienteException e1) {
			System.out.println(e1.getMessage());
		}
		
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		
		try {
			Clinica.getInstance().EgresoYFacturacion(p2, prestaciones2);
		} catch (NoEstaPacienteException e3) {
			System.out.println(e3.getMessage());
		}
		
		System.out.println();
		
		try {
			Clinica.getInstance().ReporteActividadMedica(Medico1, fecha1, fecha2);
		} catch (NoHayConsultaException e4) {
			System.out.println(e4.getMessage());
		} catch (OrdenFechasIncorrectoException e4) {
			System.out.println(e4.getMessage());
		}
	}

}