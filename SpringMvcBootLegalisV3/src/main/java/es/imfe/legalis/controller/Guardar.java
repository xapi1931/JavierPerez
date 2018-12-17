package es.imfe.legalis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.Caso;
import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.CasoSvc;
import es.imfe.legalis.service.ClienteSvc;

@Controller
//En este caso se usuará para dos acciones, la de nuevo al cargar (view) y la de guardar desde el form (guardar)
@RequestMapping(value = "/guardar")
public class Guardar {
	
	private static final String ATT_CLIENT = "cliente";
	private static final String ATT_LAWYER = "abogado";
	private static final String ATT_CASE = "caso";
	private static final String ATT_EXITO = "msg";
	private static final String ATT_ERROR = "error";
	private static final String ATT_MSG = "msg";
	
	private static final String MSG_EXITO_LAWYER = "abogado.guardar.exito";
	private static final String MSG_ERROR = "error.general";
	
	private static final String SUCCESS_LAWYER = "nuevoAbogado";
	private static final String SUCCESS_CLIENT = "formCliente";
	private static final String SUCCESS_CASE = "formCaso";
	private static final String ERROR = "/error";
	
	@Autowired
	private AbogadoSvc aSvc;
	
	@Autowired
	private ClienteSvc cSvc;
	
	@Autowired
	private CasoSvc svc;
	
	@Autowired  
    private MessageSource messageSource;	
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/abogado", method=RequestMethod.GET)
    public String viewLawyer(@ModelAttribute Abogado abogado, Model model, Locale locale) {
		try {
			model.addAttribute(ATT_LAWYER, abogado);
			return SUCCESS_LAWYER;
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
	
	@RequestMapping(value = "/caso", method=RequestMethod.GET)
    public String viewCase(@ModelAttribute Caso caso, Model model, Locale locale) {
		try {
		
			model.addAttribute(ATT_LAWYER, aSvc.listar());
			
			model.addAttribute(ATT_CLIENT, cSvc.listar());
			
			return SUCCESS_CASE;
		} catch (Exception e) {
			model.addAttribute(ATT_MSG,
					messageSource.getMessage(MSG_ERROR, null, locale));
			return ERROR;
		}
	}
	//nuevo: simplemente guardar la lista para el select y pasar al form
			@RequestMapping(value = "/cliente", method=RequestMethod.POST)
		    public String executeClient(@ModelAttribute Cliente cliente, Model model, Locale locale) {
				try {
					//Guardamos el abogado en la DB
					cSvc.guardar(cliente);
					//Incluir elementos para la selección
					model.addAttribute(ATT_LAWYER, cSvc.buscarPorIdCliente(cliente.getIdCliente()));
					
					//Mensaje de éxito
					model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
					
					//Limpiar formulario
					model.addAttribute(ATT_CLIENT, new Cliente());
					return SUCCESS_CLIENT;
				} catch (Exception e) {
					model.addAttribute(ATT_ERROR, e);
					return ERROR;
				}
		}
			
	//nuevo: simplemente guardar la lista para el select y pasar al form
	@RequestMapping(value = "/abogado", method=RequestMethod.POST)
    public String executeLawyer(@Valid Abogado abogado, BindingResult result,  Model model, Locale locale) {
		try {
			if(result.hasErrors()) {
				return SUCCESS_LAWYER;
			}else {
				aSvc.guardar(abogado);
				//Mensaje de éxito
				model.addAttribute(ATT_MSG, messageSource.getMessage(MSG_EXITO_LAWYER, null, locale));
				
				//Limpiar formulario
				model.addAttribute(ATT_LAWYER, new Abogado());
				
				return viewLawyer(new Abogado(), model, locale);
			}
		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}

	//nuevo: simplemente guardar la lista para el select y pasar al form
		@RequestMapping(value = "/caso", method=RequestMethod.POST)
	    public String executeCase(@ModelAttribute Caso caso, Model model, Locale locale) {
			try {
				//Guardamos el caso en la DB
				svc.guardar(caso);
				//Incluir elementos para la selección
				model.addAttribute(ATT_CASE, svc.buscarPorNumCaso(caso.getNumCaso()));
				
				//Mensaje de éxito
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));
				
				//Limpiar formulario
				model.addAttribute(ATT_CLIENT, new Caso());
				
				return SUCCESS_CASE;
			} catch (Exception e) {
				model.addAttribute(ATT_ERROR, e);
				return ERROR;
			}
		}
}
