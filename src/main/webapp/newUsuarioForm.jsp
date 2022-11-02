<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Imports -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet" />
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/newUsuario.css" /> --%>
<link rel="stylesheet" href="css/usuarioList.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
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

<!-- Container do formulario: -->

	<div id="container-fluid"
		style="padding-top: 0.5%; padding-left: 1%; padding-right: 1%;">

		<p id="description">Campos com * são obrigatórios:</p>

<!-- Div do nome: -->

		<div class="form-group">
			<!-- Se for pra atualizar: -->
			<c:if test="${usuario != null}">
				<form action="usuario?action=update" method="post">
			</c:if>
			<!-- Se for pra inserir: -->
			<c:if test="${usuario == null}">
				<form action="usuario?action=insert" method="post">
			</c:if>
			<c:if test="${usuario != null}">
				<input type="hidden" name="id" class="input-field"
					value="<c:out value='${usuario.id}'/>" />
			</c:if>
			<label for="nome" id="name-label">Nome*</label> <input type="text"
				name="nome" id="nome" class="form-control" required
				value="<c:out value='${usuario.name}'/>">
		</div>

<!-- Div do email: -->

		<div class="form-group">
			<label for="email" id="email-label">E-mail*</label> <input
				type="text" name="email" class="form-control" required
				value="<c:out value='${usuario.email}'/>">
		</div>

<!-- Div do login: -->

		<div class="form-group">
			<label for="login" id="login">Login*</label> <input type="text"
				name="login" class="form-control" required
				value="<c:out value='${usuario.login}'/>"
				placeholder="seu nome de entrada">
		</div>

<!-- Div da senha: -->

		<div class="form-group">
			<label for="senha" id="senha">Senha*</label> <input type="password"
				name="senha" class="form-control" required
				value="<c:out value='${usuario.senha}'/>"
				placeholder="sua senha de entrada">
		</div>

<!-- Div de fornecedor: -->

		<div class="form-group form-check">
			<input type="checkbox" name="fornecedor" class="form-check-input">
			<label for="fornecedor" id="fornecedor" class="form-check-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Marque
				se for fornecedor</label>
		</div>

<!-- Botão do form: -->

		<div style="background-color: lightgray; padding-top: 0.5%; padding-bottom: 0.5%; padding-left: 86%;">
			<button id="submit" type="submit" class="btn btn-primary">Enviar</button>
		</div>


	</div>

</body>
</html>