<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<a href="../disco/listar"><spring:message code="accion.listar"/></a><br>	
	<c:choose>
		<c:when test="${sessionUser.tipo.id==1}">
			<a href="../venta/listar"><spring:message code="accion.ventas"/></a>
		</c:when>
		<c:otherwise>		
			<a href="../carrito/listar"><spring:message code="accion.carrito"/></a>
		</c:otherwise>
	</c:choose>
