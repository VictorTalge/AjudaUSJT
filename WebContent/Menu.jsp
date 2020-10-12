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
	UsuarioService us = new UsuarioService();
Usuario userLog = (Usuario) session.getAttribute("usuario");
%>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<header>

	<nav
		class="navbar navbar-expand-md navbar-light bg-light border-bottom">
		<div class="container">
			<a href="home.aluno.jsp" class="navbar-brand"> <img
				src="img/logoteste2.png" width="142" height="70">
			</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#nav-principal">
				<i class="fas fa-bars text-dark"></i>
			</button>
			<div class="collapse navbar-collapse menu" id="nav-principal">
				<ul class="navbar-nav">
					<li class="navbar-item"><a href="fazersolicitacao.jsp">Matérias</a>
						<ul>
							<li><a href="BuscarProfessores.do?pesquisarMaterias=calculo">Calculo</a></li>
							<li><a href="BuscarProfessores.do?pesquisarMaterias=java">Java</a></li>
							<li><a href="BuscarProfessores.do?pesquisarMaterias=Banco+de+Dados">Banco de Dados</a></li>
						</ul></li>
					<li class="navbar-item"><a href="solicitacoes.jsp">Solicitações</a>
						<ul>

						</ul></li>
					<li class="navbar-item"><a href="aulas.jsp">Aulas</a></li>
					<li class="navbar-item"></li>
				</ul>
				<form class="form-inline pesquisa" action="./BuscarProfessores.do"
					method="get">
					<div class="form-group">
						<input type="text" class="form-control" id="pesquisarMaterias"
							name="pesquisarMaterias" placeholder="pesquisar matérias"
							style="min-width: 400px;"> <input type="submit"
							class="btn btn-outline-danger" style="margin: 5px;"></input>
					</div>
				</form>


				<ul class="navbar-nav">
					<li class="navbar-item">
						<%
							out.print("<img src='img/" + userLog.getFoto() + "'  width='60' height='60'>");
						%>
						<ul>
							<li><a href="perfil.jsp">Configurar Perfil</a></li>
							<li><a href="foto-usuario.jsp">Alterar foto de Perfil</a></li>
							<li><a href="index.jsp">Sair</a></li>
						</ul>
					</li>
				</ul>

			</div>
		</div>
	</nav>
</header>