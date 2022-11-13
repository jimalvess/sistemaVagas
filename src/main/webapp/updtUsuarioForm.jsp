<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Imports -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

    <!-- JQuery para buscar o CEP -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>


<script>

    $(document).ready(function() {

        function limpa_formulário_cep() {
            
            // Limpa valores do formulário de cep.
            $("#logradouro").val("");
            $("#bairro").val("");
            $("#localidade").val("");
            $("#uf").val("");
        }
        
        //Quando o campo cep perde o foco.
        $("#cep").blur(function() {

            //Nova variável "cep" somente com dígitos.
            var cep = $(this).val().replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if(validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    $("#rua").val("...");
                    $("#logradouro").val("...");
                    $("#localidade").val("...");
                    $("#uf").val("...");

                    //Consulta o webservice viacep.com.br/
                    $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                        if (!("erro" in dados)) {
                            //Atualiza os campos com os valores da consulta.
                            $("#logradouro").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#localidade").val(dados.localidade);
                            $("#uf").val(dados.uf);
                        } //end if.
                        else {
                            //CEP pesquisado não foi encontrado.
                            limpa_formulário_cep();
                            alert("CEP não encontrado.");
                        }
                    });
                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        });
    });

</script>
    

<!-- nome na barra: -->

<title>Atualizar Usuário</title>

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

		<p id="description">Campos com <span style="color: red;">*</span> são obrigatórios:</p>

		<!-- <form> -->

			<div class="form-group">

<!-- Se for pra atualizar: -->
				
			<form action="usuario?action=update" method="post">
				
				<input type="hidden" name="id" class="input-field" value="<c:out value='${usuario.id}'/>" />

<!-- Container do form em colunas: -->

				<div class="form-row">

<!-- Div do nome: -->

					<div class="form-group">
						<label for="nome" id="nome-label">Nome<span style="color: red;">*</span></label> 
						<input type="text" name="nome" id="nome" class="form-control" required
							value="<c:out value='${usuario.nome}'/>" > 
							
					</div>

<!-- Div do email: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="email" id="email-label">E-mail<span style="color: red;">*</span></label> 
						<input type="text" name="email" id="email" class="form-control" required
							value="<c:out value='${usuario.email}'/>">
					</div>

<!-- Div do login: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="login" id="login-label">Login<span style="color: red;">*</span></label>
						<input type="text" name="login" id="login" class="form-control" required
							value="<c:out value='${usuario.login}'/>"
							placeholder="seu nome de entrada">
					</div>

<!-- Div da senha: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="senha" id="senha-label">Senha<span style="color: red;">*</span></label> <input
							type="password" name="senha" id="senha" class="form-control" required
							value="<c:out value='${usuario.senha}'/>"
							placeholder="sua senha de entrada">
					</div>

<!-- Div de cpf: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cpf" id="cpf-label">CPF<span style="color: red;">*</span></label> 
						<input type="text" name="cpf" id="cpf" class="form-control" required
							value="<c:out value='${usuario.cpf}'/>"
							placeholder="somente números">
					</div>

				</div>

<!-- Nova linha em colunas: -->

				<div class="form-row">

<!-- Div da data de nascimento: -->

					<div class="form-group">
						<label for="dataNasc" id="dataNasc-label">Data de Nascimento<span style="color: red;">*</span></label> 
						<input type="text" name="dataNasc" id="dataNasc" class="form-control" required
							value="<c:out value='${usuario.dataNasc}'/>"
							placeholder="somente números">
					</div>

<!-- Div do fone: -->

					<div class="form-group" style="padding-left: 0.8%;">
						<label for="fone" id="fone-label">Fone:<span style="color: red;">*</span></label>
						<input type="text" name="fone" id="fone" class="form-control" required
							value="<c:out value='${usuario.fone}'/>">
					</div>

<!-- Div do cep: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cep" id="cep-label" >CEP<span style="color: red;">*</span></label>
						<input type="text" id="cep" class="form-control" required
							value="<c:out value='${usuario.cep}'/>">
					</div>

<!-- Div da rua: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="logradouro" id="logradouro-label" >Rua<span style="color: red;">*</span></label> 
						<input type="text" id="logradouro" name="logradouro" class="form-control" required
							value="<c:out value='${usuario.logradouro}'/>">
					</div>

