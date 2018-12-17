package es.imfe.legalis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.imfe.legalis.interceptor.LoginInterceptor;
import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.ClienteSvc;


@Controller
@SessionAttributes({LoginInterceptor.ATT_USER_LAWYER, LoginInterceptor.ATT_USER_CLIENT})
//En este caso se usuará para dos acciones, la de nuevo al cargar (view) y la de guardar desde el form (guardar)
@RequestMapping(value = "/modificar")
public class Modificar {

	private static final String ATT_ERROR = "error";
	
	private static final String SUCCESS_LAWYER = "inicioAbogado";
	private static final String SUCCESS_CLIENT = "inicioCliente";
	private static final String FORM_PASSWORD_CLIENT = "cambiarPassCliente";
	private static final String ERROR = "/error";
	
	
	@Autowired
	private ClienteSvc cSvc;
	
	@Autowired
	private AbogadoSvc aSvc;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
	 @RequestMapping(value = "/cliente", method=RequestMethod.POST)
	    public String executeClient(@ModelAttribute Cliente cliente, Model model, Locale locale) {
			try {
				//Modificamos el cliente y lo enviamos al JSP correspondiente
				cSvc.modificar(cliente);
				
				model.addAttribute(LoginInterceptor.ATT_USER_CLIENT,cliente);		
				
				return SUCCESS_CLIENT;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
	 }
	
	//modificar: modifica el abogado que se le pasa como parametro y lo lanza al JSP
		 @RequestMapping(value = "/abogado", method=RequestMethod.POST)
		    public String executeLawyer(@ModelAttribute Abogado abogado, Model model, Locale locale) {
				try {
					//Modificamos el abogado y lo enviamos al JSP correspondiente
					aSvc.modificar(abogado);
					model.addAttribute(LoginInterceptor.ATT_USER_LAWYER,abogado);	
					
					return SUCCESS_LAWYER;
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		 }
		 
		 
		//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
		 @RequestMapping(value = "/passCliente", method=RequestMethod.GET)
		    public String changeClient(@ModelAttribute Cliente cliente, Model model, Locale locale) {
				try {					
					return FORM_PASSWORD_CLIENT;
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		 }
		 
			//buscar: busca el cliente en la base de datos segun su usuario y contrase�a
		 @RequestMapping(value = "/passCliente", method=RequestMethod.POST)
		    public String execClient(@ModelAttribute Cliente cliente, Model model, Locale locale) {
				try {	
					//TODO hacer metodo para comprobar las claves
					return SUCCESS_CLIENT;
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		 }

}
