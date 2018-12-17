package es.imfe.legalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.Caso;
import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.CasoSvc;
import es.imfe.legalis.service.ClienteSvc;

@Controller
@RequestMapping(value="/eliminar")
public class Eliminar {
	

	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS_CLIENT = "resultadoClientes";
	private static final String SUCCESS_LAWYER = "resultadoAbogados";
	private static final String SUCCESS_CASE = "resultadoCasos";
	private static final String ERROR = "error";
	
	@Autowired
	private ClienteSvc cSvc;
	
	@Autowired
	private AbogadoSvc aSvc;

	@Autowired
	private CasoSvc caseSvc;


	@RequestMapping(value="/cliente", method=RequestMethod.GET)
    public String executeClient(@RequestParam int idCliente, Model model){//, HttpServletRequest request) {
    	try {
			//No es necesario acceder al request para el parámetro, directamente lo paso por el método
//			String id = Integer.parseInt(request.getParameter("id"));
    		Cliente cliente =  cSvc.buscarPorIdCliente(idCliente);
    		if (cliente != null) {
    			 cSvc.eliminar(cliente);
    		}
			//Incluir elementos para la selección porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, cSvc.listar());
			
			return SUCCESS_CLIENT;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value="/abogado", method=RequestMethod.GET)
    public String executeLawyer(@RequestParam int numColegiado, Model model){//, HttpServletRequest request) {
    	try {
			//No es necesario acceder al request para el parámetro, directamente lo paso por el método
//			String id = Integer.parseInt(request.getParameter("id"));
    		Abogado abogado =  aSvc.buscarPorNumColegiado(numColegiado);
    		if (abogado != null) {
    			 aSvc.eliminar(abogado);
    		}
			//Incluir elementos para la selección porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, aSvc.listar());
			
			return SUCCESS_LAWYER;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
	@RequestMapping(value="/caso", method=RequestMethod.GET)
    public String executeCase(@RequestParam int numCaso, Model model){//, HttpServletRequest request) {
    	try {
			//No es necesario acceder al request para el parámetro, directamente lo paso por el método
//			String id = Integer.parseInt(request.getParameter("id"));
    		Caso caso =  caseSvc.buscarPorNumCaso(numCaso);
    		if (caso != null) {
    			caseSvc.eliminar(caso);
    		}
			//Incluir elementos para la selección porque vamos hacia el formulario
			model.addAttribute(ATT_LISTA, caseSvc.listar());
			
			return SUCCESS_CASE;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }

}
