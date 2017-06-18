$(document).ready(function() {
    $('select').change(function() {
        if ($('select option:selected').val() == "") {
            $('select').css('font-weight', 'bold');
        } 
        else {
            $('select').css('font-weight', 'normal');
        }
    });
});
