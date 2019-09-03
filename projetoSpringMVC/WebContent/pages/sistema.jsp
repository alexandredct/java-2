<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>

<script type="text/javascript"src="https://code.jquery.com/jquery-3.4.1.min.js"></script>  
<script type="text/javascript"src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


<script>
$(document).ready(function(){
	$("#accordion").accordion();
	
	$("#cep").on('blur', function (){
		var vcep = $(this).val();
		
		$.getJSON(
				"http://api.postmon.com.br/v1/cep/" + vcep, 
				function (data) {
					$("#logradouro").val(data.logradouro);
					$("#bairro").val(data.bairro);
				})
				.fail ( function (ex) {
					$("#resposta").html("CEP não encontrado");
				});
	});

});
</script>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value ="${pageContext.request.contextPath }"/>


<div id="resposta"></div>

<div id="accordion">
<h3>Cadastro de Cliente</h3>
<div>
	<form method="POST" action="${contextPath}/cadastrar.html">
	<br/>Nome<br/>
	<input type="text" id="nome" name="nome" value="" required="required"/>
	
	<br/>Email<br/>
	<input type="email" id="email" name="email" value="" required="required"/>
	
	<br/>CEP<br/>
	<input type="text" id="cep" name="cep" value="" required="required"/>
	
	<br/>Logradouro<br/>
	<input type="text" id="logradouro" name="logradouro" value="" required="required"/>
	
	<br/>Bairro<br/>
	<input type="text" id="bairro" name="bairro" value="" required="required"/>
	
	<button type="submit">Submit</button>
	
	<br>
	${msg}
	
	</form>



 <table>
	<thead>
		<tr>
			<td>Id</td><td>Nome</td><td>Email</td>
			<td>Cep</td><td>Logradouro</td><td>Bairro</td>
			<td>#</td><td>#</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${lista}" var="item">
			<form method="post" action="${contextPath}/alterar.html">
				<tr>
					<td><input type="number"name="id" value="${item.id}" size="5"/></td> 
					<td><input type="text" name="nome" value="${item.nome}" size="7"/></td>
					<td><input type="email" name="email" value="${item.email}" size="10"/></td>
					<td><input type="text" name="cep" value="${item.cep}" size="10"/></td>
					<td><input type="text" name="logradouro" value="${item.logradouro}" size="10"/></td> 
					<td><input type="text" name="bairro" value="${item.bairro}" size="10"/></td>
					<td><button type="submit">Alterar</button></td>
					<td>
					<a href="${contextPath}/excluir.html/${item.id}">			
						<button type="button">Excluir</button>
					</a>
					</td>
			 	</tr>
		 	</form> 
	     </c:forEach>
	  </tbody>	  
	 </table>
	 
	</div>
</div>

</body>
</html>