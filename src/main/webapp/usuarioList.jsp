<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Imports -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/usuarioList.css" /> --%>
<link rel="stylesheet" href="css/usuarioList.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<!-- nome na barra: -->

<title>Lista de Usuários</title>
</head>
<body>

	<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- Linha branca de cima -->	

	<div style="
  				padding-top: 0.5%;
  				padding-bottom: 0.5%;
  				padding-left: 1%;">
	</div>

<!-- Logo: -->	

	<div style="background-color: lightgray;
  				padding-top: 0.5%;
  				padding-bottom: 0.5%;
  				padding-left: 1%;">
			<img src="images/logo.png"/>
	</div>

<!-- Container da tabela -->

	<div id="container-fluid"
		style="	padding-top: 0.5%;
				padding-left: 1%;
				padding-right: 1%;">
				
		<p id="description">Dados relevantes dos usuários:</p>	
<!-- Tabela: -->	
	
		<table
			class="table table-sm table-striped table-hover table-bordered">
			
<!-- Barra de tírulo da tabela: -->	
		
			<tr>
				<!-- <th>ID</th> -->
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Nome</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Email</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Fone</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Rua</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Nº</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Complemento</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Bairro</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Cidade</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">UF</strong></th>
				<!-- <th>CEP</th
				<th>Descrição</th> -->
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Foto</strong></th>
				<!-- <th>Status</th>
				<th>Login</th>
				<th>Senha</th>
				<th>Permissões</th>
				<th>Vagas</th> -->
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px text-align: center;">
				<strong style="font-size: 12px;">Redes</strong></th>
				<!-- <th>Denúncias</th>
				<th>Mensagens</th>
				<th>CPF</th>
				<th>Data de Nascimento</th> -->
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Escolaridade</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Idiomas</strong></th>
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Competências</strong></th>
				<!-- <th>Fornecedor</th>
				<th>CNPJ</th>
				<th>Site</th>-->
				<th style="padding-left: 5px; padding-bottom: 3px; height: 30px; text-align: center">
				<strong style="font-size: 12px;">Ações</strong></th>

<!-- Conteúdo dinâmico da tabela -->

			</tr>
			<c:forEach var="usuario" items="${listUsuario}">
				<tr>
					<%-- <td><c:out value="${usuario.id}" /></td> --%>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.nome}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.email}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.fone}" />
						</p></td>
					<%-- <td class="align-top"><c:out value="${usuario.tel2}" /></td> --%>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.logradouro}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.numero}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.complemento}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.bairro}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.localidade}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.uf}" />
						</p></td>
					<%-- <td style="padding-left: 5px; padding-bottom: 3px;"><p style="font-size:12px;text-align: center"><c:out value="${usuario.cep}" /></p></td> --%>
					<%-- <td><c:out value="${usuario.descricao}" /></td> --%>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.foto}" />
						</p></td>
					<%-- <td><c:out value="${usuario.status}" /></td>
					<td><c:out value="${usuario.login}" /></td>
					<td><c:out value="${usuario.senha}" /></td>
					<td><c:out value="${usuario.permissoes}" /></td>
					<td><c:out value="${usuario.vagas}" /></td> --%>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.redesSociais}" />
						</p></td>
					<%-- <td><c:out value="${usuario.denuncias}" /></td>
					<td><c:out value="${usuario.mensagens}" /></td>
					<td><c:out value="${usuario.cpf}" /></td>
					<td><c:out value="${usuario.dataNasc}" /></td> --%>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.escolaridade}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.idiomas}" />
						</p></td>
					<td style="padding-left: 5px; padding-bottom: 3px;"><p
							style="font-size: 12px; text-align: center">
							<c:out value="${usuario.competencias}" />
						</p></td>
					<%-- <td><c:out value="${usuario.fornecedor}" /></td>
					<td><c:out value="${usuario.cnpj}" /></td>
					<td><c:out value="${usuario.site}" /></td>--%>
					<td style="padding-left: 5px; padding-bottom: 3px;">
					
<!-- Botão de editar -->		
			
						<a href="usuario?action=update&id=<c:out value='${usuario.id}' />">
							<button type="button" class="btn btn-warning btn-circle"
								style="
								  width: 30px;
								  height: 30px;
								  text-align: center;
								  padding: 6px 0;
								  font-size: 12px;
								  line-height: 1.428571429;
								  border-radius: 15px;">
								<i class="glyphicon glyphicon-pencil"></i>
							</button>
						</a>

<!-- Botão de deletar -->		
					
						<a href="usuario?action=delete&id=<c:out value='${usuario.id}' />">
							<button type="button" class="btn btn-danger btn-circle"
								style="
								  width: 30px;
								  height: 30px;
								  text-align: center;
								  padding: 6px 0;
								  font-size: 12px;
								  line-height: 1.428571429;
								  border-radius: 15px;">
								<i class="glyphicon glyphicon-remove"></i>
							</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<!-- Botão de Novo: -->	
	
	<div style="background-color: lightgray;
  				padding-top: 0.5%;
  				padding-bottom: 0.5%;
  				padding-left: 86%;">
			<a href="usuario?action=new"><button type="button" class="btn btn-primary">Adicionar Novo Usuário</button></a>
	</div>

</body>
</html>