<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="service.UsuarioService"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<title>Ajuda São Judas - Perfil</title>
<link rel="icon" href="img/favicon.png">

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
<script type="text/javascript"
	src="https://kit.fontawesome.com/3dd5c4116c.js" crossorigin="anonymous"></script>


<!--HTML5Shiv -->
<!-- [if lt IE 9]>
      < src"https://cdnjscloudflare.com/ajax/libs/
      html5shiv/3.7.3/html5shiv.js"></>
    <![endif]-->

<!--Estilo customizado -->
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<%
	Usuario usuario = new Usuario();
UsuarioService us = new UsuarioService();
Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
%>
</head>
<body>
	<c:import url="Menu.jsp" />

	<section>
		<div class="container pt-5">
			<!--Container -->
			<h1 class="mb-5">Perfil e Configurações</h1>
			<p class="cabecalho">
				<a href="perfil.jsp" class="mr-4">Perfil</a> <strong
					class="atual-perfil">Foto de usuário</strong>
			</p>
			<div class="row border rounded bg-light">
				<!--Row -->
				<div class="col-md-6 ">
					<h2 class="pb-3">
						<strong>Imagem de Perfil</strong>
					</h2>
					<%
						out.println("<img src='img/" + usuarioLogado.getId() + ".png' width='200' height='200'>");
					%>
				</div>
				<div class="col-md-6 align-self-center">
					<div class="custom-file" style="margin-left: -150px;">
						<form action="upload" method="post" enctype="multipart/form-data">
							<label class="custom-file-label">Selecione uma nova foto</label>
							<input type="file" name="file" id="file"
								class="custom-file-input"> <input type="submit"
								value="Concluir" class="btn btn-primary mt-4">
						</form>
					</div>
				</div>
				<!--/Row -->
			</div>

			<!--/Container -->
	</section>

	<footer class="pt-3 rodape">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-6">
					<p class="">© Copyright 2020 Ajuda SãoJudas</p>
				</div>
				<div class="col-md-6 d-flex justify-content-end">
					<p>
						${foto} <a href="">Sobre nós</a> <a href="">Quem somos</a> <a
							href="">Benefícios</a> <a href="">Ajuda e suporte</a>
					</p>
				</div>
			</div>
		</div>
	</footer>


	<!-- Java (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>