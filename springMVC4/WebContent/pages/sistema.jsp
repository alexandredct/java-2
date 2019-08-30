<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.8/css/mdb.min.css" rel="stylesheet">

</head>
<body>
<h2 class="p-3 bg-info text-center">Projeto Desenhos</h2>
<%@ page import="entity.*, persistence.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<div class="col-md-6 offset-md-3">
		<div class="card border-info shadow">
			<div class="card-body">
				<div class="card-title">
					<h4 class="text-center">Formulário</h4>
				</div>
				
				<form method="post" action="cadastrar.html">
					<label for="nomeFilme">Nome do Filme:</label>
					<input type="text"  name="nomeFilme"  id="nomeFilme"
					placeholder="Digite o nome do filme" class="form-control">
				
					<label for="preco">Preço:</label>
					<input type="number"  name="preco"  id="preco"
					placeholder="Digite o preço do filme" class="form-control">
				
					<label for="categoria">Categoria:</label>
					<input type="text"  name="categoria"  id="categoria"
					placeholder="Digite a categoria do filme" class="form-control">
					
					<label for="imagem">Imagem:</label>
					<input type="text"  name="imagem"  id="imagem"
					placeholder="Digite a URL da imagem" class="form-control">
				
					<label for="trailer">Trailler:</label>
					<input type="text"  name="trailer"  id="trailer"
					placeholder="Digite a URL do Video" class="form-control">

					<button type="submit" class="btn btn-info">Gravar</button>
				</form>
				
<%-- 			<c:forEach items="${filmes}" var="item"> --%>
<!-- 			  <li> -->
<%-- 			      ${item} --%>
<!-- 			  </li> -->
<%-- 			</c:forEach>	 --%>
			</div>
			<div class="card-footer">
				${msg}
			</div>
		</div>
	</div>
	
	
	
	<div class="col-md-10 offset-md-1 mt-3">
		<table class="table table-hover table-striped table-bordered shadow">
			<thead class="bg-info">
				<tr>
					<th>Nome do Filme</th>
					<th>Preço</th>
					<th>Categoria</th>
					<th>Imagem</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${filmes}" var="item">
					<tr>
						<td>${item.nomeFilme}</td>
						<td>${item.preco}</td>
						<td>${item.categoria}</td>
						<td><img src="${item.imagem}" style="width:150px;"></td>
					</tr>
					</c:forEach>
			</tbody>
			
		</table>
	</div>
	



	
</div>



<hr/>
<h2>BUscar pelo código</h2>
<form method="post" action="consultarcodigo.html">
	<select name="idFilme">
		<option>Escolha o codigo..</option>
		<c:forEach items="${filmes }" var="item">
			<option value="${item.idFilme }">${item.nomeFilme }</option>
		</c:forEach>
	</select>
</form>



</body>
</html>