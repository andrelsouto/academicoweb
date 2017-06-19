<%@ include file="/WEB-INF/jsp/menu.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<div class="col-md-10">
			<div class="text-center">
			<c:if test="${cadastro == 'sucesso'}">
			<div class="alert alert-success" role="alert">
				Cadastro efetuado com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button></div></c:if>
				<h1 class="page-header">Cadastro de aluno</h1>
			</div>
			<div class="form">
			
				<form:form action="${contextPath}aluno/cadastrar" method="POST">
					<div class="form-group">
						<input class="form-control" type="text" name="matricula" placeholder="matricula">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="nome" placeholder="nome">
					</div>
					<div class="form-group">
						<select class="form-control" name="curso">
							<option value="">curso</option>
						</select>
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cep" placeholder="cep">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="bairro" placeholder="bairro">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="rua" placeholder="rua">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="numero" placeholder="numero">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="complemento" placeholder="complemento">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cidade" placeholder="cidade">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="estado" placeholder="estado">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default text-center">Cadastrar</button>
					</div>		
				</form:form>
			</div>
		</div>
		 <footer class="footer">
			Alunos: André Luiz e Robson Luiz | Switch XIV Development &copy;
		</footer>
	</div>
<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>