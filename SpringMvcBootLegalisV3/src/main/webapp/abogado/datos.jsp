<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

	<h2><spring:message code="accion.ver.datos.usuario"/></h2>
	<p><spring:message code="accion.datos"/></p>
	<table  class="table table-striped">
		
			<tr><th><spring:message code="abogado.num.colegiado"/></th><td>${sessionLawyer.numColegiado} </td></tr>
			<tr><th><spring:message code="abogado.nombre"/></th><td>${sessionLawyer.nombre} </td></tr>
			<tr><th><spring:message code="abogado.apellido1"/></th><td>${sessionLawyer.apellido1}  </td></tr>
			<tr><th><spring:message code="abogado.apellido2"/></th><td>${sessionLawyer.apellido2}  </td></tr>
			<tr><th><spring:message code="abogado.especialidad"/></th><td>${sessionLawyer.especialidad} </td></tr>
			<tr><th><spring:message code="abogado.user"/></th><td>${sessionLawyer.user} </td></tr>
			<tr><th><spring:message code="abogado.pass"/></th><td>${sessionLawyer.pass}  </td></tr>
			<tr><th><spring:message code="abogado.fecha.alta"/></th><td>${sessionLawyer.fechaAlta}  </td></tr>
			<tr>
				<th><spring:message code="abogado.disponible"/></th>
					<td>
						<c:choose> 
							<c:when test="${sessionLawyer.disponible = true}">
								<spring:message code="afirmativo"/>
							</c:when>
							<c:otherwise>
								<spring:message code="negativo"/>
							</c:otherwise>
						</c:choose>
					</td>
			</tr>
			<tr><th><spring:message code="abogado.email"/></th><td>${sessionLawyer.email}  </td></tr>
			<tr><th><spring:message code="abogado.direccion"/></th><td>${sessionLawyer.direccion}  </td></tr>
			<tr><th><spring:message code="abogado.provincia"/></th><td>${sessionLawyer.numColegiado} </td></tr>
			<tr>
				<th><spring:message code="abogado.admin"/></th>
					<td>
						<c:choose> 
							<c:when test="${sessionLawyer.admin = true}">
								<spring:message code="afirmativo"/>
							</c:when>
							<c:otherwise>
								<spring:message code="negativo"/>
							</c:otherwise>
						</c:choose>
					</td>
			</tr>		
	</table>

	<br>
	<br>
	<br>
	<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
