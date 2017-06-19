<%@ include file="/WEB-INF/jsp/menu.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

		<div class="col-md-10">
			<div class="text-center">
				<h1 class="page-header">Cadastro de curso</h1>
			</div>
			<div class="form">
				<form method="post" action="#">
					<div class="form-group">
						<input class="form-control" type="text" name="nome" placeholder="curso">
					</div>
					<div class="form-group">
						<input type="text" name="tipo" class="form-control" placeholder="tipo">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default text-center">Cadastrar</button>
					</div>		
				</form>
			</div>
		</div>
		<footer class="footer">
			Alunos: André Luiz e Robson Luiz | Switch XIV Development &copy;
		</footer>
	</div>
<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>