package modelo;

import decorators.DecoratorCirugia;
import decorators.DecoratorClinica;
import decorators.DecoratorDoctorado;
import decorators.DecoratorMagister;
import decorators.DecoratorPediatria;
import decorators.DecoratorPermanente;
import decorators.DecoratorResidente;
import decorators.IMedico;

public class MedicoFactory {

	public static IMedico getMedico(String especialidad,String contratacion,String posgrado,String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroMatricula) {

		IMedico encapsulado = new Medico(dni, nombre, apellido, domicilio, ciudad, telefono, nroMatricula);
		IMedico respuesta = null;


		if(especialidad.equals("Clinica")) {
			respuesta = new DecoratorClinica(encapsulado);
		}else if(especialidad.equals("Cirugia")) {
			respuesta = new DecoratorCirugia(encapsulado);
		}else if(especialidad.equals("Pediatria")) {
			respuesta = new DecoratorPediatria(encapsulado);
		}

		if(posgrado.equals("Doctorado")) {
			respuesta = new DecoratorDoctorado(respuesta);
		}else if(posgrado.equals("Magister")) {
			respuesta = new DecoratorMagister(respuesta);
		}

		if(contratacion.equals("Permanente")) {
			respuesta = new DecoratorPermanente(respuesta);
		}else if(contratacion.equals("Residente")) {
			respuesta = new DecoratorResidente(respuesta);
		}

		return respuesta;
	}
}
