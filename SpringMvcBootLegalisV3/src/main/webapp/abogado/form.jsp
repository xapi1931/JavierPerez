<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


	<form:form  class="form-signin" modelAttribute="abogado" method="POST" action="../guardar/abogado">
		<h1><spring:message code="accion.agregar.abogado"/></h1>
		<label for="numColegiado" class="sr-only"><spring:message code="abogado.numColegiado" var="labNumColegiado"/></label>
		<form:input path="numColegiado" class="form-control" placeholder="${labNumColegiado}"/>
		<form:errors path="numColegiado" cssClass="error" />
		<label for="pass" class="sr-only"><spring:message code="insertar.pass" var="labNumPass"/></label>
		<form:input path="pass" class="form-control" placeholder="${labNumPass}"/>
		<form:errors path="pass" cssClass="error" />
		<c:set var="nuevo" value="true" scope="request"/>		
		<label for="nombre" class="sr-only"><spring:message code="abogado.nombre" var="labNombre"/></label>
		<form:input path="nombre" class="form-control" placeholder="${labNombre}"/>
		<form:errors path="nombre" cssClass="error" />
		<label for="apellido1" class="sr-only"><spring:message code="abogado.apellido1" var="labApellido1"/></label>
		<form:input path="apellido1" class="form-control" placeholder="${labApellido1}"/>
		<form:errors path="apellido1" cssClass="error" />
		<label for="apellido2" class="sr-only"><spring:message code="abogado.apellido2" var="labApellido2"/></label>
		<form:input path="apellido2" class="form-control" placeholder="${labApellido2}"/>
		<form:errors path="apellido2" cssClass="error" />
		<label for="especialidad" class="sr-only"><spring:message code="abogado.especialidad" var="labEspecialidad"/></label>
		<form:input path="especialidad" class="form-control" placeholder="${labEspecialidad}"/>
		<form:errors path="especialidad" cssClass="error" />
		<label for="user" class="sr-only"><spring:message code="abogado.user" var="labUser"/></label>
		<form:input path="user" class="form-control" placeholder="${labUser}"/>
		<form:errors path="user" cssClass="error" />
		<label for="fechaAlta" class="sr-only"><spring:message code="abogado.fecha.alta.format" var="labFechaAlta"/></label>
		<form:input path="fechaAlta" class="form-control" placeholder="${labFechaAlta}"/>
		<form:errors path="fechaAlta" cssClass="error" />
		<label for="email" class="sr-only"><spring:message code="abogado.email" var="labEmail"/></label>
		<form:input path="email" class="form-control" placeholder="${labEmail}"/>
		<form:errors path="email" cssClass="error" />
		<label for="direccion" class="sr-only"><spring:message code="abogado.direccion" var="labDireccion"/></label>
		<form:input path="direccion" class="form-control" placeholder="${labDireccion}"/>
		<form:errors path="direccion" cssClass="error" />
		<label for="provincia" class="sr-only"><spring:message code="abogado.provincia" var="labProvincia"/></label>
		<form:input path="provincia" class="form-control" placeholder="${labProvincia}"/>
		<form:errors path="provincia" cssClass="error" />				
		<br>
       	<form:checkbox  path="disponible" /><spring:message code="abogado.disponible"/>
        <form:errors path="disponible" cssClass="error" />
		<form:checkbox  path="admin"/><spring:message code="abogado.admin"/>
        <form:errors path="admin" cssClass="error" />
		<input class="btn btn-lg btn-primary btn-block"  type="submit" value="<spring:message code="accion.guardar"/>"/>
		<form:errors  cssClass="errorblock" element="div" />
		
	</form:form>
	<br>
	${msg}
	<br>
	<a href="../inicio/home"><spring:message code="accion.inicio"/></a>
