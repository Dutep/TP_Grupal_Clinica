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
	/**
     *Metodo estático que genera una instancia de IMedico y lo decora de acuerdo a los parámetros recibidos.<br>
     *<b>Pre: </b> Los parámetros de tipo String deben ser distintos de null y no deben estar vacios.
     *nroMatricula debe ser entero positivo.<br>
     *<b>Post: </b> Se crea una instancia decorada de IMedico.<br>
     *@param especialidad : parámetro de tipo String que representa la especialidad del médico a crear. 
     *@param contratacion : parámetro de tipo String que representa el tipo de contratación del médico a crear. 
     *@param posgrado : parámetro de tipo String que representa el tipo de posgrado del médico a crear.
     *@param dni : parámetro de tipo String que representa el dni del médico a crear.
     *@param nombre : parámetro de tipo String que representa el nombre del médico a crear.
     *@param apellido : parámetro de tipo String que representa el apellido del médico a crear.
     *@param domicilio : parámetro de tipo String que representa el domicilio del médico a crear.
     *@param ciudad : parámetro de tipo String que representa la ciudad del médico a crear.
     *@param telefono : parámetro de tipo String que representa el número de teléfono del médico a crear.
     *@param nroMatricula : parámetro de tipo long que representa número de matricula particular del médico a crear.
     *@return IMedico con todos sus atributos y decoradores correspondientes indicados.
     */
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
