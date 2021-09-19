$(document).ready(function() {
    $("#add_new_odontologo").submit(function(evt){
        evt.preventDefault();

        let formData = {
            nombre: $("#profesor_nombre").val(),
            titulo: $("#profesor_titulo").val()
        }

        $.ajax({
            url: '/profesores/reg',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(formData),
            dataType: 'json',
            async: false,
            cache: false,
            success: function (response) {
                let profesor = response
                console.log(response)

                let successAlert = '<div class="alert alert-success alert-dismissible">'
                + '<button type="button" class="close" data-dismiss="alert">&times;</button>'
                + '<strong>profesor agregado </strong></div>'

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
    $("#profesor_nombre").val("");
    $("#profesor_titulo").val("");
}

(function(){
    let pathname = window.location.pathname;
    if(pathname === "/"){
        $(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/profesores.html"){
         $(".nav .nav-item a:last").addClass("active");
    }

})

