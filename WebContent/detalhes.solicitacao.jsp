<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Solicitacao"%>
<%@page import="service.SolicitacaoService"%>
<%@page import="model.Materia"%>
<%@page import="service.MateriaService"%>
<%@page import="model.Usuario"%>
<%@page import="service.UsuarioService"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
Solicitacao solicitacao = new Solicitacao();
Usuario usuarioEnsina = new Usuario();
Materia materia = new Materia();
SolicitacaoService sc = new SolicitacaoService();
solicitacao = sc.carregar(Integer.parseInt(request.getParameter("id")));
UsuarioService us = new UsuarioService();
Usuario usuarioAprende = us.carregar(solicitacao.getCodAlunoAprende());
usuarioEnsina = us.carregar(solicitacao.getCodAlunoEnsina());
MateriaService ms = new MateriaService();
materia = ms.carregar(solicitacao.getCodMateria());
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

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
<script src="https://kit.fontawesome.com/3dd5c4116c.js"
	crossorigin="anonymous"></script>

<!--HTML5Shiv -->
<!-- [if lt IE 9]>
      < src"https://cdnjscloudflare.com/ajax/libs/
      html5shiv/3.7.3/html5shiv.js"></>
    <![endif]-->

<!--Estilo customizado -->
<link rel="stylesheet" type="text/css" href="css/estilo.css">

</head>
<body>
	<!-- - cabeçalho -->
	<c:import url="Menu.jsp" />
	<!-- - cabeçalho -->
	<section>
		<div class="container mt-5">
			<h2>Solicitação</h2>
			<div class="row">
				<div class="col-md-12 mt-2">
					<div class="mb-2 border rounded bg-dark">
						<div class="text-center">
							<h2 style="color: white;">
								<%
									out.print(materia.getNome());
								%>
							</h2>
						</div>
						<div class="bg-light">
							<div class="row">
								<div class="col-md-6  border-right border-bottom pl-4 pt-2">
									<p>
										Nome do aluno:
										<%
										out.print(" " + usuarioAprende.getNome());
									%>
									</p>
									<p>
										E-mail do aluno:
										<%
										out.print(" " + usuarioAprende.getEmail());
									%>
									</p>
								</div>
								<div class="col-md-6  border-left border-bottom pt-2">
									<p>
										Nome do professor:
										<%
										out.print(" " + usuarioEnsina.getNome());
									%>
									</p>
									<p>
										E-mail do professor:
										<%
										out.print(" " + usuarioEnsina.getEmail());
									%>
									</p>
								</div>
							</div>
							<div class="row mt-4">
								<div class="col-md-12 pl-4">
									<p>
										Local:
										<%
										out.print(" " + solicitacao.getLocal());
									%>
									</p>
									<p>
										Data:
										<%
										out.print(" " + solicitacao.getData());
									%>
									</p>
									<p>
										Horário:
										<%
										out.print(" " + solicitacao.getHoraInicio());
									%>
										- até -
										<%
										out.print(" " + solicitacao.getHoraFinal());
									%>
									</p>
								</div>
								<div class="btn-group-horizontal ml-4 pb-2">
									<%
									if (solicitacao.getStatus().equals("pendente") ){
											
										if(usuarioLogado.getId() != solicitacao.getCodAlunoAprende()){
											out.println("<a href='AtualizarSolicitacao.do?status=aceita&id="+solicitacao.getId()+"'><button class='btn btn-success btn-sm' type='button'>Aceitar</button></a>");								
											out.println("<a href='AtualizarSolicitacao.do?status=recusada&id="+solicitacao.getId()+"'><button class='btn btn-danger btn-sm' type='button'>Recusar</button></a>");
										}
										if(usuarioLogado.getId() == solicitacao.getCodAlunoAprende()){
											out.println("<a href='AtualizarSolicitacao.do?status=cancelada&id="+solicitacao.getId()+"'><button class='btn btn-warning btn-sm' type='button'>Cancelar </button></a>");
										}
									}
									else if (solicitacao.getStatus().equals("aceita") ){
										
									out.println("<a href='AtualizarSolicitacao.do?status=concluida&id="+solicitacao.getId()+"'><button class='btn btn-success btn-sm' type='button'>Concluir</button></a>");	
									out.println("<a href='AtualizarSolicitacao.do?status=cancelada&id="+solicitacao.getId()+"'><button class='btn btn-warning btn-sm' type='button'>Cancelar </button></a>");
									}
									
									%>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-6">
					<p class="">© Copyright 2020 Ajuda SãoJudas</p>
				</div>
				<div class="col-md-6 d-flex justify-content-end">
					<p>
						<a href="">Sobre nós</a> <a href="">Quem somos</a> <a href="">Benefícios</a>
						<a href="">Ajuda e suporte</a>
					</p>
				</div>
			</div>
		</div>
	</footer>



	<!-- Java (Opcional) -->
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