<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Curso Java Web - Cadastrar Contato</title>
</head>
<body>
	<div align="center">
		<form id="form" action="${pageContext.request.contextPath}/CadastrarContatoController" method="post">
			<label>Nome:</label>
			<input name="nome"> <br>
			
			<label>Sobrenome:</label>
			<input name="sobrenome"> <br>
			
			<label>Telefone:</label>
			<input name="telefone"> <br>
			
			<label>E-mail:</label>
			<input name="email"> <br>			
			
			<input type="submit" value="Enviar" id="button" />
		</form>
	</div>
	
	<br/><br/><br/>
	
	<div align="center">
		<a href="${pageContext.request.contextPath}/ListarContatoController">Listar</a>
		
		<a href="${pageContext.request.contextPath}/pages/index.jsp">Página Inicial</a>
	</div>
		
</body>
</html>