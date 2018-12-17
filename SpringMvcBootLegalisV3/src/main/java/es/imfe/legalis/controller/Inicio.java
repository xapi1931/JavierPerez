package es.imfe.legalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para el cambio de idioma,
 * simplemente redirige a página de inicio
 * @author ajurado
 *
 */
@Controller
@RequestMapping(value="/inicio")
public class Inicio {
	
	private static final String SUCCESS = "inicioAbogado";
	private static final String SUCCESS_CLIENT = "inicioCliente";

	@RequestMapping(value="/home", method=RequestMethod.GET)
    public String executeLawyer(Model model){
		return SUCCESS;
    }
	
	@RequestMapping(value="/client", method=RequestMethod.GET)
    public String executeClient(Model model){
		return SUCCESS_CLIENT;
    }

}
