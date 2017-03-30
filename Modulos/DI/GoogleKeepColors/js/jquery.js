var actualId;

$(document).ready(function() {

	$(document).on("click","#btnCrearNota", function(){
		var texto = $("#textoNota").val();
		var idCurrent = $("#listaNotas").children().length - 1;
		var colorNota = $("#colorFondoInput").val();
		var colorLetra = $("#colorLetraInput").val();

		if (texto == null || texto == "") {
			alert("Inserta un texto para la nota!");
		} else {
			$("#listaNotas").append('<div class="col-lg-4 col-sm-6 text-center" style="min-width: 300px; width: 25%; margin-bottom: 20px; overflow: hidden;" id="cajaNota-'+idCurrent+'">'+
			'<div id="nota-'+idCurrent+'" style="background-color: '+colorNota+'; border: solid 0px; border-radius: 5px 30px 30px 30px; margin: 5px; padding: 15px">'+
			'<span id="textoNota-'+idCurrent+'" style="color: '+colorLetra+'; font-size: 20px">'+texto+'</span>'+
			'<br><br>'+
			'<input class="btnEditarNota" type="image" src="imgs/edit.png" width="20px" height="20px" /> &nbsp &nbsp'+
			'<input class="btnEliminarNota" type="image" src="imgs/delete.png" width="20px" height="20px" />'+
			'</div></div>');
		}
	});

	$(document).on("click",".btnEditarNota", function(){
		var cajaId = $(this).closest("div").attr("id");
		var id = cajaId.split("-")[1];

		actualId = id;

		var textoNota = $("#textoNota-"+id).text();

		$("#notaEditable").val(textoNota);

		$("#myModal").attr("idusuario", id);
		$("#myModal").modal("show");
	});

	$(document).on("click",".btnEliminarNota", function(){
		var cajaId = $(this).closest("div").attr("id");
		var id = cajaId.split("-")[1];
		$("#cajaNota-"+id).remove();
	});

	$(document).on("click","#btnGuardarCambios", function(){
		var texto = $("#notaEditable").val();

		$("#textoNota-"+actualId).text(texto);

		$("#myModal").modal("hide");
	})
});
