<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

	<h1><spring:message code="wellcome"/> ${sessionLawyer.nombre}</h1>

	<br>
	<a href="../datos/abogado?numColegiado=${sessionLawyer.numColegiado}"><spring:message code="accion.ver"/></a>
	<br>
	<a href="../editar/abogado?numColegiado=${sessionLawyer.numColegiado}"><spring:message code="accion.editar"/></a>
	<br>
	<a href="../listar/clientes"><spring:message code="accion.listar.clientes"/></a>
	<br>
	<a href="../listar/abogados"><spring:message code="accion.listar.abogados"/></a>
	<br>
	<a href="../listar/casos"><spring:message code="accion.listar.casos"/></a>
	<br>
	<a href="${pageContext.request.contextPath}/modificarPass/abogado"><spring:message code="accion.cambiar.pass"/></a>
	<br>
	<a href="../guardar/abogado"><spring:message code="accion.agregar.abogado"/></a>
	<br>
	<a href="../guardar/abogado"><spring:message code="accion.agregar.cliente"/></a>
	<br>
	<a href="../guardar/caso"><spring:message code="accion.agregar.caso"/></a>
	<br>
	<a href="${pageContext.request.contextPath}/modificar/caso"><spring:message code="accion.cambiar.caso"/></a>
	<br>
	<br>
	<a href="../login/logout"><spring:message code="accion.logout"/></a>
