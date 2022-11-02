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

	<div style="padding-top: 0.5%; padding-bottom: 0.5%; padding-left: 1%;"></div>

<!-- Logo: -->

	<div
		style="background-color: lightgray; padding-top: 0.5%; padding-bottom: 0.5%; padding-left: 1%;">
		<img src="images/logo.png" />
	</div>

<!-- Container do formulario: -->

	<div id="container-fluid"
		style="padding-top: 0.5%; padding-left: 1%; padding-right: 1%;">

		<p id="description">Campos com * são obrigatórios:</p>

		<form>

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

<!-- Container do form em duas colunas: -->

				<div class="form-row">

<!-- Div do nome: -->

					<div class="form-group">
						<label for="nome" id="name-label">Nome*</label> <input type="text"
							name="nome" id="nome" class="form-control" required
							value="<c:out value='${usuario.name}'/>">
					</div>

<!-- Div do email: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="email" id="email-label">E-mail*</label> <input
							type="text" name="email" class="form-control" required
							value="<c:out value='${usuario.email}'/>">
					</div>

<!-- Div do login: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="login" id="login">Login*</label> <input type="text"
							name="login" class="form-control" required
							value="<c:out value='${usuario.login}'/>"
							placeholder="seu nome de entrada">
					</div>

<!-- Div da senha: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="senha" id="senha">Senha*</label> <input
							type="password" name="senha" class="form-control" required
							value="<c:out value='${usuario.senha}'/>"
							placeholder="sua senha de entrada">
					</div>

<!-- Div de cpf: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cpf" id="cpf">CPF*</label> <input type="text"
							name="cpf" class="form-control" required
							value="<c:out value='${usuario.cpf}'/>"
							placeholder="somente números">
					</div>

				</div>

<!-- Nova linha de duas colunas: -->

				<div class="form-row">

<!-- Div do fone 1: -->

					<div class="form-group">
						<label for="tel1" id="tel1-label">Fone principal*</label> 
						<input type="text" name="tel1" id="tel1" class="form-control" required
							value="<c:out value='${usuario.tel1}'/>">
					</div>

<!-- Div do fone 2: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="tel2" id="tel2-label">Fone secundário</label> 
						<input type="text" name="tel2" class="form-control"
							value="<c:out value='${usuario.tel2}'/>">
					</div>

<!-- Div do cep: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cep" id="login">CEP*</label> 
						<input type="text" name="cep" class="form-control" required
							value="<c:out value='${usuario.cep}'/>"
							placeholder="somente números">
					</div>

<!-- Div da rua: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="logradouro" id="logradouro">Rua*</label> 
						<input type="text" name="logradouro" class="form-control" required
							value="<c:out value='${usuario.logradouro}'/>">
					</div>

<!-- Div de número: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="numero" id="logradouro">nº*</label> 
						<input type="text" name="numero" class="form-control" required
							value="<c:out value='${usuario.numero}'/>">
					</div>

				</div>

<!-- Nova linha de duas colunas: -->

				<div class="form-row">

<!-- Div do complemento: -->

					<div class="form-group">
						<label for="complemento" id="complemento-label">Complemento</label>
						<input type="text" name="complemento" id="complemento"
							class="form-control"
							value="<c:out value='${usuario.complemento}'/>">
					</div>

<!-- Div do bairro: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="bairro" id="bairro-label">Bairro*</label> 
						<input type="text" name="bairro" class="form-control" required
							value="<c:out value='${usuario.bairro}'/>">
					</div>

<!-- Div da cidade: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="localidade" id="localidade">Cidade*</label> 
						<input type="text" name="localidade" class="form-control" required
							value="<c:out value='${usuario.localidade}'/>">
					</div>

<!-- Div do UF: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="uf" id="uf">UF*</label> 
						<select class="form-control form-control-sm" required>
							<option value="">Selecione</option>
							<option value="<c:out value='${usuario.uf}'/>">AC</option>
							<option value="<c:out value='${usuario.uf}'/>">AL</option>
							<option value="<c:out value='${usuario.uf}'/>">AM</option>
							<option value="<c:out value='${usuario.uf}'/>">AP</option>
							<option value="<c:out value='${usuario.uf}'/>">BA</option>
							<option value="<c:out value='${usuario.uf}'/>">CE</option>
							<option value="<c:out value='${usuario.uf}'/>">DF</option>
							<option value="<c:out value='${usuario.uf}'/>">ES</option>
							<option value="<c:out value='${usuario.uf}'/>">GO</option>
							<option value="<c:out value='${usuario.uf}'/>">MA</option>
							<option value="<c:out value='${usuario.uf}'/>">MS</option>
							<option value="<c:out value='${usuario.uf}'/>">MT</option>
							<option value="<c:out value='${usuario.uf}'/>">MG</option>
							<option value="<c:out value='${usuario.uf}'/>">PA</option>
							<option value="<c:out value='${usuario.uf}'/>">PB</option>
							<option value="<c:out value='${usuario.uf}'/>">PR</option>
							<option value="<c:out value='${usuario.uf}'/>">PE</option>
							<option value="<c:out value='${usuario.uf}'/>">PI</option>
							<option value="<c:out value='${usuario.uf}'/>">RJ</option>
							<option value="<c:out value='${usuario.uf}'/>">RN</option>
							<option value="<c:out value='${usuario.uf}'/>">RS</option>
							<option value="<c:out value='${usuario.uf}'/>">RO</option>
							<option value="<c:out value='${usuario.uf}'/>">RR</option>
							<option value="<c:out value='${usuario.uf}'/>">SC</option>
							<option value="<c:out value='${usuario.uf}'/>">SP</option>
							<option value="<c:out value='${usuario.uf}'/>">SE</option>
							<option value="<c:out value='${usuario.uf}'/>">TO</option>
						</select>
					</div>

