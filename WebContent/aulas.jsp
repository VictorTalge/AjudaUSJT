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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="css/estilo.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/3dd5c4116c.js" crossorigin="anonymous"></script>

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


     <section>
      <div class="container pt-5"><!--Container -->
        <h1 class="mb-3 text-md-center ">Próximas Aulas</h1>
        <div class="border-bottom mb-5"></div>
        <div class="row prof-lista"><!--Row -->
        	</div>
         	<div class="col-md-12 "><!--col-md-12 -->
        		<div class="prof-lista">
            		<ul class="list-group">
	                
	                
	                 		<%
								ArrayList<Solicitacao> solici = sc.solicitacoesAlunoEnsina(usuarioLogado.getId());
	                 			
							for (int i = 0; i < solici.size(); i++) {
								System.out.println(solici.get(i).toString() + "========");
							}for (int i = 0; i < solici.size(); i++) {
								materia = ms.carregar(solici.get(i).getId());
								usuario = us.carregar(solici.get(i).getCodAlunoAprende());
								if(solici.get(i).getStatus().equalsIgnoreCase("aceita")){
								out.println("  <a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
										+ "'>   <li class=\"list-group-item \">\r\n" + 
										"	                   <div>\r\n" + 
										"	                     <div class=\"media-body text-dark\">\r\n" + 
										"	                       <span><strong>Professor: </strong> "+ usuario.getNome()+"</span>\r\n" + 
										"	                       <span><strong>Matéria: </strong> "+ materia.getNome()+" </span>\r\n" + 
										"                         <span><strong>Data: </strong> "+solici.get(i).getData()+"</span>\r\n" + 
										"	                       <span><strong>Horário: </strong>"+ solici.get(i).getHoraInicio()+" " +"até "+solici.get(i).getHoraFinal() +"   </span>\r\n" + 
										"                         <span><strong>Local da aula: </strong> São Judas Paulista - Livraria</span>\r\n" + 
										"	                     </div>\r\n" + 
										"	                   </div>\r\n" + 
										"	                	</li><</a>"
										);	
							
								}
								}
								%>
              		</ul>
            	</div>
          	</div><!--col-md-12 -->
            <div class="col-md-12 mt-5"><!--col-md-12 -->
              <h1 class="mb-3 text-md-center ">Próximas Aulas a ensinar</h1>
              <div class="prof-lista">
                <ul class="list-group">
    	                 		<%
				        solici = sc.solicitacoesAlunoEnsina(usuarioLogado.getId());
	                 			
							for (int i = 0; i < solici.size(); i++) {
								System.out.println(solici.get(i).toString() + "========");
							}for (int i = 0; i < solici.size(); i++) {
								materia = ms.carregar(solici.get(i).getId());
								usuario = us.carregar(solici.get(i).getCodAlunoAprende());
								if(solici.get(i).getStatus().equalsIgnoreCase("aceita")){
								out.println("	<a href='detalhes.solicitacao.jsp?id=" + solici.get(i).getId()
										+ "'>   	    <li class=\"list-group-item \">\r\n" + 
										"	                   <div>\r\n" + 
										"	                     <div class=\"media-body text-dark\">\r\n" + 
										"	                       <span><strong>Aluno: </strong> "+ usuario.getNome()+"</span>\r\n" + 
										"	                       <span><strong>Matéria: </strong> "+ materia.getNome()+" </span>\r\n" + 
										"                         <span><strong>Data: </strong> "+solici.get(i).getData()+"</span>\r\n" + 
										"	                       <span><strong>Horário: </strong>"+ solici.get(i).getHoraInicio()+" " +"até "+solici.get(i).getHoraFinal() +"   </span>\r\n" + 
										"                         <span><strong>Local da aula: </strong> São Judas Paulista - Livraria</span>\r\n" + 
										"	                     </div>\r\n" + 
										"	                   </div>\r\n" + 
										"	                	</li></a>");	
							}
								}%>              </ul>
              </div>
            </div><!--col-md-12 -->
        </div><!--/Row -->
      </div><!--/Container -->
    </section>

    <footer>
      <div class="container">
        <div class="row justify-content-between">
          <div class="col-md-6">
            <p class="">© Copyright 2020 Ajuda SãoJudas</p>
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


    <!-- Java (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>