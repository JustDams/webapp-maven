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
<title>Formulaire d'inscription</title>
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
				<li class="nav-item"><a class="nav-link"
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
	<c:if test="${connected}">
		<c:redirect url="/"></c:redirect>
	</c:if>
		<form method="post">
			<c:if test="${error}">
				<div class="alert alert-danger">
					<strong>Erreur !</strong> Merci de remplir les champs obligatoires.
				</div>
			</c:if>
			<c:if test="${pass}">
				<div class="alert alert-danger">
					<strong>Erreur !</strong> Merci de saisir les mêmes mot de passe.
				</div>
			</c:if>
			<c:if test="${success == false}">
				<div class="alert alert-danger">
					<strong>Erreur !</strong> Cet username est déjà utilisé.
				</div>
			</c:if>
			<c:if test="${success}">
				<div class="alert alert-success">Votre compte a bien été crée.</div>
			</c:if>
			<div class="form-group">
				<label for="Username">Identifiant</label> <input type="text"
					class="form-control" name="Username" placeholder="Identifiant"
					required>
			</div>
			<div class="form-group">
				<label for="Password">Mot de passe</label> <input type="password"
					class="form-control" name="Password" placeholder="Mot de passe"
					required>
			</div>
			<div class="form-group">
				<label for="PasswordRep">Répéter le mot de passe</label> <input
					type="password" class="form-control" name="PasswordRep"
					placeholder="Répéter le mot de passe" required>
			</div>
			<button type="submit" class="btn btn-primary">S'enregistrer</button>
		</form>
	</div>
</body>
</html>