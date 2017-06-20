<%@ include file="/WEB-INF/jsp/menu.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-10 pull-right">
	<div class="text-center">
		<h1 class="page-header">Cadastro de disciplina</h1>
	</div>
	<div class="form">
		<form:form method="post"
			action="${pageContext.request.contextPath}/disciplina/cadastrarDisciplina">
			<div class="form-group">
				<input class="form-control" type="text" name="nome"
					placeholder="Disciplina">
			</div>
			<div class="form-group">
				<input type="text" name="area" class="form-control"
					placeholder="Area">
			</div>
				<div class="form-group">
					<select class="form-control" name="curso_id">
						<option value="">Curso</option>
						<c:forEach items="${cursos}" var="curso">
							<option value="${curso.id}">${curso.nome}</option>
						</c:forEach>
					</select>
				</div>
			<div class="text-center">
				<button type="submit" class="btn btn-default text-center">Cadastrar</button>
			</div>
		</form:form>
	</div>
</div>
</div>
<div class="wrapper">
	<div class="footer">Alunos: André Luiz e Robson Luiz | Switch XIV
		Development &copy;</div>
</div>
<script type="text/javascript"
	src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>