<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Especialidades</title>
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
        <a class="nav-link" href="/ProjetoRetaguardaGrupo4/ExameServlet">Exames</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/ProjetoRetaguardaGrupo4/EspecialidadeServlet">Especialidades <span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>
<div class="container">
	<div class="row mt-4">
		<h1 class="col-8">Lista de Especialidades</h1>
		<div class="col-4 text-right">
		<a href="/ProjetoRetaguardaGrupo4/EspecialidadeServlet?acao=novo" class="btn btn-primary ">ADD ESPECIALIDADE</a>
		</div>
	</div>

	<table class="table table-striped">
		<tr>
			<th>ID DA ESPECIALIDADE</th>
			<th>NOME DA ESPECIALIDADE</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${especialidades}" var="especialidade">
			<tr>
				<td>${especialidade.idTipoEspecialidade}</td>
				<td>${especialidade.dsTipoEspecialidade}</td>
				<td><a class="btn btn-info"
					href="/ProjetoRetaguardaGrupo4/EspecialidadeServlet?acao=editar&id=${especialidade.idTipoEspecialidade}">EDITAR</a></td>
				<td><a class="btn btn-danger"
					href="/ProjetoRetaguardaGrupo4/EspecialidadeServlet?acao=remover&id=${especialidade.idTipoEspecialidade}">REMOVER</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>