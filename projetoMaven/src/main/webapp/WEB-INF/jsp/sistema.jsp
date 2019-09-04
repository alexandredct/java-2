<!DOCTYPE html>

<head>
  <title>Projeto Maven</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="caminho" value="${ pageContext.request.contextPath }"/>

<body>
<div class="jumbotron text-center">
  <h1>${titulo}</h1>
</div>
<div class="container">
	<div class="card">
		<div class="card-body">
			<h2 class="card-title bg-primary">Incluir usuário</h2>
		
			<div class="panel">				
				<form action="${caminho}/gravar" method="POST">
				
					 <div class="input-group mb-3 input-group-sm">
					     <div class="input-group-prepend">
					       <span class="input-group-text">Nome</span>
					    </div>
						<input class="form-control" type="text" name="nome"/>
						</div>
					
					<label>Email</label>
					<input class="form-control" type="email" name="email"/>
					
					<label>Senha</label>
					<input class="form-control" type="password" name="senha"/>
					
					<button type="submit" class="btn btn-success stretched-link">Gravar dados</button>
				</form>
			</div>	
	
			<div class="panel text-center">
				
					<table class="table">
					<thead>
						<tr class="text-center">
							<th class="text-center">Nome</th>
							<th class="text-center">Email</th>
							<th class="text-center">Ação</th>
						</tr>
					</thead>
					<tbody>
						
						
						<c:forEach items="${lista}" var="item">
							<form method="POST" action="${caminho}/alterar">
								<input name="idUsuario" value="${item.idUsuario}" hidden/>
								<input name="senha" value="${item.senha}" hidden/>
								<tr class="text-center">
									
									<td class="text-center"><input name="nome" value="${item.nome}"/></td>
									<td class="text-center"><input name="email" value="${item.email}"/></td>
									<td class="text-center">
										<button 
										type="button" 
										class="btn btn-warning stretched-link"
										>
											<a href="${caminho}/excluir/${item.idUsuario}">Remover</a>
										</button>
										<button 
										type="submit"
										class="btn btn-warning stretched-link"
										>Alterar</button>
									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
					
					</table>
				
			</div>
		</div>
		
		<div class="card-footer bg-secondary text-center">
			${resposta}
			${error}
		</div>
	</div>
</div>

<body>
</html>
