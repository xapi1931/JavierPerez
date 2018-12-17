<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="cliente" method="POST" action="../modificar/passCliente">
		<h1><spring:message code="accion.cambiar.pass"/></h1>
		<form:hidden path="idCliente"/>
		<form:hidden path="pass"/>
		<form:hidden path="fechaAlta"/>
		<table  class="table table-striped">			
			<tr><td><spring:message code="cliente.pass"/></td><td><form:input path="pass" /></td>
			<td><form:errors path="pass" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.pass"/></td><td><form:input path="pass" /></td>
			<td><form:errors path="pass" cssClass="error" /></td></tr>
			<%-- Metemos una variable para mandarla al controlador y compruebo que son iguales --%>
			<tr><td><spring:message code="cliente.pass"/></td><td><form:input path="pass" /></td>
			<td><form:errors path="pass" cssClass="error" /></td></tr>
			
		</table>
		<input class="btn btn-lg btn-primary btn-block"  type="submit" value="<spring:message code="accion.cambiar.pass"/>"/>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
	<br>

	<a href="../inicio/client"><spring:message code="accion.inicio"/></a>
