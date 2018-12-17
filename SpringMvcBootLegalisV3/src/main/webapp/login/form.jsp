<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="usuario" method="POST" action="../usuario/login">
		<label for="user" class="sr-only"><spring:message code="usuario.usuario" var="labUsuario"/></label>
		<form:input path="user" class="form-control" placeholder="${labUsuario}"/>
		<form:errors path="user" cssClass="error" />
		<label for="clave" class="sr-only"><spring:message code="usuario.clave" var="labClave"/></label>
		<form:password path="clave" class="form-control" placeholder="${labClave}"/>
		<form:errors path="clave" cssClass="error" />
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.login"/>"/>
		<form:errors path="id" cssClass="error" element="div" />
	</form:form>
	<br>
	${msg}
	<a href="../usuario/registrar"><spring:message code="accion.registrar"/></a>
