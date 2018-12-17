package es.imfe.legalis.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.imfe.legalis.interceptor.LoginInterceptor;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.CasoSvc;
import es.imfe.legalis.service.ClienteSvc;


@Controller
@SessionAttributes({LoginInterceptor.ATT_USER_LAWYER, LoginInterceptor.ATT_USER_CLIENT})
//En este caso se usuará para dos acciones, la de nuevo al cargar (view) y la de guardar desde el form (guardar)
@RequestMapping(value = "/editar")
public class Editar {
	
	private static final String ATT_CLIENT = "cliente";
	private static final String ATT_CASE = "caso";
	private static final String ATT_LAWYER = "abogado";
	private static final String ATT_ERROR = "error";
	
	private static final String SUCCESS_CLIENT = "modificarCliente";
	private static final String SUCCESS_CASE = "modificarCaso";
	private static final String SUCCESS_LAWYER = "modificarAbogado";
	private static final String ERROR = "/error";
	
	@Autowired
	private ClienteSvc cSvc;
	
	@Autowired
	private AbogadoSvc aSvc;
	
	@Autowired
	private CasoSvc casoSvc;

	//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
	 @RequestMapping(value = "/cliente", method=RequestMethod.GET)
	    public String executeClient(@RequestParam Integer idCliente, Model model, Locale locale) {
			try {
				if( idCliente != null ) {
					//Mandamos el cliente  al JSP de edicion		
					model.addAttribute(ATT_CLIENT, cSvc.buscarPorIdCliente(idCliente));
					
					return SUCCESS_CLIENT;
				}else {
					return ERROR;
				}			
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	 }
	
	//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
		 @RequestMapping(value = "/abogado", method=RequestMethod.GET)
		    public String executeLawyer(@RequestParam Integer numColegiado, Model model, Locale locale) {
				try {
					if (numColegiado != null){
					//Mandamos el abogado  al JSP de edicion					
					model.addAttribute(ATT_LAWYER, aSvc.buscarPorNumColegiado(numColegiado));
					return SUCCESS_LAWYER;
					}else {
						return ERROR;
					}				
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		 }
		 
		//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
		 @RequestMapping(value = "/caso", method=RequestMethod.GET)
		    public String executeCase(@RequestParam Integer numCaso, Model model, Locale locale) {
				try {
					if ( numCaso != null) {
						//Mandamos el caso  al JSP de edicion junto con los listados de clientes y abogados		
						model.addAttribute(ATT_CASE, casoSvc.buscarPorNumCaso(numCaso));
						model.addAttribute(ATT_LAWYER, aSvc.listar());
						model.addAttribute(ATT_CLIENT, cSvc.listar());
						
						return SUCCESS_CASE;
					}else {
						return ERROR;
					}
					
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		 }

}
