<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
	<c:url value="/" var="contextPath"/>
	<title></title>
	<link rel="stylesheet" type="text/css" href="${contextPath}resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${contextPath}resources/css/menuPrincipal.css">
	<script type="text/javascript" src="${contextPath}resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${contextPath}resources/js/menu-css-jquery.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="menu col-md-2">
			<div class="text-left">
				Bem vindo, Usuários!
			</div>
			<div class="text-right">
				<a href="#">Sair</a>
			</div>
			<div class="img-user text-center">
				<img src="${contextPath}resources/img/user.png" class="img-circle text-center">
			</div>
			<div class="text-center">
				<p class="page-header">MENU</p>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Cadastrar
					<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">Aluno</a></li>
						<li><a href="#">Curso</a></li>
						<li><a href="#">Disciplina</li>
						<li><a href="#">Professor</a></li>
						<li><a href="#">Turma</a></li>
					</ul>
				</div>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Listar
					<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">Aluno</a></li>
						<li><a href="listagem.html">Curso</a></li>
						<li><a href="#">Disciplina</li>
						<li><a href="#">Professor</a></li>
						<li><a href="#">Turma</a></li>
					</ul>
				</div>
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Matricular
					<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">Aluno</a></li>
						<li><a href="#">Professor</li>
					</ul>
				</div>
			</div>
		</div>