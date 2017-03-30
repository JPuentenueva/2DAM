function restarCantidad(id){
	var nodoCantidad = document.getElementById(id);
	var cantidad = parseInt(nodoCantidad.innerHTML);
	var precioUnitario = parseInt(nodoCantidad.getAttribute("precio"));	
	var precioTotal;

	if (id.split("-")[1] == "Camiseta") {
		precioTotal = document.getElementById("precioCamiseta");
	} else {
		precioTotal = document.getElementById("precioPantalon");
	}

	if(cantidad <= 0) {

	} else if (cantidad - 1 > 0) {
		precioTotal.innerHTML = precioUnitario * (cantidad-1);
		nodoCantidad.innerHTML = cantidad-1;
	} else {
		precioTotal.innerHTML = 0;
	}
}

function sumarCantidad(id){
	var nodoCantidad = document.getElementById(id);
	var cantidad = parseInt(nodoCantidad.innerHTML);
	var precioUnitario = parseInt(nodoCantidad.getAttribute("precio"));
	var precioTotal;

	if (id.split("-")[1] == "Camiseta") {
		precioTotal = document.getElementById("precioCamiseta");
	} else {
		precioTotal = document.getElementById("precioPantalon");
	}

	if (cantidad + 1 > 0) {
		precioTotal.innerHTML = precioUnitario * (cantidad+1);
		nodoCantidad.innerHTML = cantidad+1;
	} else {
		precioTotal.innerHTML = 0;
	}
}



window.onload = function() {
	document.getElementById("masCamiseta").onclick = sumarCantidad("cantidad-Camiseta");
	document.getElementById("masPantalon").onclick = sumarCantidad("cantidad-Pantalon");
	document.getElementById("menosCamiseta").onclick = restarCantidad("cantidad-Camiseta");
	document.getElementById("menosPantalon").onclick = restarCantidad("cantidad-Pantalon");
}