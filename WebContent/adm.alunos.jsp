<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Solicitacao"%>
<%@page import="service.SolicitacaoService"%>
<%@page import="model.Materia"%>
<%@page import="service.MateriaService"%>
<%@page import="model.Usuario"%>
<%@page import="service.UsuarioService"%>
<%@page import="model.Administrador"%>
<%@page import="service.AdministradorService"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Solicitacao solicitacao = new Solicitacao();
Usuario usuario = new Usuario();
Materia materia = new Materia();
SolicitacaoService sc = new SolicitacaoService();
AdministradorService as = new AdministradorService();
ArrayList <Usuario> todosUser = as.buscarUsuarios();
UsuarioService us = new UsuarioService();
Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
MateriaService ms = new MateriaService();
%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
  <style type="text/css">
  
  

/*------------Menu lateral Admin------------*/
#lateral {
	padding:0 50px 0 0;
	-moz-transition: all 0.5s ease;
		-webkit-transition: all 0.5s ease;
			-o-transition: all 0.5s ease;
				transition: all 0.5s ease;
	font-size:1.2em;
	background:rgb(44,62,80);
	background-image: -moz-linear-gradient(135deg, rgb(3,8,12), rgb(16,57,79));
     background-image: -webkit-linear-gradient(135deg, rgb(3,8,12), rgb(16,57,79));
      background-image: -o-linear-gradient(135deg, rgb(3,8,12), rgb(16,57,79) );
       background-image: -ms-linear-gradient(135deg, rgb(3,8,12), rgb(16,57,79));
        background-image: linear-gradient(135deg, rgb(3,8,12), rgb(16,57,79));
	height:100%;
	overflow:hidden;
	width:270px; 
	position:fixed;
	top:0;
	left:-220px;
	z-index: 500;
	}
#lateral:before {
	z-index:1000;
	content: url(icone-menu.png);
	font-size:4em;
	color:white;
	position:fixed;
	left:4px;
	top:45px;
	}
#lateral:hover:before, #lateral:focus:before {
left:-500px
	}
#lateral:hover, #lateral:focus,  #lateral:active  {
	-moz-transform: translate(220px, 0);
		-webkit-transform: translate(220px, 0);
			-o-transform: translate(220px, 0);
				transform: translate(220px, 0);
	padding-right:0;
	}

#lateral .box {
	list-style-type:none;
	margin-bottom:1em;;
	padding-bottom:1em;
	}
#lateral h3 {
	display:inline-block;
	font-weight:bold;
	font-size:1.6em;
	font-style:normal;
	padding-bottom:0.2em;
	margin: 2em 0 2em 0.81em;
	color:rgb(255,255,255);
	border-bottom: 4px solid rgb(155,155,155);
	}
#menu {
	font-style:italic;
	position:relative;
	font-size:1.0em;
	margin:1em 0 1em -1em;
	padding:0;
	}
#menu li {padding:0; margin:0;}
#menu ul li a,  #menu li a:link {
	font-size:1.2em;
	color:rgb(255,255,255);
	text-decoration: none;
	padding: 0.8em 0 0.8em 1em;
	display: block;
	-moz-transition: all 1.2s ease;
			-webkit-transition: all 1.2s ease;
				-o-transition: all 1.2s ease;
					transition: all 1.2s ease;
	}
#menu ul li a:hover {
	color: black;
	background-color:rgba(255,255,255,0.2);
	-moz-transition: all 0.5s ease;
			-webkit-transition: all 0.5s ease;
				-o-transition: all 0.5s ease;
					transition: all 0.5s ease;
	}

@media (max-width: 500px) {
body {margin-left:0;background-size:100% 28em!important;}
#lateral {
	padding:0;
	-moz-transition: all 0.5s ease;
		-webkit-transition: all 0.5s ease;
			-o-transition: all 0.5s ease;
				transition: all 0.5s ease;
	font-size:1.2em;
	height:100%;
	overflow:auto;
	width:100%; 
	position:static;
	top:0;
	left:0;
	}
#lateral:before {
	z-index:1000;
	width:0;
	text-align:center;
	content: "";
	font-size:0;
	color:white;
	position:static;
	top:0;
	left:0;
	display:inline-block; 
	}
#lateral:hover, #lateral:focus {
	overflow:scroll;
	-moz-transform: none;
		-webkit-transform: none;
			-o-transform:none;
				transform:none;
	}
#menu li a {border-bottom:1px solid #ccc;}
#menu li:first-child a {border-top:1px solid #ccc;}	
}
  
  </style>

    <title>Ajuda São Judas</title>
    <link rel="icon" href="imagens/favicon.png">
<script src="js/query-3.5.1.min.js"></script>


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

	
<%
if(usuarioLogado.getAdm().equals("s")){
	out.print("	<div id='lateral'>\r\n" + 
			"		<nav class='menu navbar'>\r\n" + 
			"\r\n" + 
			"			<h3 class='link-titulo'>Ferramentas</h3>\r\n" + 
			"			<ul class='box navbar-nav'>\r\n" + 
			"				<li class='navbar-item'><a href='adm.noticias.jsp' class='text-white'><i\r\n" + 
			"						class='fas fa-newspaper mr-1'></i>Notícias</a></li>\r\n" + 
			"				<li class='navbar-item'><a href='adm.alunos.jsp' class='text-white'><i\r\n" + 
			"						class='fas fa-users mr-1'></i>Alunos</a></li>\r\n" + 
			"				<li class='navbar-item'><a href='CarregarDashboard.do' class='text-white'><i\r\n" + 
			"						class='far fa-chart-bar mr-1'></i>Gráfico</a></li>\r\n" + 
			"			</ul>\r\n" + 
			"		</nav>\r\n" + 
			"		\r\n" + 
			"	</div id='link'>");
}
%>
   
<!-- vazio -->

    <section>
      <div class="container mt-5">
        <h1 class="mb-3 text-md-center ">Usuários</h1>
        <div class="border-bottom mb-5"></div>
          <div class="row">
            <div class="col-md-12">
              <div class="form-group input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                <input name="consulta" id="txt_consulta" placeholder="Procurar pelo Nome, RA ou ID" type="text" class="form-control" style="max-width: 500px;">
              </div>
              <table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th>Nome</th>
                    <th>E-Mail</th>
                    <th>R.A</th>
                    <th>ID</th>
                  </tr>
                  <a href="s"></a>
                </thead>
                <tbody>
                <%
                for(int i=0;todosUser.size()>i;i++){
                	System.out.println("Carregando usuarios:" +todosUser.get(i).toString());
                	out.println("<tr>");
                	out.println("<td><a href='adm.alunos.sub.jsp?id="+todosUser.get(i).getId()+"'>"+todosUser.get(i).getNome() +"</a></td>");
                	out.println(" <td>"+todosUser.get(i).getEmail() +"</td>");
                	out.println(" <td>"+todosUser.get(i).getRa() +"</td>");
                	out.println(" <td>"+todosUser.get(i).getId() +"</td>");
                	out.println("</tr>");
                }
                
                %>
                  <tr>
                    <td>Vitor Dantas Rodrigues</td>
                    <td>dantasvitor42@gmail.com</td>
                    <td>819110978</td>
                    <td>09876</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="col col-md-12">
             
            </div>
          </div>
      </div>
    </section>
    <footer class="pt-3">
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