<!-- Div de número: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="numero" id="numero-label" >nº<span style="color: red;">*</span></label>
						<input type="text" id="numero" name="numero" class="form-control" required
							value="<c:out value='${usuario.numero}'/>">
					</div>

				</div>

<!-- Nova linha em colunas: -->

				<div class="form-row">

<!-- Div do complemento: -->

					<div class="form-group">
						<label for="complemento" id="complemento-label">Complemento</label>
						<input type="text" id="complemento" name="complemento" class="form-control"
							value="<c:out value='${usuario.complemento}'/>">
					</div>

<!-- Div do bairro: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="bairro" id="bairro-label">Bairro<span style="color: red;">*</span></label> 
						<input type="text" id="bairro" name="bairro" class="form-control" required
							value="<c:out value='${usuario.bairro}'/>">
					</div>

<!-- Div da cidade: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="localidade" id="localidade-label" >Cidade<span style="color: red;">*</span></label> 
						<input type="text" id="localidade" name="localidade" class="form-control" required
							value="<c:out value='${usuario.localidade}'/>">
					</div>

<!-- Div do UF: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="uf" id="uf-label" >UF<span style="color: red;">*</span></label>
						<input type="text" id="uf" name="uf" class="form-control" required
							value="<c:out value='${usuario.uf}'/>">
					</div>

<!-- Div de Fornecedor: -->

					<div class="form-group form-check"><br><br>
						<input type="checkbox" name="fornecedor-check" value="${usuario.fornecedor}" id="fornecedor-check" class="form-check-input">
						<label for="fornecedor" id="fornecedor" class="text-primary">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Marque se for fornecedor</label>
					</div>

				</div>

<!-- Nova linha em colunas: -->

				<div class="form-row">

<!-- Div da escolaridade: -->

					<div class="form-group" style="padding-left: 0.1%">
						<label for="escolaridade" id="escolaridade-label">Escolaridade<span style="color: red;">*</span></label>
						<input type="text" name="escolaridade" id="escolaridade" class="form-control" required
							value="<c:out value='${usuario.escolaridade}'/>">
					</div>

<!-- Div de idiomas: -->

					<div class="form-group" style="margin-left: 0.8%;">
						<label for="idiomas" id="idiomas-label" >Idiomas<span style="color: red;">*</span></label> 
						<input type="text" name="idiomas" id="idiomas" class="form-control" required
							value="<c:out value='${usuario.idiomas}'/>">
					</div>
					
<!-- Div da data de competencias: -->

					<div class="form-group" style="margin-left: 0.8%;">
						<label for="competencias" id="competencias-label">Competências Conhecidas<span style="color: red;">*</span></label> 
						<input type="text" name="competencias" id="competencias" class="form-control" required
							value="<c:out value='${usuario.competencias}'/>"
							placeholder="uma palavra para cada">
					</div>
					
<!-- Div de redes sociais: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="redesSociais" id="redesSociais-label">Suas redes sociais</label> 
						<input type="text" name="redesSociais" id="redesSociais"  class="form-control"
							value="<c:out value='${usuario.redesSociais}'/>"
							placeholder="links separados por vírgula">
					</div>
					
					<!-- Div do site: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="site" id="site-label">Seu site aqui</label> 
						<input type="text" name="site" id="site" class="form-control"
							value="<c:out value='${usuario.site}'/>"
							placeholder="comece com www...">
					</div>

				</div>

<!-- Nova linha em colunas: -->

				<div class="form-row">

<!-- Div descrição: --> 

					<div class="form-group" style="padding-left: 0.1%">
						<label for="descricao" id="descricao-label">Fale mais de você...</label>
						<textarea class="form-control" name="dataNasc" id="descricao" rows="1" cols="50">${usuario.descricao}</textarea>
					</div>

<!-- FALTA DEFINIR LOCAL: Div escolher foto: -->

					<div class="form-group" style="padding-left: 1%;">
						<label for="foto" id="foto-label" >Quer nos mandar sua foto?</label> 
						<input type="file" class="btn btn-light" id="foto"
							value="<c:out value='${usuario.foto}'/>">
					</div>

<!-- Div Botão Enviar: -->

					<div class="form-group" style="padding-left: 9.8%;">
						<br><button id="submit" type="submit" class="btn btn-primary" >Enviar as Informações</button>
					</div>
				</div>
				</div>
		</form>

	</div>

</body>

</html>