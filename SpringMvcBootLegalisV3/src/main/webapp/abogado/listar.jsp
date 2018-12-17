<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

	<table  class="table table-striped">
		 <thead>
			<tr>
				<th><spring:message code="abogado.nombre"/></th>
				<th><spring:message code="abogado.apellido1"/></th>
				<th><spring:message code="abogado.especialidad"/></th>
				<th><spring:message code="abogado.numColegiado"/></th>
				<th><spring:message code="abogado.provincia"/></th>
				<th><spring:message code="abogado.disponible"/></th>
			</tr>
		 </thead>
		<c:forEach items="${lista}" var="item">
			 <tbody>
				<tr>
					<td>${item.nombre}</td>
					<td>${item.apellido1}</td>
					<td>${item.especialidad}</td>	
					<td>${item.numColegiado}</td>
					<td>${item.provincia}</td>
					<td>${item.disponible}</td>
					<td><a href="${pageContext.request.contextPath}/editar/abogado?numColegiado=${item.numColegiado}"><spring:message code="accion.editar"/></a></td>	
					<td><a href="${pageContext.request.contextPath}/eliminar/abogado?numColegiado=${item.numColegiado}" ><spring:message code="accion.eliminar"/></a></td>	
				</tr>
			 </tbody>
		</c:forEach>
	</table>
	<br>
	<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
