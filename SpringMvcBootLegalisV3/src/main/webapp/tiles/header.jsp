<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <c:choose>
		<c:when test="${sessionLawyer != null}">
			<a class="navbar-brand" href="../inicio/home"><spring:message code="app.name"/></a>
		</c:when>
		<c:when test="${sessionClient != null}">
			<a class="navbar-brand" href="../inicio/client"><spring:message code="app.name"/></a>
		</c:when>
	  </c:choose> 
      
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          	<c:choose>
				<c:when test="${sessionLawyer != null}">
					<li class="nav-item"><a class="nav-link" href="../datos/abogado?numColegiado=${sessionLawyer.numColegiado}"><spring:message code="accion.ver"/></a></li>
					<li class="nav-item"><a class="nav-link" href="../listar/abogados"><spring:message code="accion.listar.abogados"/></a></li>
					<li class="nav-item"><a class="nav-link" href="../listar/clientes"><spring:message code="accion.listar.clientes"/></a></li>
					<li class="nav-item"><a class="nav-link" href="../listar/casos"><spring:message code="accion.listar.casos"/></a></li>
				</c:when>
				<c:when test="${sessionClient != null}">
					<li class="nav-item"><a class="nav-link" href="../datos/cliente?idCliente=${sessionClient.idCliente}"><spring:message code="accion.ver"/></a></li>
			</c:when>
			  </c:choose> 
			  
		
            
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="accion.idiomas"/></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="../inicio/home?lang=es"><spring:message code="idioma.es"/></a>
		  	  <a class="dropdown-item" href="../inicio/home?lang=en"><spring:message code="idioma.en"/></a>
            </div>
          </li>
          
         <c:if test="${not empty sessionLawyer}">
				<li class="nav-item active"><a class="nav-link" href="../login/logout"><spring:message code="accion.logout"/></a></li>
		 </c:if>
        </ul>
      </div>
    </nav>