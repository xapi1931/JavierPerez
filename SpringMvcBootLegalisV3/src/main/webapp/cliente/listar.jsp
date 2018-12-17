<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

	<table  class="table table-striped">
		 <thead>
			<tr>
				<th><spring:message code="cliente.nombre"/></th>
				<th><spring:message code="cliente.apellido1"/></th>
				<th><spring:message code="cliente.user"/></th>
				<th><spring:message code="cliente.email"/></th>
				<th><spring:message code="cliente.direccion"/></th>
				<th><spring:message code="cliente.provincia"/></th>
			</tr>
		 </thead>
		<c:forEach items="${lista}" var="item">
			 <tbody>
				<tr>
					<td>${item.nombre}</td>
					<td>${item.apellido1}</td>
					<td>${item.user}</td>	
					<td>${item.email}</td>
					<td>${item.direccion}</td>
					<td>${item.provincia}</td>
					<td><a href="${pageContext.request.contextPath}/editar/cliente?idCliente=${item.idCliente}"><spring:message code="accion.editar"/></a></td>	
					<td><a href="${pageContext.request.contextPath}/cliente?idCliente=${item.idCliente}" ><spring:message code="accion.eliminar"/></a></td>	
				</tr>
			 </tbody>
		</c:forEach>
	</table>
	<br>
	<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
