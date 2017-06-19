<%@ include file="/WEB-INF/jsp/menu.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div class="col-md-10">
			<div class="text-center">
				<h1 class="page-header">Listagem de disciplinas</h1>
			</div>
			<div class="listagem">
				<table class="table table-condensed">
					<thead class="head">
						<tr>
							<th>ID</th>
							<th>Disciplina</th>
							<th>Area</th>
							<th>Curso</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
							<c:forEach items="${disciplinas}" var="disciplina">
								<tr>
									<td>${disciplina.id}</td>
									<td>${disciplina.nome}</td>
									<td>${disciplina.area}</td>
									<td>${disciplina.curso.nome }</td>
									<td><a href="#" data-toggle="modal" data-target="#ModEditar" data-codigo="${disciplina.id}" data-curso="${disciplina.curso.nome}" data-nome="${disciplina.nome}" data-area="${disciplina.area}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="#" data-toggle="modal" data-target="#ModExcluir" data-codigoo="${disciplina.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
							</c:forEach>
					</table>
				</div>
			</div>
			<!-- Modal Editar -->
			<div class="modal fade" id="ModEditar" tabindex="-1" role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header text-center">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title">Editar disciplina</h4>
						</div>
						<div class="modal-body">
							<div class="form-edit">
								<div class="form">
									<form method="post" action="${pageContext.request.contextPath}/disciplina/editarDisciplina">
									<input id="id_curso" type="hidden" name="id">
										<div class="form-group">
											<input id="inputnome" class="form-control" type="text" name="nome" placeholder="Disciplina">
										</div>
										<div class="form-group">
											<input id="inputarea" type="text" name="area" class="form-control" placeholder="Area">
										</div>
										<div class="form-group">
											<input id="inputcurso" type="text" name="curso" class="form-control" placeholder="Curso">
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
							<h4 class="modal-title">Excluir disciplina</h4>
						</div>
						<div class="modal-body text-center">
							<h5><strong>Você realmente deseja exluir esta disciplina?</strong></h5>
							<form action="${pageContext.request.contextPath}/disciplina/removerDisciplina" method="POST">
								<input type="hidden" id="cod" name="id">
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
<script type="text/javascript" src="${contextPath}resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	$("#ModEditar").on('show.bs.modal',function(event){
		$("#inputnome").val($(event.relatedTarget).data("nome"));
		$("#id_disciplina").val($(event.relatedTarget).data("codigo"));	
		$("#inputarea").val($(event.relatedTarget).data("area"));
		$("#inputcurso").val($(event.relatedTarget).data("curso"));	
	});

	$("#ModExcluir").on('show.bs.modal',function(event){ 		// MODAL EXCLUIR
		$("#cod").val($(event.relatedTarget).data("codigoo"));
	});
	
	});

</script>

</body>

</html>