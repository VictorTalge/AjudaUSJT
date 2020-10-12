<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Solicitacao"%>
<%@page import="service.SolicitacaoService"%>
<%@page import="model.Administrador"%>
<%@page import="service.AdministradorService"%>
<%@page import="model.Materia"%>
<%@page import="service.MateriaService"%>
<%@page import="model.Usuario"%>
<%@page import="service.UsuarioService"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	AdministradorService as = new AdministradorService();
Solicitacao solicitacao = new Solicitacao();
Usuario usuario = new Usuario();
Materia materia = new Materia();
SolicitacaoService sc = new SolicitacaoService();
UsuarioService us = new UsuarioService();
Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
MateriaService ms = new MateriaService();
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<title>Ajuda São Judas - Professores</title>
<link rel="icon" href="imagens/favicon.png">

<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="css/estilo.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!-- Font awesome -->
<style src="https://kit.fontawesome.com/3dd5c4116c.js"
	crossorigin="anonymous"></style>

<!--HTML5Shiv -->
<!-- [if lt IE 9]>
      < src"https://cdnjscloudflare.com/ajax/libs/
      html5shiv/3.7.3/html5shiv.js"></>
    <![endif]-->

<!--Estilo customizado -->
<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>

	<c:import url="Menu.jsp" />

	<!-- -menu -->
	<section>
		<div class="container pt-5">
			<!--Container -->
			<element>
			<h1 class="mb-3 text-md-center ">Professores de ${nomeMateria}</h1>
			</element>
			<div class="border-bottom mb-5"></div>
			<div class="row prof-lista">
				<!--Row -->
				<div class="col-md-12">
					<!--col-md-12 -->
					<div class="prof-lista">

						<ul class="list-group">
							<%
								ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("array");
							if (usuarios != null) {
								for (int i = 0; usuarios.size() > i; i++) {
									Usuario userEnsina = usuarios.get(i);
									
									out.println("<li class='list-group-item '><a href= 'nova.solicitacao.jsp" + "?id=" + usuarios.get(i).getId() + "&idmateria=" + userEnsina.getCodMateriaBoa() +"'>" +" <div class='media'>"
									+ "<img class='mr-3 align-self-center'" + "src='img/" + usuarios.get(i).getFoto() + "'width='60' height='60'>"
									+ "<div class='media-body text-dark'>" + "<h5>" + usuarios.get(i).getNome() + "</h5>"
									+ "<p>Quantidade de aulas realizadas:</p>" + "</div>" + "</div>" + "</a></li>");

								}
							}
							%>

						</ul>
					</div>
				</div>
				<!--col-md-12 -->
			</div>
			<!--/Row -->
		</div>
		<!--/Container -->
	</section>
	<% if(usuarios == null){
		out.print("<footer class='pt-3 rodape-fixo'>");
	}
	else if(usuarios.size()< 3 ){
		out.print("<footer class='pt-3 rodape-fixo'>");
	}else{
		out.print("<footer class='pt-3'>");
	} %>
    
      <div class="container">
        <div class="row justify-content-between">
          <div class="col-md-6">
            <p class="">&copy; Copyright 2020 Ajuda SãoJudas</p>
          </div>
          <div class="col-md-6 d-flex justify-content-end">
            <p>
              <a href="">Sobre nós</a>
              <a href="">Quem somos</a>
              <a href="">Benefícios</a>
              <a href="">Ajuda e suporte</a>
            </p>
          </div>
        </div>
      </div>
    </footer>

	${erro}

	<!-- Java (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<style src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></style>
	<style
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></style>
	<style
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></style>
</body>
</html>