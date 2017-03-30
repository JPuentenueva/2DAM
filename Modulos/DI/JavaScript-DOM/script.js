
function addnuevousuario(){
	var tabla = document.getElementById("tbodyusuarios");

	var filanueva = document.createElement("tr");

	var numero = document.createElement("td");
	numero.appendChild(document.createTextNode("0"));

	var nombre = document.createElement("td");
	nombre.appendChild(document.createTextNode("Default"));

	var apellido = document.createElement("td");
	apellido.appendChild(document.createTextNode("User"));	

	var botonEditar = document.createElement("button");
		botonEditar.setAttribute("class","btn btn-default");
		botonEditar.setAttribute("type", "submit");
		botonEditar.appendChild(document.createTextNode("Editar"));
	var botonEliminar = document.createElement("button");
		botonEliminar.setAttribute("class","btn btn-default");
		botonEliminar.setAttribute("type", "submit");
		botonEliminar.appendChild(document.createTextNode("Eliminar"));

	var botones = document.createElement("td");
	botones.appendChild(botonEditar);
	botones.appendChild(botonEliminar);

	filanueva.appendChild(numero);
	filanueva.appendChild(nombre);
	filanueva.appendChild(apellido);
	filanueva.appendChild(botones);

	tabla.appendChild(filanueva);

}