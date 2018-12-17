<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

	<h2><spring:message code="accion.ver.datos.usuario"/></h2>
	<p><spring:message code="accion.datos"/></p>
	<table  class="table table-striped">
		
			<tr><th><spring:message code="cliente.nombre"/></th><td>${sessionClient.nombre} </td></tr>
			<tr><th><spring:message code="cliente.apellido1"/></th><td>${sessionClient.apellido1}  </td></tr>
			<tr><th><spring:message code="cliente.apellido2"/></th><td>${sessionClient.apellido2}  </td></tr>
			<tr><th><spring:message code="cliente.user"/></th><td>${sessionClient.user} </td></tr>
			<tr><th><spring:message code="cliente.pass"/></th><td>${sessionClient.pass}  </td></tr>
			<tr><th><spring:message code="cliente.fecha.alta"/></th><td>${sessionClient.fechaAlta}  </td></tr>
			<tr><th><spring:message code="cliente.email"/></th><td>${sessionClient.email}  </td></tr>
			<tr><th><spring:message code="cliente.direccion"/></th><td>${sessionClient.direccion}  </td></tr>
			<tr><th><spring:message code="cliente.provincia"/></th><td>${sessionClient.provincia}  </td></tr>
			<tr><th><spring:message code="cliente.cantidad.comision"/></th><td>${sessionClient.cantidadComision}  </td></tr>
			<tr><th><spring:message code="cliente.total.comision"/></th><td>${sessionClient.totalComision}  </td></tr>
			<tr><th><spring:message code="cliente.estado.comision"/></th><td>${sessionClient.estadoComision}  </td></tr>
			<tr><th><spring:message code="cliente.rango"/></th><td>${sessionClient.rango}  </td></tr>
			<tr><th><spring:message code="cliente.nombre.referido"/></th><td>${sessionClient.nombreReferido}  </td></tr>
			<tr><th><spring:message code="cliente.cantidad.referidos"/></th><td>${sessionClient.cantidadReferidos}  </td></tr>
	</table>

	<br>
	<br>
	<br>
	<a href="../inicio/client"><spring:message code="accion.inicio"/></a>
