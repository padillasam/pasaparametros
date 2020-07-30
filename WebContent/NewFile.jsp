<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background:grey;
}
form {
	padding:10px;
	width: 400px;
	height: 400px;
	text-align: center;
	border: 1px solid grey;
	margin:auto;
	border-radius:5px;
	background:white;
}
</style>
</head>
<body>
	<%
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<form action="Controlador" method="GET">
		<input type="text" name="nombre" value="Nombre"><br> <br>
		<input type="text" name="email" value="email"><br> <br>
		<input type="text" name="fecha" value="<%=fecha.format(new Date())%>"><br>
		<br> <input type="submit" value="Enviar Consulta">
		<a href="mostrar">Pulsa aqui e iras a los resultados</a>
	</form>
	
</body>
</html>