<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/usuarioList.css" /> --%>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />

<title>Lista de Usuários</title>
</head>
<body>

<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- <div class="survey-page"> -->
	<div class="jumbotron" align="center" style="margin-top: 50px;">
        <h1 id="title">Sistema Vagas</h1>
        <div id="form-container">
        <h2>
        	<a href="usuario?action=new">Adicionar Novo Usuário</a>
        	
        </h2>
        <!-- <table cellpadding="5"> -->
        <table class="table table-sm table-striped table-hover table-bordered table-responsive" >
            <tr>
                <!-- <th>ID</th> -->
                <th><p class="text-success">Nome</p></th>
                <th>Email</th>
                <th>Tel1</th>
                <!-- <th>Tel2</th> -->
				<th>Logradouro</th>
				<th>Número</th>
				<th>Complemento</th>
				<th>Bairro</th>
				<th>Localidade</th>
				<th>UF</th>
				<th>CEP</th>
				<!-- <th>Nível</th>
				<th>Descrição</th> -->
				<th>Foto</th>
				<!-- <th>Status</th>
				<th>Login</th>
				<th>Senha</th>
				<th>Nova Senha</th>
				<th>Permissões</th>
				<th>Token</th>
				<th>Vagas</th> -->
				<th>Redes Sociais</th>
				<!-- <th>Denúncias</th>
				<th>Mensagens</th>
				<th>CPF</th>
				<th>Data de Nascimento</th> -->
				<th>Escolaridade</th>
				<th>Tempo de Atuação</th>
				<th>Idiomas</th>
				<th>Tecnologias</th>
				<th>Competências</th>
				<!-- <th>Fornecedor</th>
				<th>CNPJ</th>
				<th>Site</th>
				<th>Representante</th> -->
                <th>Ações</th>
                
            </tr>
            <c:forEach var="usuario" items="${listUsuario}">
                <tr>
                    <%-- <td><c:out value="${usuario.id}" /></td> --%>
                    <td class="align-top"><c:out value="${usuario.nome}" /></td>
                    <td class="align-top"><c:out value="${usuario.email}" /></td>
                    <td class="align-top"><c:out value="${usuario.tel1}" /></td>
	                <%-- <td class="align-top"><c:out value="${usuario.tel2}" /></td> --%>
					<td class="align-top"><c:out value="${usuario.logradouro}" /></td>
					<td class="align-top"><c:out value="${usuario.numero}" /></td>
					<td class="align-top"><c:out value="${usuario.complemento}" /></td>
					<td class="align-top"><c:out value="${usuario.bairro}" /></td>
					<td class="align-top"><c:out value="${usuario.localidade}" /></td>
					<td class="align-top"><c:out value="${usuario.uf}" /></td>
					<td class="align-top"><c:out value="${usuario.cep}" /></td>
					<%-- <td><c:out value="${usuario.nivel}" /></td>
					<td><c:out value="${usuario.descricao}" /></td> --%>
					<td class="align-top"><c:out value="${usuario.foto}" /></td>
					<%-- <td><c:out value="${usuario.status}" /></td>
					<td><c:out value="${usuario.login}" /></td>
					<td><c:out value="${usuario.senha}" /></td>
					<td><c:out value="${usuario.novaSenha}" /></td>
					<td><c:out value="${usuario.permissoes}" /></td>
					<td><c:out value="${usuario.token}" /></td>
					<td><c:out value="${usuario.vagas}" /></td> --%>
					<td class="align-top"><c:out value="${usuario.redesSociais}" /></td>
					<%-- <td><c:out value="${usuario.denuncias}" /></td>
					<td><c:out value="${usuario.mensagens}" /></td>
					<td><c:out value="${usuario.cpf}" /></td>
					<td><c:out value="${usuario.dataNasc}" /></td> --%>
					<td class="align-top"><c:out value="${usuario.escolaridade}" /></td>
					<td class="align-top"><c:out value="${usuario.tempoAtuacao}" /></td>
					<td class="align-top"><c:out value="${usuario.idiomas}" /></td>
					<td class="align-top"><c:out value="${usuario.tecnologias}" /></td>
					<td class="align-top"><c:out value="${usuario.competencias}" /></td>
					<%-- <td><c:out value="${usuario.fornecedor}" /></td>
					<td><c:out value="${usuario.cnpj}" /></td>
					<td><c:out value="${usuario.site}" /></td>
					<td><c:out value="${usuario.representante}" /></td> --%>
                    <td class="align-top">
                    	<a href="usuario?action=edit&id=<c:out value='${usuario.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="usuario?action=delete&id=<c:out value='${usuario.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>	
</body>
</html>