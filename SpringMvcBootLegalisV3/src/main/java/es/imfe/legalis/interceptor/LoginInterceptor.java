package es.imfe.legalis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.imfe.legalis.model.Abogado;
import es.imfe.legalis.model.Cliente;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public static final String ATT_USER_LAWYER = "sessionLawyer";
	public static final String ATT_USER_CLIENT = "sessionClient";
	private static final String INDEX = "/index.jsp"; 
	private static final String INICIO = "login/abogado";
	private static final String CLIENT = "login/cliente";
	private static final String LOGIN_LAWYER = "/loginAbogado/";
	private static final String LOGIN_CLIENT = "/loginCliente/";
	private static final String ACCES_CLIENT = "/cliente/";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		Abogado abogado = (Abogado) request.getSession().getAttribute(ATT_USER_LAWYER);
		Cliente cliente = (Cliente) request.getSession().getAttribute(ATT_USER_CLIENT);
        
        if(abogado == null && cliente == null){
        	if (!uri.endsWith(INICIO) && !uri.endsWith(LOGIN_LAWYER) 
        			&& !uri.endsWith(CLIENT) && !uri.endsWith(LOGIN_CLIENT)){
        		//Redirigir al inicio en caso de acceso prohibido
        		response.sendRedirect(request.getContextPath() + INDEX);
        		return false;
        	}
        }else if (abogado == null && cliente != null) {
        	//Es el caso de que estemos en la sesion del cliente
        	if (!uri.endsWith(INICIO) && !uri.endsWith(LOGIN_LAWYER) 
        			&& !uri.endsWith(CLIENT) && !uri.endsWith(LOGIN_CLIENT)
        			&& !uri.endsWith(ACCES_CLIENT)){
        		//Redirigir al inicio en caso de acceso prohibido
        		response.sendRedirect(request.getContextPath() + INDEX);
        		return false;
        	}
        }
        return true;
	}

}
