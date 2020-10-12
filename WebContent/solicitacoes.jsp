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
<link src="https://kit.fontawesome.com/3dd5c4116c.js"
	crossorigin="anonymous">
</>

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
		<div class="container pt-5">
			<!--Container -->
			<h1 class="mb-3 text-md-center ">Solicitação Realizadas</h1>
			<div class="border-bottom mb-5"></div>
			<div class="row prof-lista">
				<!--Row -->
				<div class="col-md-3">
					<div class="card">
						<div class="card-header">Aulas</div>
						<div class="card-body">
							<form>
								<label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="T"> <span class="form-check-label">Todos</span>
								</label> <label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="P"> <span class="form-check-label">Pendentes</span>
								</label> <label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="C"> <span class="form-check-label">Cancelado</span>
								</label> <label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="CO"> <span class="form-check-label">Concluido</span>
								</label> <label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="R"> <span class="form-check-label">Recusado</span>
								</label> <label class="form-check"> <input
									class="form-check-input check" type="checkbox" id="P" name="P"
									value="A"> <span class="form-check-label">Aceitas</span>
								</label>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<!--col-md-12 -->
					<div class="prof-lista">
						<ul class="list-group">
							<div class="media-body text-dark">

								<div>
									<%
										ArrayList<Solicitacao> solici = sc.solicitacoesAlunoAprende(usuarioLogado.getId());
									for (int i = 0; i < solici.size(); i++) {
										System.out.println(solici.get(i).toString() + "========");
									}
									for (int i = 0; i < solici.size(); i++) {
										usuario = us.carregar(solici.get(i).getCodAlunoEnsina());

										materia = ms.carregar(solici.get(i).getCodMateria());
										System.out.println(i);
										if (solici.get(i).getStatus().equalsIgnoreCase("pendente")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'><li class=' list-group-item text-dark stGeral st_P'>\r\n"
											+ "	          			<span><strong>Nome do professor: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("concluida")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "' ><li class='list-group-item text-dark stGeral st_CO'>\r\n"
											+ "	          			<span><strong>Nome do professor: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "> </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("cancelada")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'> <li class='list-group-item text-dark stGeral st_C'>\r\n"
											+ "	          			<span><strong>Nome do professor: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("recusada")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'><li class='list-group-item text-dark stGeral st_R'>\r\n"
											+ "	          			<span><strong>Nome do professor: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("aceita")) {
											out.println("	      <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'><li class='list-group-item text-dark stGeral st_A'>\r\n"
											+ "	          			<span><strong>Nome do professor: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}

									}
									%>
									<%
										solici = sc.solicitacoesAlunoEnsina(usuarioLogado.getId());
									for (int i = 0; i < solici.size(); i++) {
										System.out.println(solici.get(i).toString() + "========");
									}
									for (int i = 0; i < solici.size(); i++) {

										usuario = us.carregar(solici.get(i).getCodAlunoAprende());

										materia = ms.carregar(solici.get(i).getCodMateria());
										System.out.println(i);
										if (solici.get(i).getStatus().equalsIgnoreCase("pendente")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "' ><li class=' list-group-item text-dark stGeral st_P'>\r\n"
											+ "	          			<span><strong>Nome do Aluno: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("concluida")) {
											out.println("	    <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ " '> <li class='list-group-item text-dark stGeral st_CO'>\r\n"
											+ "	          			<span><strong>Nome do Aluno: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("cancelada")) {
											out.println("	      <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'><li class='list-group-item text-dark stGeral st_C'>\r\n"
											+ "	          			<span><strong>Nome do Aluno: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("recusada")) {
											out.println("	     <li class='list-group-item text-dark stGeral st_R'>\r\n"
											+ "'>          			<span><strong>Nome do Aluno: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
										if (solici.get(i).getStatus().equalsIgnoreCase("aceita")) {
											out.println("	     <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
											+ "'> <li class='list-group-item text-dark stGeral st_A'>\r\n"
											+ "	          			<span><strong>Nome do Aluno: </strong>" + usuario.getNome() + "</span>\r\n"
											+ "	           			<span><strong> Matéria: </strong>" + materia.getNome() + "   </span>\r\n"
											+ "	           			<span><strong> Status: </strong>" + solici.get(i).getStatus() + "</span>\r\n"
											+ "              			<span><strong> Código da Solicitação: </strong> " + solici.get(i).getId()
											+ " </span>\r\n" + "  			</li></a>");
										}
									}
									%>

								</div>
							</div>
					</div>
					</ul>
				</div>
			</div>
			<!--col-md-12 -->
		</div>
		<!--/Row -->
		</div>
		<!--/Container -->
	</section>

	<footer>
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-6">
					<p class="">© Copyright 2020 Ajuda SãoJudas ${erro}</p>
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

	<script>
		$(".check").click(function() {
			$(".stGeral").hide();
			$(".check").each(function() {
				st = $(this).val();
				if ($(this).is(":checked")) {
					$(".st_" + st).fadeIn();
				}
			});
		});
	</script>

	<!-- Java (Opcional) -->
	<!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	<link src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous">
	</>
	<link
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous">
	</>
	<link
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous">
	</>
</body>
</html>