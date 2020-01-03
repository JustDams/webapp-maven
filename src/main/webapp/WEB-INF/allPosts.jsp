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
<title>Tous les articles</title>
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
				<li class="nav-item active"><a class="nav-link"
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
		<c:if test="${success}">
			<div class="alert alert-success">Votre article a bien été
				supprimé.</div>
		</c:if>
		<div class="row text-center">
			<c:forEach var="allPosts" items="${allPosts}">
				<div class="col-lg-3 col-md-6 mb-4">
					<div class="card h-100">
						<div class="card-body"
							style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
							<h4 class="card-title">Titre: ${allPosts[2]}</h4>
							<p class="card-text">Description: ${allPosts[3]}</p>
						</div>
						<div class="card-footer">
							<h6 class="card-subtitle mb-2 text-muted">
								Publié le: ${allPosts[5]} <u>par ${allPosts[1]}</u>
							</h6>
							<a href="/webappmaven/post?id=${allPosts[0]}"
								class="btn btn-primary">Lire</a><a
								href="/webappmaven/deletePost?post=${allPosts[0]}" class="ml-2"><i
								class="fas fa-trash-alt"></i></a><a
								href="/webappmaven/modifyPost?post=${allPosts[0]}" class="ml-2"><i
								class="fas fa-pencil-alt"></i></a>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${empty allPosts}">
				<h1>Aucun article n'a été publié.</h1>
			</c:if>
		</div>
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