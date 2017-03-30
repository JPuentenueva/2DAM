$(document).ready(function() {

	$("#myModal").modal("hide");

	$(document).on("click", ".boton", abrirModalAnyadir());

	$( "ul.droptrue" ).sortable({
      connectWith: "ul"
    });

    $( "ul.dropfalse" ).sortable({
      connectWith: "ul"
    });

    $( "#sortable1, #sortable2, #sortable3, #sortable4, #sortable5, #sortable6").disableSelection();


function abrirModalAnyadir(){
  var id = $(this).closest(".categoria").attr("id");
  $("#myModal").attr("idCategoria", id);
	$("#myModal").modal('show');

}

function anyadirProducto(){

  var nombreProd = $("#modalName").val();
  var cantidadProd = $("#modalQuantity").val();

  var producto = $("<li/>");


  var idCurrentCategoria = $("#myModal").attr("idCategoria");



  currentCategoria.append();

}

function eliminarProducto(){

}

function aumentarCantidadProductos(){

}

function disminuirCantidadProductos(){

}

});
