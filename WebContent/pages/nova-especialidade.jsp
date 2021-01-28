<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir novo tipo de Especialidade</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Cadastro de Especialidades</h1>
	
	<form action="/RetaguardaGrupo4/EspecialidadeServlet" method="post">
		<div class="form-group">
			<label for="id-espec">Tipo de Especialidade</label>
			<input type="text" name="nomeEspecialidade" id="id-espec" class="form-control">
	</div>
	
		<input type="hidden" name="id">
		<input type="hidden" name="acao" value="novo">
		
		<div class="text-center mt-4">
			<a class="btn btn-danger" href="/RetaguardaGrupo4/EspecialidadeServlet">CANCELAR</a>
			<input type="submit" value="CADASTRAR" class="btn btn-primary">
		</div>
		
	</form>
</div>	
	 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>