<%@ include file="/WEB-INF/jsp/menu.jsp" %>
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
				<h1 class="page-header">Cadastro de turma</h1>
			</div>
			<div class="form">
				<form:form action="${contextPath}turma/cadastrar" method="POST">
					<div class="form-group">
						<select id="" class="form-control" name="professor">
							<option value="">professor</option>
							<c:forEach items="${professores}" var="professor">
								<option value="${professor.id}">${professor.usuario.nome}</option>
							</c:forEach>
						</select>
						</div>
						<div class="extra">
						
						</div>
					<div class="add professor">
						<a href="#">Adicionar novo professor...</a>
					</div>
					<div class="rm professor" style="display: none;">
						<a href="#">Remover novo professor...</a>
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="matricula" placeholder="matricula">
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
<script type="text/javascript">
$(document).ready(function(){
	var x = 0;
	var y = 0;
	$('.add').click(function(){
		x++;
		$('.extra').append("<div class='"+ x + "'><div class='form-group'><select class='form-control' name='professor'>" +
							"<option value=''>professor</option>" +
							"<c:forEach items='${professores}' var='professor'>" +
							"<option value='${professor.id}'>${professor.usuario.nome}</option>" +
							"</c:forEach>" +
						"</select></div></div>");
	if (x > 0){
		y = 1;
		if (y == 1 && x == 1){
			$('.rm').css("display", "inline");
			$('.rm a').css("color", "#2E9B6D");
			$('.rm').css("float", "right");
			$('.add').css("float", "left");
		}
	}
	else {
		y = 0;
	}
	});
	$('.rm').click(function(e){
		$("." + x).remove();
		x--;
		if (x == 0) {
			$('.rm').css("display", "none");
			y=0;
		}

		console.log(x + ";" + y);
	});
	
});
</script>