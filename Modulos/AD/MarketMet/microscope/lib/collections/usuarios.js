Usuarios = new Mongo.Collection('usuarios');

if (Usuarios.find().count() === 0) {
  Usuarios.insert({
    nombre: "visitante",
    logueado: false
  });

  Usuarios.insert({
    nombre: "Cliente1",
    consenya: "1111",
    carrito: [
      {nombreProducto: "Katana"},
      {nombreProducto: "NES"}
    ],
    logueado: true
  });

  Usuarios.insert({
    nombre: "Cliente2",
    consenya: "2222",
    carrito: [

    ],
    logueado: true
  });
}
