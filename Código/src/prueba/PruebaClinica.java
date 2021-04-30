package prueba;

import decorators.IMedico;
import modelo.Clinica;
import modelo.Joven;
import modelo.Mayor;
import modelo.MedicoFactory;
import modelo.Niño;
import modelo.Paciente;

public class PruebaClinica {

	public static void main(String[] args) {
		IMedico Medico1 = MedicoFactory.getMedico("Pediatria","Residente","Magister", "11234532", "Pepe", "Pepe", "San luis 1234", "Batan", "5551234", 2345);
		
		Paciente p1 = new Joven("111", "nini", "nono", "112233", "mdp", "123", 123123);
		Paciente p2 = new Mayor("111", "ninooo", "nono", "112233", "mdp", "123", 123123);
		
		System.out.println(Medico1.getHonorario());

		Clinica.getInstance().Ingreso(p1);
		Clinica.getInstance().Ingreso(p2);
		System.out.println(Clinica.getInstance().getSalaPrivada().getNombre());
	}

}