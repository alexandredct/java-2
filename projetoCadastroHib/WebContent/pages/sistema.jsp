<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="caminho" value ="${pageContext.request.contextPath }"/>

</head>
<body>


	<div class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
		<div class="container">
			<a href="../" class="navbar-brand">Bem vindo ao Spring MVC</a>


		</div>
	</div>



	<div class="container">
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h1 id="forms">Cadastro</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<div class="bs-component">

						<form method="POST" action="${caminho}/gravar">
							<fieldset>
								<legend>Cadastro</legend>

								<div class="form-group row">
									<label for="nome">Nome</label>
									<input type="text"
										class="form-control" name="nome" placeholder="Digite o nome">
								</div>

								<div class="form-group row">
									<label for="email">Email</label>
									<input type="email"
										class="form-control" name="email" placeholder="Digite o email">
								</div>

								<div class="form-group row">
									<label for="disciplina">Disciplina</label>
									<input type="text"
										class="form-control" name="disciplina"
										placeholder="Digite a disciplina">
								</div>

								<div class="form-group row">
									<label for="nota1">Nota 1</label> 
									<input type="number" min="0"
										max="10" class="form-control" name="nota1"
										aplaceholder="Digite a nota 1">
								</div>

								<div class="form-group row">
									<label for="nota2">Nota 2</label> <input type="number" min="0"
										max="10" class="form-control" name="nota2"
										aplaceholder="Digite a nota 2">
								</div>


								<div class="form-group row">
									<label for="foto">URL para a Foto</label> <input type="text"
										class="form-control" name="foto"
										placeholder="Entre com a URL para a foto">
								</div>

								<button type="submit" class="btn btn-primary">Gravar</button>
							</fieldset>
						</form>
					</div>
				</div>

				<div class="col-md-9">
					<div class="jumbotron">
						<h3 class="display-6 text-center">Respostas</h3>
							
						<hr class="my-4">

						<table class="table table-hover">
							<caption class="text-center">Aunos salvos</caption>
						  <thead>
						    <tr>
						      <th scope="col">Nome</th>
						      <th scope="col">Email</th>
						      <th scope="col">Disciplina</th>
						      <th scope="col">Nota 1</th>
						      <th scope="col">Nota 2</th>
						      <th scope="col">Media</th>
						    </tr>
						  </thead>
						  <tbody>
						  	
						  	
						  	<c:forEach items="${alunos}" var="aluno">
							    <tr class="table-active">
							    	<td>${aluno.nome}</td>
							      	<td>${aluno.email}</td>
							      	<td>${aluno.disciplina}</td>
							      	<td>${aluno.nota1}</td>
									<td>${aluno.nota2}</td>
							      	<td>${aluno.media}</td>
							    </tr>
						    </c:forEach>
						    
						    
						  </tbody>
						</table> 
						
						<hr class="my-4">
						
						<div class="alert alert-dismissible alert-link">
			                <h4 class="alert-heading">Mensagem de resposta</h4>
			                <p class="mb-0">${msg }.</p>
			              </div>
						
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
