<%@ include file="/WEB-INF/jsp/menu.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<div class="col-md-10 pull-right">
			<div class="text-center">
			<c:if test="${cadastro == 'sucesso'}">
			<div class="alert alert-success" role="alert">
				Curso adicionado com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button></div></c:if>
				<h1 class="page-header">Adicionar curso ao profossor</h1>
			</div>
			<div class="form">
			
				<form:form action="${contextPath}professor/adicionar" method="POST">
					<div class="form-group">
						<select class="form-control" name="professor">
							<option value="">professor</option>
							<c:forEach items="${professores}" var="professor">
								<option value="${professor.id}">${professor.usuario.nome }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="curso">
							<option value="">curso</option>
							<c:forEach items="${cursos}" var="curso">
								<option value="${curso.id}">${curso.nome }</option>
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
			<div class="footer">
				Alunos: André Luiz e Robson Luiz | Switch XIV Development &copy;
			</div>
		</div>
<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>