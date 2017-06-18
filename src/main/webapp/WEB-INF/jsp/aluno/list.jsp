<%@ include file="/WEB-INF/jsp/menu.jsp" %>

<div class="col-md-10">
			<div class="text-center">
				<h1 class="page-header">Listagem de alunos</h1>
			</div>
			<div class="listagem">
				<table class="table table-condensed">
					<thead class="head">
						<tr>
							<th>ID</th>
							<th>Matricula</th>
							<th>Nome</th>
							<th>Curso</th>
							<th>Editar</th>
							<th>Excluir</th>
							</tr>
					</thead>
							<tbody>
								<c:forEach items="${alunos}" var="aluno">
								<tr>
									<td>${aluno.id}</td>
									<td>${aluno.usuario.matricula}</td>
									<td>${aluno.usuario.nome}</td>
									<td>${aluno.curso.nome}</td>
									<td><a href="#" data-toggle="modal" data-target="#ModEditar"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="#" data-toggle="modal" data-target="#ModExcluir"><span class="glyphicon glyphicon-trash"></span></a></td>
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
							<h4 class="modal-title">Editar curso</h4>
						</div>
						<div class="modal-body">
							<div class="form-edit">
								<div class="form">
									<form method="post" action="#">
										<div class="form-group">
											<input class="form-control" type="text" name="nome" placeholder="curso">
										</div>
										<div class="form-group">
											<input type="text" name="tipo" class="form-control" placeholder="tipo">
										</div>
										<div class="text-center">
											<button type="submit" class="btn btn-default">Editar</button>
										</div>
									</form>
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
							<h4 class="modal-title">Excluir curso</h4>
						</div>
						<div class="modal-body text-center">
							<h5><strong>Você realmente deseja exluir este curso?</strong></h5>
							<form action="" method="POST">
								<input type="hidden">
								<button type="submit" class="btn btn-default">Sim</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!--Fim do modal exluir-->

			<footer class="footer">
				Alunos: André Luiz e Robson Luiz | Switch XIV Development &copy;
			</footer>
		</div>
		<script type="text/javascript" src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>

</html>