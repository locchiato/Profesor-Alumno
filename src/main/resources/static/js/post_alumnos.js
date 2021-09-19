$(document).ready(function() {
    $("#add_new_odontologo").submit(function(evt){
        evt.preventDefault();

        let formData = {
            nombre: $("#alumno_nombre").val(),
            edad: $("#alumno_edad").val(),
            profesor: $("#alumno_profesor_id").val()
        }

        console.log(

        $.ajax(`/profesores/${formData.profesor}`)
        )


        $.ajax({
            url: '/alumnos/reg',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(formData),
            dataType: 'json',
            async: false,
            cache: false,
            success: function (response) {
                let alumno = response
                console.log(response)

                let successAlert = '<div class="alert alert-success alert-dismissible">'
                + '<button type="button" class="close" data-dismiss="alert">&times;</button>'
                + '<strong>alumno agregado </strong></div>'

                $('#response').append(successAlert);
                $('#response').css({"display": "block"});

                resetUploadForm();
            },

            error: function(response) {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong> Error intente nuevamente</strong> </div>'

                $('#response').append(errorAlert);
                $('#response').css({"display": "block"});
                resetUploadForm();
            }
        });
    })
});
function resetUploadForm(){
    $("#alumno_nombre").val("");
    $("#alumno_edad").val("");
    $("#alumno_profesor_id").val("");
}

(function(){
    let pathname = window.location.pathname;
    if(pathname === "/"){
        $(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/alumnoes.html"){
         $(".nav .nav-item a:last").addClass("active");
    }

})

