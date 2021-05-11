package prueba;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import decorators.IMedico;
import modelo.Clinica;
import modelo.Compartida;
import modelo.ConsultaMedica;
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
		Medico.setHonorarioBase(1200);
		
		IMedico Medico1 = MedicoFactory.getMedico("Pediatria","Residente","Magister", "11234532", "Pepe", "Pepe", "San Luis 1234", "Batan", "5551234", 2345);
		IMedico Medico2 = MedicoFactory.getMedico("Cirugia","Residente","Magister", "88234532", "Lolo", "Lolo", "San Juan 8234", "Miramar", "8881234", 8888);
		Habitacion h1 = new Privada("55");
		Paciente p1 = new Joven("111", "nini", "nono", "112233", "mdp", "123", 123123);
		Paciente p2 = new Mayor("111", "ninooo", "nono", "112233", "mdp", "123", 123123);
		
		HashMap<String, Prestacion> prestaciones1 = new HashMap<String, Prestacion>();
		HashMap<String, Prestacion> prestaciones2 = new HashMap<String, Prestacion>();
		
		ConsultaMedica consulta1 = new ConsultaMedica(3, Medico1);
		ConsultaMedica consulta2 = new ConsultaMedica(5, Medico2);
		Internacion internacion1 = new Internacion(7, h1);
		
		ConsultaMedica consulta3 = new ConsultaMedica(4, Medico1);
		Internacion internacion2 = new Internacion(6, h1);
		
		prestaciones1.put(internacion1.getHabitacion().getNumeroHabitacion(), internacion1);
		prestaciones1.put(consulta1.getMedico().getNombre(), consulta1);
		prestaciones1.put(consulta2.getMedico().getNombre(), consulta2);
		
		prestaciones2.put(consulta3.getMedico().getNombre(), consulta3);
		prestaciones2.put(internacion2.getHabitacion().getNumeroHabitacion(), internacion2);
		
		Calendar fecha1 = new GregorianCalendar(2020, 06, 26);
		Calendar fecha2 = new GregorianCalendar(2021, 06, 24);
		
		System.out.println(Medico1.getHonorario());

		Clinica.getInstance().Ingreso(p1);
		Clinica.getInstance().Ingreso(p2);
		System.out.println(Clinica.getInstance().getSalaPrivada().getNombre());
		Clinica.getInstance().EgresoYFacturacion(p1, prestaciones1);
		Clinica.getInstance().EgresoYFacturacion(p2, prestaciones2);
		System.out.println();
		Clinica.getInstance().ReporteActividadMedica(Medico2, fecha1, fecha2);
		System.out.println(fecha1.get(Calendar.YEAR) + " " + fecha1.get(Calendar.MONTH) + " " + fecha1.get(Calendar.DATE));
	}

}