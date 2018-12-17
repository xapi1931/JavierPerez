<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="cliente" method="POST" action="../modificar/cliente">
		<h1><spring:message code="accion.modificar.cliente"/></h1>
		<form:hidden path="idCliente"/>
		<form:hidden path="pass"/>
		<form:hidden path="fechaAlta"/>
		<table  class="table table-striped">			
			<tr><td><spring:message code="cliente.nombre"/></td><td><form:input path="nombre" /></td>
			<td><form:errors path="nombre" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.apellido1"/></td><td><form:input path="apellido1" /></td>
			<td><form:errors path="apellido1" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.apellido2"/></td><td><form:input path="apellido2" /></td>
			<td><form:errors path="apellido2" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.user"/></td><td><form:input path="user" /></td>
			<td><form:errors path="user" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.email"/></td><td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.direccion"/></td><td><form:input path="direccion" /></td>
			<td><form:errors path="direccion" cssClass="error" /></td></tr>
			<tr><td><spring:message code="cliente.provincia"/></td><td><form:input path="provincia" /></td>
			<td><form:errors path="provincia" cssClass="error" /></td></tr>
		</table>
		<input class="btn btn-lg btn-primary btn-block"  type="submit" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
	<br>

	<a href="../inicio/client"><spring:message code="accion.inicio"/></a>
