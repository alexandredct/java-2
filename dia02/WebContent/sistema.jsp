<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap/bootstrap-4.3.1-dist/css/bootstrap.css">
<script type="text/javascript" src="jquery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap-4.3.1-dist/js/bootstrap.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container-fluid">

	<h2 class="p-3 bg-dark text-white text-center">Projeto Login</h2>
	<div class="col-md-10 offset-md-1">
		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a href="#login" class="nav-link active" data-toggle="tab">Login</a>
			</li>
			<li class="nav-item">
				<a href="#cadastro" class="nav-link" data-toggle="tab">Cadastro</a>
			</li>
		</ul>
		
		<div class="tab-content" id="login">
			<div class="tab-pane fade show active" id="login" role="tabpanel">
				<form method="POST" action="UsuarioController">
					<label>Login:</label>
					<input type="email" name="email" placeholder="Digite o login" required class="form-control">
					
					<label>Senha:</label>
					<input type="password" name="senha" placeholder="Digite o email" required class="form-control">
					<br>
					<button type="submit" class="btn btn-info">Logar</button>
					<br>
					${msg}
				</form>
			</div>
			<div class="tab-pane fade" id="cadastro" role="tabpanel">
				
			</div>
		</div>
	</div>
	
	
</div>

</body>
</html>