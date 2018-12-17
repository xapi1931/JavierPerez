package es.imfe.legalis.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.CasoSvc;
import es.imfe.legalis.service.ClienteSvc;

//Indica que se trata de un controlador
@Controller
@RequestMapping(value="/listar")
public class Listar {
		
	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS_CLIENTS = "resultadoClientes";
	private static final String SUCCESS_LAWYERS = "resultadoAbogados";
	private static final String SUCCESS_CASES = "resultadoCasos";
	private static final String ERROR = "error";
	
	//Autoinyección del servicio
	@Autowired
	private AbogadoSvc aSvc;	
	
	@Autowired
	private ClienteSvc cSvc;	

	@Autowired
	private CasoSvc casoSvc;
	
	@Autowired  
    private MessageSource messageSource;	
	
	
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
    public String executeClient(Model model){
    	try {
			model.addAttribute(ATT_LISTA, cSvc.listar());
			
			return SUCCESS_CLIENTS;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
    }
	
		@RequestMapping(value="/abogados", method=RequestMethod.GET)
	    public String executeLawyer(Model model){
	    	try {	    		
				model.addAttribute(ATT_LISTA, aSvc.listar());
				
				return SUCCESS_LAWYERS;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	    }
		
		@RequestMapping(value="/casos", method=RequestMethod.GET)
	    public String executeCase(Model model){
	    	try {	    		
				model.addAttribute(ATT_LISTA, casoSvc.listar());
				
				return SUCCESS_CASES;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	    }
		
		@RequestMapping(value="/misCasos", method=RequestMethod.GET)
	    public String executeMyCase(@RequestParam Integer idCliente, Model model, Locale locale){
	    	try {	
	    		if (idCliente != null) {
	    			model.addAttribute(ATT_LISTA, casoSvc.buscarPorIdCliente(idCliente));
	    		}else {
	    			//Mensaje de éxito
					model.addAttribute(ATT_ERROR, messageSource.getMessage("mensaje.lista.vacia", null, locale));
	    		}
			
				
				return SUCCESS_CASES;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	    }

}
