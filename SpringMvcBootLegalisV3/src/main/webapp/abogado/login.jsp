<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="abogado" method="POST" action="../login/abogado">
		<p><spring:message code="request.login.lawyer"/></p>
		<label for="user" class="sr-only"><spring:message code="request.user" var="labUsuario"/></label>
		<form:input path="user" class="form-control" placeholder="${labUsuario}"/>
		<form:errors path="user" cssClass="error" />
		<label for="pass" class="sr-only"><spring:message code="request.pass" var="labClave"/></label>
		<form:password path="pass" class="form-control" placeholder="${labClave}"/>
		<form:errors path="pass" cssClass="error" />	
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.enviar"/>"/>
		<form:errors cssClass="error" element="div" />
	<%-- 	<form:errors path="id" cssClass="error" element="div" /> Quiza deberia definir una variable y mandarla al controlador
			para recogerlo con RequestParam	Lo mete en el id yo le tengo que buscar otro sitio--%>
	</form:form>
	<br>
	${msg}
	<a href="../login/cliente"><spring:message code="acceso.cliente"/></a>
