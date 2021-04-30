package prueba;

import decorators.IMedico;
import modelo.MedicoFactory;

public class Prueba {

	public static void main(String[] args) {
		IMedico Medico1 = MedicoFactory.getMedico("Pediatria","Residente","Magister", "11234532", "Pepe", "Pepe", "San luis 1234", "Batan", "5551234", 2345);
		
		System.out.println(Medico1.getHonorario());

	}

}
