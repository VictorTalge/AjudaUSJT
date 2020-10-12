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
ArrayList <Materia> materias = ms.buscarMateria();
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
<script src="https://kit.fontawesome.com/3dd5c4116c.js"
	crossorigin="anonymous"></script>

<!--HTML5Shiv -->
<!-- [if lt IE 9]>
      <script src"https://cdnjscloudflare.com/ajax/libs/
      html5shiv/3.7.3/html5shiv.js"></script>
    <![endif]-->

<!--Estilo customizado -->
<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<c:import url="Menu.jsp" />

	<!---- -------->

	<section>
		<form action="./AtualizarUsuario.do" method="POST">
			<div class="container pt-5">
			<input type="hidden" name="id" value="<%out.print(usuarioLogado.getId());%>">
				<!--Container -->
				<h1 class="mb-5">Perfil e Configurações</h1>
				<p class="cabecalho">
					<strong class="atual-perfil"> Perfil </strong> <a
						href="foto-usuario.jsp" class="ml-4">Foto de usuário</a>
				</p>
				<div class="row">
					<!--Row -->
					<div class="col-md-6">
						<!--col-md-6 -->

						<label for="usuario">Usuário</label>
						<div class="form-group">
							<input type="text" name="nome"
								placeholder="<%out.print(usuarioLogado.getNome());%>"
								value="<%out.print(usuarioLogado.getNome());%>"
								class="form-control">
						</div>

						<label for="senha">Senha</label>
						<div class="form-group">
							<input type="password" name="senha" placeholder="**********"
								value="<%out.print(usuarioLogado.getSenha());%>"
								class="form-control">
						</div>

						<label for="ra">R.A</label>
						<div class="form-group">
							<input type="text" name="ra"
								placeholder="<%out.print(usuarioLogado.getRa());%>"
								value="<%out.print(usuarioLogado.getRa());%>"
								class="form-control">
						</div>

						<label for="usuario" class="mt-3">Escolha uma matéria para
							ensinar</label>
						<div class="form-group">
							<select class="form-control" name="materia">
							<%for(int i=0;materias.size()>i;i= i+1){
								System.out.println("Materias na pag web: "+ materias.get(i).toString()+ "Na posisão " + i );
								out.println("<option>"+materias.get(i).getNome()+"</option>");
							} %>
								
							</select>
						</div>

					</div>
					<!--col-md-6 -->
					<div class="col-md-6">
						<!--col-md-6 -->

						<label for="usuario">E-mail</label>
						<div class="form-group">
							<input type="text" name="email"
								placeholder="<%out.print(usuarioLogado.getEmail());%>"
								value="<%out.print(usuarioLogado.getEmail());%>"
								class="form-control" readonly>
						</div>

						<label for="usuario">Estado</label>
						<div class="form-group">
							<select class="form-control" name="estado">
								<option>
									<%
										out.print(usuarioLogado.getEstado());
									%>
								</option>
								<option>Rio de Janeiro</option>
								<option>Amapá</option>
								<option>...</option>
							</select>
						</div>

						<label for="usuario">Cidade</label>
						<div class="form-group">
							<select class="form-control" name="cidade">
								<option>
									<%
										out.print(usuarioLogado.getCidade());
									%>
								</option>
								<option>Rio de Janeiro</option>
								<option>Floripa</option>
								<option></option>
							</select>
						</div>

						<input type="submit" value="Salvar"
							class="btn btn-outline-dark bt-save">


					</div>
					<!--col-md-6 -->
				</div>
				<!--/Row -->
			</div>
			<!--/Container -->
		</form>
	</section>

	<footer class="pt-3">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-6">
					<p class="">&copy; Copyright 2020 Ajuda SãoJudas</p>
				</div>
				<div class="col-md-6 d-flex justify-content-end">
					<p>
						<a href="">Sobre nós</a> <a href="">Quem somos</a> <a href="">Benefícios</a>
						<a href="">Ajuda e suporte</a> ${message}
					</p>
				</div>
			</div>
		</div>
	</footer>


	<!-- JavaScript (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>