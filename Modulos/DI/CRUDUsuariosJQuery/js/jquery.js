$(document).ready(function() {
	$(document).on("click",".btnEditarUsuario", function(){
		var id = $(this).attr("idu");
		var nombreUser = $("#nombre-"+id).text();
		var emailUser = $("#email-"+id).text();
		var phoneUser = $("#telefono-"+id).text();

		$("#modalName").val(nombreUser);
		$("#modalMail").val(emailUser);
		$("#modalPhone").val(phoneUser);

		$("#myModal").attr("idusuario", id);
		$("#myModal").modal("show");
	});

	$(document).on("click",".btnEliminarUsuario", function(){
		var id = $(this).attr("idu");
		$("#user-"+id).remove();
	});

	$(document).on("click","#btnGuardarCambios", function(){
		var id = $("#myModal").attr("idusuario");

		var nombreUser = $("#modalName").val();
		var emailUser = $("#modalMail").val();
		var phoneUser = $("#modalPhone").val();

		$("#nombre-"+id).text(nombreUser);
		$("#email-"+id).text(emailUser);
		$("#telefono-"+id).text(phoneUser);

		$("#myModal").modal("hide");
	})
});



