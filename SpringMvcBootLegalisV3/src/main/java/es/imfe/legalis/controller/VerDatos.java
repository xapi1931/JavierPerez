package es.imfe.legalis.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Indica que se trata de un controlador
@Controller
@RequestMapping(value="/datos")
public class VerDatos {
		
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS_CLIENT = "verCliente";
	private static final String SUCCESS_LAWYER = "verAbogado";
	private static final String ERROR = "error";
	

	//Trayectoria y método (al ser un GET desde navegador o link)
	//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
	@RequestMapping(value="/cliente", method=RequestMethod.GET)
    public String executeClient(Model model){
    	try {
    	
			return SUCCESS_CLIENT;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
	//Trayectoria y método (al ser un GET desde navegador o link)
		//Los métodos del controlador los definimos nosotros, podemos poner el nombre o parámetros que queramos
		@RequestMapping(value="/abogado", method=RequestMethod.GET)
	    public String executeLawyer(Model model){
	    	try {
	    		
				return SUCCESS_LAWYER;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	    }

}
