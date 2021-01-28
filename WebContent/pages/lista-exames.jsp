<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cidades</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Área Adimin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Exames <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/RetaguardaGrupo4/EspecialidadeServlet">Especialidades</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">
	<div class="row mt-4">
		<h1 class="col-8">Lista de Exames</h1>
		<div class="col-4 text-right">
		<a href="/RetaguardaGrupo4/ExameServlet?acao=novo" class="btn btn-primary ">ADD EXAME</a>
		</div>
	</div>
	<table class="table table-striped">
		<tr>
			<th>ID DO EXAME</th>
			<th>NOME DO EXAME</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${exames}" var="exame">
			<tr>
				<td>${exame.idTipoExame}</td>
				<td>${exame.dsTipoExame}</td>
				<td><a class="btn btn-info"
					href="/RetaguardaGrupo4/ExameServlet?acao=editar&id=${exame.idTipoExame}">EDITAR</a></td>
				<td><a class="btn btn-danger"
					href="/RetaguardaGrupo4/ExameServlet?acao=remover&id=${exame.idTipoExame}">REMOVER</a></td>
			</tr>
		</c:forEach>
	</table>
</div>	
	        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>