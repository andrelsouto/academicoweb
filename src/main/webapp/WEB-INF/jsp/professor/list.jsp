<%@ include file="/WEB-INF/jsp/menu.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="col-md-10 pull-right">
			<div class="text-center">
				<c:if test="${cadastro == 'sucesso'}">
			<div class="alert alert-success" role="alert">
				Dados atualizado com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button></div></c:if>
				<c:if test="${exclusao == 'sucesso'}">
			<div class="alert alert-success" role="alert">
				Dados exlcuídos com sucesso.
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">&times;</span>
</button></div></c:if>
				<h1 class="page-header">Listagem de professores</h1>
			</div>
			<div class="listagem">
				<table class="table table-condensed">
					<thead class="head">
						<tr>
							<th>ID</th>
							<th>Matricula</th>
							<th>Nome</th>
							<th>Titulação</th>
							<th>Editar</th>
							<th>Excluir</th>
							</tr>
					</thead>
							<tbody>
								<c:forEach items="${professores}" var="professor">
								<tr>
									<td>${professor.id}</td>
									<td class="mat">${professor.usuario.matricula}</td>
									<td>${professor.usuario.nome}</td>
									<td>${professor.titulacao}</td>
									<td><a href="#" data-toggle="modal" data-nome="${professor.usuario.nome}" data-matricula="${professor.usuario.matricula}"
									 	data-id="${professor.id}" data-rua="${professor.usuario.endereco.rua}" data-cep="${professor.usuario.endereco.cep}"
									 		data-complemento="${professor.usuario.endereco.complemento}" data-numero="${professor.usuario.endereco.numero}"
									 		 data-cidade="${professor.usuario.endereco.cidade}" data-estado="${professor.usuario.endereco.estado}"
									 		  data-bairro="${professor.usuario.endereco.bairro}" 
									 		   data-area="${professor.areaAtuacao}" data-titulacao="${professor.titulacao}" data-target="#ModEditar"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="#" data-toggle="modal" data-id="${professor.id}" data-target="#ModExcluir"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
								</c:forEach>
							</tbody>
							</table>
				</div>
			</div>
			<!-- Modal Editar -->
			<div class="modal fade" id="ModEditar" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">Editar professor</h4>
						</div>
						<div class="modal-body">
							<div class="form-edit">
								<div class="form">
									<form:form method="post" action="${contextPath}professor/editar">
									<input type="hidden" name="id">
										<div class="form-group">
						<input class="form-control" type="text" name="matricula" placeholder="matricula">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="nome" placeholder="nome">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="areaAtuacao" placeholder="área de atuação">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="titulacao" placeholder="titulação">
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
											<button type="submit" class="btn btn-default">Editar</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim modal editar -->

			<!--Modal exluir-->
			<div class="modal fade" id="ModExcluir" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">Excluir aluno</h4>
						</div>
						<div class="modal-body text-center">
							<h5><strong>Você realmente deseja exluir este aluno?</strong></h5>
							<form:form action="${contextPath}aluno/excluir" method="POST">
								<input type="hidden" name="id">
								<button type="submit" class="btn btn-default">Sim</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<!--Fim do modal exluir-->
		</div>
		<div class="wrapper"> 
			<div class="footer">
				Alunos: André Luiz e Robson Luiz | Switch XIV Development &copy;
			</div>
		</div>
		<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${contextPath}resources/js/list-professor.js"></script>
</body>

</html>