<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Solicitacao"%>
<%@page import="service.SolicitacaoService"%>
<%@page import="model.Materia"%>
<%@page import="service.MateriaService"%>
<%@page import="model.Usuario"%>
<%@page import="service.UsuarioService"%>
<%@page import="java.util.ArrayList"%>
<html lang="pt-br">


<head>

<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" type="text/css" href="css/estilo.css">
 <title>Ajuda São Judas - Perfil</title>
    <link rel="icon" href="img/favicon.png">

    <!-- Meta tags Obrigatórias -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/estilo.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/3dd5c4116c.js" crossorigin="anonymous"></script>

    <!--HTML5Shiv -->
    <!-- [if lt IE 9]>
      <script src"https://cdnjscloudflare.com/ajax/libs/
      html5shiv/3.7.3/html5shiv.js"></script>
    <![endif]-->

    <!--Estilo customizado -->
    <link rel="stylesheet" type="text/css" href="css/estilo.css">
  
</head>

<body>
	<%
		Solicitacao solicitacao = new Solicitacao();
	Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
	System.out.print("aaaaaaaaaaaaaaaaa " + usuarioLogado.toString());
	SolicitacaoService sc = new SolicitacaoService();
	UsuarioService us = new UsuarioService();
	Usuario usuario = us.carregar(Integer.parseInt(request.getParameter("id")));
	MateriaService ms = new MateriaService();
	Materia materia = ms.carregar(Integer.parseInt(request.getParameter("idmateria")));
	%>


		<c:import url="Menu.jsp" />


	<div class="gray">


		<div class="   col-md-4 offset-md-4" class="container ">
			<div class="panel panel-primary">
				<div class="panel-heading">Faça sua solicitação</div>
				<div class="panel-body">

					<form action="./CriarSolicitacao.do" method="POST"
						name="formulario">


						<div class="form-group">
							<div>
								<label>Seu Nome</label> <input type="text" readonly
									class="form-control" id="staticEmail"
									value="<%out.print(usuarioLogado.getNome());%>">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label> Email </label> <input name="emailaprende" type="text"
									readonly class="form-control" id="staticEmail"
									value="<%out.print(usuarioLogado.getEmail());%>">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label>Nome de quem o ajudará</label> <input type="text"
									readonly class="form-control" id="staticEmail"
									value="<%out.print(usuario.getNome());%>">
							</div>
						</div>

						<div class="form-group">
							<div>
								<label> Email </label> <input name="email" id="email"
									type="text" readonly class="form-control" id="staticEmail"
									value="<%out.print(usuario.getEmail());%>">
							</div>
						</div>
						<div class="form-group">
							<div>
								<label> Matéria </label> <input type="text" readonly
									class="form-control" id="staticEmail"
									value="<%out.print(materia.getNome());%>">
							</div>
						</div>

						<div class="form-group">
							<label> Local </label> <select name="local" id="local"
								class="form-control form-control-lg">
								<option>Mocca - São Judas</option>
								<option>Paulista - São Judas</option>
								<option>Butantã - São Judas</option>
								<option>Santo Amaro - São Judas</option>
								<option>Vila Leolpoldina - São Judas</option>

							</select>
						</div>

						<div class="col-md-12 offset-md-0" class="form-group">
							<div>
								<label>Data </label><input type="date" name="data" id="data" 
									class="form-control" placeholder="Ex.: dd/mm/aaaa"
									data-mask="00/00/0000" maxlength="10" autocomplete="off">
							</div>
							
						</div>
								<div class="col-md-6 offset-md-0" class="form-group">
							<div>
								<label>ínicio </label><input type="time" name="horaInicio" id="horaInicio" 
									class="form-control" placeholder="Ex.: dd/mm/aaaa"
									data-mask="00/00/0000" maxlength="10" autocomplete="off">
							</div>
							
						</div>
						<div class="col-md-0 offset-md-6" class="form-group">
							<div>
								<label>Término </label> <input type="time"name="horaFinal" id="horaFinal" 
									class="form-control time-mask" placeholder="Ex.: 00:00:00">
							</div>
						</div>

						<br>

						<div class="form-group">
							<div>
								<input type="submit" value="Enviar Solicitação"
									class="btn btn-primary" name="">

							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>