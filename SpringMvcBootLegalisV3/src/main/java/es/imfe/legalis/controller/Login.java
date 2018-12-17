package es.imfe.legalis.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.imfe.legalis.interceptor.LoginInterceptor;
import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.Cliente;
import es.imfe.legalis.service.AbogadoSvc;
import es.imfe.legalis.service.ClienteSvc;


//Indica que se trata de un controlador
@Controller
@SessionAttributes({LoginInterceptor.ATT_USER_LAWYER, LoginInterceptor.ATT_USER_CLIENT})
@RequestMapping(value="/login")
public class Login {

	private static final String MSG_ERROR = "usuario.login.error";
	private static final String LOGIN_CLIENT = "loginCliente";
	private static final String SUCCESS_CLIENT = "inicioCliente";
	private static final String LOGIN_LAWYER = "loginAbogado";
	private static final String SUCCESS_LAWYER = "inicioAbogado";
	private static final String INICIO = "redirect:/login/abogado";
	@Autowired
	private ClienteSvc cSvc;
	
	@Autowired
	private AbogadoSvc aSvc;
	
	@RequestMapping(value="/cliente", method=RequestMethod.GET)
    public String loginClient(@ModelAttribute Cliente cliente, Model model) {
		return LOGIN_CLIENT;
	}
	
	@RequestMapping(value="/cliente", method=RequestMethod.POST)
	 public String loginClient(@Valid Cliente cliente, BindingResult result, Model model) {
		try {
			//No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("user") != null || 
					result.getFieldError("pass") != null){
				return LOGIN_CLIENT;
			}else{
				cliente = cSvc.buscarPorUserAndPass(cliente.getUser(), cliente.getPass());
				if (cliente == null){
					result.reject(MSG_ERROR);
					return LOGIN_CLIENT;
				}else{
					//Agregar el cliente a la sesión para el interceptor
					model.addAttribute(LoginInterceptor.ATT_USER_CLIENT, cliente);
					return SUCCESS_CLIENT;
				}
			}
		} catch (Exception e) {
			result.reject(MSG_ERROR);
			return LOGIN_CLIENT;
		}
	}
	
	@RequestMapping(value="/abogado", method=RequestMethod.GET)
    public String loginLawyer(@ModelAttribute Abogado abogado, Model model) {
		return LOGIN_LAWYER;
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(Model model, SessionStatus sessionStatus){
		//Destrucción de la sesión
		sessionStatus.setComplete();
		//Hace un redirect, para completar el cierre de sesión
		return INICIO;
	}
	
	@RequestMapping(value="/abogado", method=RequestMethod.POST)
	 public String loginLawyer(@Valid Abogado abogado, BindingResult result, Model model) {
		try {
			//No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("user") != null || 
					result.getFieldError("pass") != null){
				return LOGIN_LAWYER;
			}else{
				abogado = aSvc.buscarPorUserAndPass(abogado.getUser(), abogado.getPass());
				if (abogado == null){
					// TODO Revisar rejectValue. Asignamos el error al id para filtrado en formulario 
					result.reject(MSG_ERROR);
					return LOGIN_LAWYER;
				}else{
					//Agregar el abogado a la sesión para el interceptor
					model.addAttribute(LoginInterceptor.ATT_USER_LAWYER, abogado);
					return SUCCESS_LAWYER;
				}
			}
		} catch (Exception e) {
			result.reject(MSG_ERROR);
			return LOGIN_LAWYER;
		}
    }
	

}
	
	
