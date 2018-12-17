<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

	<table  class="table table-striped">
		 <thead>
			<tr>
				<th><spring:message code="caso.numero"/></th>
				<th><spring:message code="caso.abogado"/></th>
				<th><spring:message code="caso.cliente"/></th>
				<th><spring:message code="caso.descripcion"/></th>
				<th><spring:message code="caso.tipo"/></th>
				<th><spring:message code="caso.fecha"/></th>
				<th><spring:message code="caso.sentencia"/></th>
				<th><spring:message code="caso.saldo"/></th>
			</tr>
		 </thead>
		<c:forEach items="${lista}" var="item">
			 <tbody>
				<tr>
					<td>${item.numCaso}</td>
					<td>${item.numColegiado.nombre}</td>
					<td>${item.idCliente.nombre}</td>	
					<td>${item.descripcionCaso}</td>
					<td>${item.tipoCaso}</td>
					<td>${item.fechaCaso}</td>
					<td>${item.sentencia}</td>
					<td>${item.saldo}</td>
					<c:choose>
						<c:when test="${sessionLawyer != null}">
							<td><a href="../editar/caso?numCaso=${item.numCaso}"><spring:message code="accion.editar"/></a></td>	
							<td><a href="${pageContext.request.contextPath}/eliminar/caso?numCaso=${item.numCaso}" ><spring:message code="accion.eliminar"/></a></td>	
						</c:when>
	 				</c:choose> 						
				</tr>
			 </tbody>
		</c:forEach>
	</table>
	<br>
	<c:choose>
		<c:when test="${sessionLawyer != null}">
				<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
		</c:when>
		<c:when test="${sessionClient != null}">
				<a href="../inicio/client"><spring:message code="accion.inicio"/></a>
		</c:when>
	 </c:choose> 	 
	${error}		
	
