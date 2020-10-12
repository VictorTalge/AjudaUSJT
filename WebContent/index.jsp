<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%session.setAttribute("usuario", null); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Ajuda São Judas</title>
<link rel="icon" href="imagens/favicon.png">

<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
	<form action="Login" method="post">

		<header>
			<nav
				class="navbar navbar-expand-md navbar-light bg-light border-bottom">
				<div class="container">
					<a href="index.html" class="navbar-brand"> <img
						src="img/logoteste2.png" width="160" height="80">
					</a>
					<button class="navbar-toggler" data-toggle="collapse"
						data-target="#nav-principal">
						<i class="fas fa-bars text-dark"></i>
					</button>
					<div class="row">
						<div class="col-md-5">
							<div class="form-group">
								<label for="usuario" class="ml-1">Usuário</label> <input
									class="form-control" type="text" name="email" id="email"
									placeholder="E-mail" required>
							</div>

						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label for="senha" class="ml-1">Senha</label> <input
									class="form-control" type="password" name="senha" id="senha"
									placeholder="Senha" required>
									<input type= "hidden" class="is-invalid">
								<div class="invalid-feedback">${erro}</div>
							</div>
						</div>
						<div class="col-md-2 botao-top">
							<button class="btn btn-danger" type="submit">Submit</button>
						</div>
					</div>
				</div>
			</nav>
		</header>
	</form>

	<section id="login-cadastro">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="card bg-light">
						<div class="card-body">
							<h4 class="card-title text-center mb-5">Crie sua conta</h4>
							<form action="CriarUsuario.do" method="post"
								id="formCadastroUsuario">
								<div class="form-group">
									<input class="form-control" type="text" name="nome" id="nome"
										placeholder="Nome completo" required>
								</div>
								<div class="form-group">
									<input class="form-control" type="text" name="email"
										id="usuario" placeholder="E-mail" required>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input class="form-control" type="password" name="senha"
												id="senha" placeholder="Senha" required>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<input class="form-control" type="password" name="csenha"
												id="csenha" placeholder="Confirme a senha" required>
										</div>
									</div>
								</div>
								<div class="form-group">
									<input class="form-control" type="text" name="ra" id="ra"
										placeholder="Digite seu R.A" required>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input class="form-control" type="text" name="cidade"
												id="cidade" placeholder="Cidade" required>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<input class="form-control" type="text" name="estado"
												id="estado" placeholder="Estado" required>
										</div>
									</div>
								</div>
								<h9>*opcional</h9>
								<div class="form-group">
									<input class="form-control" type="text" name="materia"
										id="materia" placeholder="Matéria que deseja ensinar">
								</div>
								<input class="btn btn-outline-danger  btn-block mb-4"
									type="submit" value="Cadastre-se">
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-7" style="margin-top: 80px">
					<img src="img/fundo-index.png" class="img-fluid" width="800"
						height="800">
				</div>
			</div>
		</div>
	</section>

	<footer class="pt-3 rodape">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-md-6">
					<p class="">&copy; Copyright 2020 Ajuda SãoJudas</p>
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