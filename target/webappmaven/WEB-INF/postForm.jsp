<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Ajouter un article</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark position-fixed"
		style="width: -moz-available; width: -webkit-fill-available; z-index: 100; width: 100%;">
		<a class="navbar-brand" href="/webappmaven">Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample04" aria-controls="navbarsExample04"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample04">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/webappmaven">Accueil</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/webappmaven/allPosts">Tous les articles</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/webappmaven/allWriters">Tous les auteurs</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/webappmaven/addPost">Ajouter un article</a></li>
				<c:if test="${empty connected}">
					<li class="nav-item"><a class="nav-link"
						href="/webappmaven/login">Connexion</a></li>

					<li class="nav-item"><a class="nav-link"
						href="/webappmaven/register">Inscription</a></li>
				</c:if>
				<c:if test="${connected}">
					<li class="nav-item"><a class="nav-link"
						href="/webappmaven/disconnect">Déconnection</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	<div class="container" style="padding-top: 66px;">
		<form method="post">
			<c:if test="${error}">
				<div class="alert alert-danger">
					<strong>Erreur !</strong> Merci de remplir les champs obligatoires.
				</div>
			</c:if>
			<c:if test="${titlelen}">
					<div class="alert alert-danger">
						<strong>Erreur !</strong> Le titre ne peut pas dépasser
						40 caractères.
					</div>
				</c:if>
				<c:if test="${authorlen}">
					<div class="alert alert-danger">
						<strong>Erreur !</strong> Le nom de l'auteur ne peut pas dépasser
						30 caractères.
					</div>
				</c:if>
			<c:if test="${success}">
				<div class="alert alert-success">Votre article a bien été
					crée.</div>
			</c:if>
			<c:if test="${empty connected}">
				<div class="form-group">
					<label for="Auteur">Auteur</label> <input type="text"
						class="form-control" name="Auteur" placeholder="Auteur" required>
				</div>
			</c:if>
			<div class="form-group">
				<label for="Titre">Titre</label> <input type="text"
					class="form-control" name="Titre" placeholder="Titre" required>
			</div>
			<div class="form-group">
				<label for="Description">Description</label> <input type="text"
					class="form-control" name="Description" value=""
					placeholder="Description" required>
			</div>
			<div class="form-group">
				<label for="Texte">Texte</label>
				<textarea class="form-control" name="Texte"
					aria-label="With textarea" placeholder="Texte" required></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Envoyer</button>
		</form>
	</div>
</body>
<script src="https://kit.fontawesome.com/016ccc365f.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</html>