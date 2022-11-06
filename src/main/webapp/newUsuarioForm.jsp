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

		<!-- <form> -->

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

<!-- Div do fone: -->

					<div class="form-group">
						<label for="fone" id="fone-label">Fone principal*</label> 
						<input type="text" name="fone" id="tel1" class="form-control" required
							value="<c:out value='${usuario.fone}'/>">
					</div>

<!-- Div do cep: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="cep">CEP*</label>  <!-- id="cep" --> 
						<input type="text" id="cep" class="form-control" required
							value="<c:out value='${usuario.cep}'/>">
					</div>

<!-- Div da rua: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="logradouro">Rua*</label> <!-- id="logradouro" --> 
						<input type="text" id="logradouro" class="form-control" required
							value="<c:out value='${usuario.logradouro}'/>">
					</div>

<!-- Div de número: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="numero">nº*</label> <!-- id="numero" --> 
						<input type="text" id="numero" class="form-control" required
							value="<c:out value='${usuario.numero}'/>">
					</div>

				</div>

<!-- Nova linha de duas colunas: -->

				<div class="form-row">

<!-- Div do complemento: -->

					<div class="form-group">
						<label for="complemento" id="complemento-label">Complemento</label>
						<input type="text" id="complemento" class="form-control"
							value="<c:out value='${usuario.complemento}'/>">
					</div>

<!-- Div do bairro: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="bairro" id="bairro-label">Bairro*</label> 
						<input type="text" id="bairro" class="form-control" required
							value="<c:out value='${usuario.bairro}'/>">
					</div>

<!-- Div da cidade: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="localidade">Cidade*</label> <!-- id="localidade" --> 
						<input type="text" id="localidade" class="form-control" required
							value="<c:out value='${usuario.localidade}'/>">
					</div>

<!-- Div do UF: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="uf">UF*</label> <!-- id="uf" --> 
						<input type="text" id="uf" class="form-control" required
							value="<c:out value='${usuario.uf}'/>">
					</div>

<!-- Div de Fornecedor: -->

					<div class="form-group form-check"><br>
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

<!-- Div de idiomas: -->

					<div class="form-group" style="margin-left: 10px;">
						<label for="idiomas">UF*</label> <!-- id="uf" --> 
						<input type="text" id="idiomas" class="form-control" required
							value="<c:out value='${usuario.idiomas}'/>">
					</div>

<!-- Idiomas em dropdown: 

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
					-->

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
				</div>
		</form>

	</div>

</body>

</html>