<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/newUsuario.css" />
<title>Adicionar Novo Usuário</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Sistema Vagas</h1>
        <div id="form-container">
           <p id="description">
              Insira as informações para adicionar ou editar um usuário
           </p>
           <h2>
        	<a href="usuario">Listar todos os usuários</a> &nbsp;&nbsp;&nbsp;
        	<a href="usuario?action=new">Adicionar um usuário</a>
	       </h2>
           <c:if test="${usuario != null}">
				<form action="usuario?action=update" method="post">
	        </c:if>
	        <c:if test="${usuario == null}">
				<form action="usuario?action=insert" method="post">
	        </c:if>
	        <c:if test="${usuario != null}">
       			<input type="hidden" name="id" class="input-field" value="<c:out value='${usuario.id}'/>"/> 
        	</c:if>
              <div class="formRow">
                 <label id="name-label" class="label-cls" for="name">* Nome </label>
                 <div class="input-col">
                    <input autofocus type="text" name="nome" id="nome" class="input-field" value="<c:out value='${usuario.name}'/>"
                    placeholder="Nome do usuário" required >  
                 </div>
              </div>
              <div class="formRow">
                 <label id="email-label" class="label-cls" for="email">* Email: </label>
                 <div class="input-col">
                    <input type="text" name="email" id="email" class="input-field" value="<c:out value='${usuario.email}'/>"
                    required placeholder="E-mail" >
                 </div>
              </div>
              <div class="formRow">
                 <label id="number-label" class="label-cls" for="age"> Nível: </label>
                 <div class="input-col">
                    <input type="number" name="nivel" id="nivel"  class="input-field" value="<c:out value='${usuario.nivel}'/>"
                    placeholder="Nível do usuário" > 
                 </div>
              </div>
              
              <button id="submit" type="submit">Enviar</button>
           </form>
        </div>
      </div>
     </div>
      
</body>
</html>