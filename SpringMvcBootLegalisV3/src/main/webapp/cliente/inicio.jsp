<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

	<h1><spring:message code="wellcome"/> ${sessionClient.nombre}</h1>

	<br>
	<a href="../datos/cliente?idCliente=${sessionClient.idCliente}"><spring:message code="accion.ver"/></a>
	<br>
	<a href="../editar/cliente?idCliente=${sessionClient.idCliente}"><spring:message code="accion.editar"/></a>
	<br>
	<a href="../listar/misCasos?idCliente=${sessionClient.idCliente}"><spring:message code="accion.listar.casos"/></a>
	<br>
	<a href="../modificar/pass/cliente?idCliente=${sessionClient.idCliente}"><spring:message code="accion.cambiar.pass"/></a>
	<br>
	<a href="${pageContext.request.contextPath}/verComisiones"><spring:message code="accion.ver.comisiones"/></a>

	<br>
	<br>
	<a href="../login/logout"><spring:message code="accion.logout"/></a>