<!-- Div de Representante: -->

					<div class="form-group form-check"><br>
						<input type="checkbox" name="representante" class="form-check-input"> <label for="representante"
							id="fornecedor" class="form-check-label">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Marque se for representante</label><br>
						<input type="checkbox" name="fornecedor" class="form-check-input">
						<label for="fornecedor" id="fornecedor" class="form-check-label">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Marque se for fornecedor</label>
					</div>


<!-- Linha sepadadora: -->

					<hr style="border-color: lightgray; box-sizing: border-box; width: 100%;" />

				</div>

<!-- Nova linha de duas colunas: -->

				<div class="form-row">

<!-- Div da data de nascimento: -->

					<div class="form-group">
						<label for="dataNasc" id="dataNasc-label">Data de Nascimento*</label> 
						<input type="text" name="dataNasc" id="dataNasc" class="form-control" required
							value="<c:out value='${usuario.dataNasc}'/>"
							placeholder="somente números">
					</div>

<!-- Div da escolaridade: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="escolaridade" id="escolaridade-label">Escolaridade*</label>
						<input type="text" name="escolaridade" class="form-control" required
							value="<c:out value='${usuario.bairro}'/>">
					</div>

<!-- Div da instituicao: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="instituicao" id="instituicao">Instituição</label> 
						<input type="text" name="instituicao" class="form-control"
							value="<c:out value='${usuario.localidade}'/>"
							placeholder="ultima escola frequentada">
					</div>

<!-- Div de idiomas: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="idiomas" id="idiomas">Idiomas</label> 
						<select class="form-control form-control-sm">
							<option value="">Selecione</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Espanhol
								Básico</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Espanhol
								Intermediário</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Espanhol
								Avançado</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Inglês
								Básico</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Inglês
								Intermediário</option>
							<option value="<c:out value='${usuario.idiomas}'/>">Inglês
								Avançado</option>
						</select>
					</div>

<!-- Div de Tecnologias: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="tecnologias" id="tecnologias">Tecnologias Conhecidas</label> 
						<input type="text" name="tecnologias" class="form-control"
							value="<c:out value='${usuario.tecnologias}'/>"
							placeholder="separe por vírgula">
					</div>

				</div>

<!-- Nova linha de duas colunas: -->

				<div class="form-row">

<!-- Div da data de competencias: -->

					<div class="form-group">
						<label for="competencias" id="competencias-label">Competências Conhecidas*</label> 
						<input type="text" name="competencias" id="competencias" class="form-control" required
							value="<c:out value='${usuario.competencias}'/>"
							placeholder="separe por vírgula">
					</div>

<!-- Div da tempo de atuação: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="tempoAtuacao" id="tempoAtuacao-label">Tempo de Atuação*</label> 
						<input type="text" name="escolaridade" class="form-control" required
							value="<c:out value='${usuario.tempoAtuacao}'/>"
							placeholder="número de meses">
					</div>

<!-- Div do site: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="site" id="site">Seu site aqui</label> 
						<input type="text" name="site" class="form-control"
							value="<c:out value='${usuario.site}'/>"
							placeholder="comece com www...">
					</div>

<!-- Div de redes sociais: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="redesSociais" id="redesSociais">Suas redes sociais</label> 
						<input type="text" name="redesSociais" class="form-control"
							value="<c:out value='${usuario.redesSociais}'/>"
							placeholder="separe seus links por vírgula">
					</div>

<!-- Div de cnpj: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cnpj" id="cnpj">Você é uma empresa?</label> 
						<input type="text" name="tecnologias" class="form-control"
							value="<c:out value='${usuario.cnpj}'/>"
							placeholder="CNPJ: somente números">
					</div>

				</div>

<!-- responsável por colocar descrição e foto na mesma linha -->

				<div class="form-row">

<!-- Div descrição: 
Colocar o 
	value="<c:out value='${usuario.descricao}'/>"
Depos...
-->
					<div class="form-group">
						<label for="descricao" id="descricao-label">Fale mais de você...</label>
						<textarea class="form-control" name="dataNasc" id="descricao"
							rows="1" cols="50"></textarea>
					</div>

<!-- Div escolher foto: -->

					<div class="form-group" style="padding-left: 1%;">
						<label for="foto">Quer nos mandar sua foto?</label> 
						<input type="file" class="btn btn-light" id="foto"
							value="<c:out value='${usuario.descricao}'/>">
					</div>

<!-- Div Botão Enviar: -->

					<div class="form-group" style="padding-top: 2%; padding-left: 10%;">
						<button id="submit" type="submit" class="btn btn-primary">Enviar as Informações</button>
					</div>
				</div>
		</form>

	</div>

</body>

</html>