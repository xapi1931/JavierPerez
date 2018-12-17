<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<form:form class="form-signin" modelAttribute="caso" method="POST" action="../modificar/caso">
		<h1><spring:message code="accion.modificar.caso"/></h1>
		<form:hidden path="numCaso"/>
		<form:hidden path="fechaCaso"/>
		<table  class="table table-striped">			
			<tr><td><spring:message code="caso.abogado"/><form:select path="numColegiado" items="${numColegiado}" itemLabel="abogado" itemValue="nombre"/></td>
			<td><form:errors path="numColegiado" cssClass="error" /></td></tr>
			<tr><td><spring:message code="caso.cliente"/></td><td><form:select path="idCliente" items="${idCliente}" itemLabel="cliente" itemValue="nombre"/></td>
			<td><form:errors path="idCliente" cssClass="error" /></td></tr>
			<tr><td><spring:message code="caso.descripcion"/></td><td><form:input path="descripcionCaso" /></td>
			<td><form:errors path="descripcionCaso" cssClass="error" /></td></tr>
			<tr><td><spring:message code="caso.tipo"/></td><td><form:input path="tipoCaso" /></td>
			<td><form:errors path="tipoCaso" cssClass="error" /></td></tr>
			<tr><td><spring:message code="caso.sentencia"/></td><td><form:input path="sentencia" /></td>
			<td><form:errors path="sentencia" cssClass="error" /></td></tr>
			<tr><td><spring:message code="caso.saldo"/></td><td><form:input path="saldo" /></td>
			<td><form:errors path="saldo" cssClass="error" /></td></tr>
		</table>
		<input class="btn btn-lg btn-primary btn-block"  type="submit" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
	<br>

	<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
