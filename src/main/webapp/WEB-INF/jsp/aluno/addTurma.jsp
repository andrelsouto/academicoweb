<%@ include file="/WEB-INF/jsp/menu.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<div class="col-md-10 pull-right">
			<div class="text-center">
			<c:if test="${cadastro == 'sucesso'}">
			<div class="alert alert-success" role="alert">
				Cadastro efetuado com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button></div></c:if>
				<h1 class="page-header">Cadastro de aluno em turma</h1>
			</div>
			<div class="form">
			
				<form:form action="${contextPath}aluno/adicionar" method="POST">
					<div class="form-group">
						<select class="form-control" name="aluno">
							<option value="">aluno</option>
							<c:forEach items="${alunos}" var="aluno">
							<option value="${aluno.id}">${aluno.usuario.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="turma">
							<option value="">turma</option>
							<c:forEach items="${turmas}" var="turma">
							<option value="${turma.id}">${turma.ano} | ${turma.disciplina.nome}</option>
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
				Alunos: Andr� Luiz e Robson Luiz | Switch XIV Development &copy;
			</div>
		</div>
<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>