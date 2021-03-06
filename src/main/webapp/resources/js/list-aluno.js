$(document).ready(function(){
	$('#ModEditar').on('show.bs.modal', function(e){
		$('input[name=nome]').val($(e.relatedTarget).data('nome'));
		$('input[name=matricula]').val($(e.relatedTarget).data('matricula'));
		$('input[name=cep]').val($(e.relatedTarget).data('cep'));
		$('input[name=rua]').val($(e.relatedTarget).data('rua'));
		$('input[name=bairro]').val($(e.relatedTarget).data('bairro'));
		$('input[name=complemento]').val($(e.relatedTarget).data('complemento'));
		$('input[name=numero]').val($(e.relatedTarget).data('numero'));
		$('input[name=cidade]').val($(e.relatedTarget).data('cidade'));
		$('input[name=estado]').val($(e.relatedTarget).data('estado'));
		$('input[name=id]').val($(e.relatedTarget).data('id'));
		$('select[name=curso_id] option[value="' + $(e.relatedTarget).data('curso') + '"]').prop('selected', 'true');
		if ($('select option:selected').val() == "") {
            $('select').css('font-weight', 'bold');
        }
        else {
            $('select').css('font-weight', 'normal');
        }
	});
	$('#ModExcluir').on('show.bs.modal', function(e){
		$('input[name=id]').val($(e.relatedTarget).data('id'));
	});
});