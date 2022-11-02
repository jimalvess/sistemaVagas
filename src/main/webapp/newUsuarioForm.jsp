<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<!-- Imports -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/newUsuario.css" /> --%>
<link rel="stylesheet" href="css/usuarioList.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!-- nome na barra: -->

<title>Adicionar Novo Usuário</title>

</head>
<body>

	<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- Linha branca de cima -->

	<div style="padding-top: 0.5%; padding-bottom: 0.5%; padding-left: 1%;">
	</div>

<!-- Logo: -->

	<div
		style="background-color: lightgray; padding-top: 0.5%; padding-bottom: 0.5%; padding-left: 1%;">
		<img src="images/logo.png" />
	</div>
	
	
	<div id="container-fluid"
		style="	padding-top: 0.5%;
				padding-left: 1%;
				padding-right: 1%;">
				
				
				
				
				
				
				
				
				
				
		<!-- Tava aqui antes. vou fazer um novo: -->
		
		<div id="form-container">
			<p id="description">Insira as informações para adicionar um usuário</p>
			<h2>
				<a href="usuario">Listar todos os usuários</a> &nbsp;&nbsp;&nbsp; <a
					href="usuario?action=new">Adicionar um usuário</a>
			</h2>
			<c:if test="${usuario != null}">
				<form action="usuario?action=update" method="post">
			</c:if>
			<c:if test="${usuario == null}">
				<form action="usuario?action=insert" method="post">
			</c:if>
			<c:if test="${usuario != null}">
				<input type="hidden" name="id" class="input-field"
					value="<c:out value='${usuario.id}'/>" />
			</c:if>
			<div class="formRow">
				<label id="name-label" class="label-cls" for="name">* Nome </label>
				<div class="input-col">
					<input autofocus type="text" name="nome" id="nome"
						class="input-field" value="<c:out value='${usuario.name}'/>"
						placeholder="Nome do usuário" required>
				</div>
			</div>
			<div class="formRow">
				<label id="email-label" class="label-cls" for="email">*
					Email: </label>
				<div class="input-col">
					<input type="text" name="email" id="email" class="input-field"
						value="<c:out value='${usuario.email}'/>" required
						placeholder="E-mail">
				</div>
			</div>
			<div class="formRow">
				<label id="number-label" class="label-cls" for="age"> Nível:
				</label>
				<div class="input-col">
					<input type="number" name="nivel" id="nivel" class="input-field"
						value="<c:out value='${usuario.nivel}'/>"
						placeholder="Nível do usuário">
				</div>
			</div>

				<div style="background-color: lightgray;
				  				padding-top: 0.5%;
				  				padding-bottom: 0.5%;
				  				padding-left: 86%;">
	  				<button id="submit" type="submit" class="btn btn-primary">Enviar</button>
				</div>
			
			</form>
		</div>
	</div>
	</div>

</body>
</html>