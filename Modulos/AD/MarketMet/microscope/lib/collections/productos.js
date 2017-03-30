Productos = new Mongo.Collection('productos');

if (Productos.find().count() === 0) {
  Productos.insert({
    nombre: "Muñeco cabezón Sheldon",
    precio: "4.40",
    imagenURL: "http://regalopedia.es/wp-content/uploads/2012/11/sheldon.jpg",
    descripcion: "Esta gracioso darle un porracito y verlo bailar",
    usuario: "Cliente2",
    enStock: true
  });

  Productos.insert({
    nombre: "Katana",
    precio: "25",
    imagenURL: "http://casiberia.com/img/prod/2x/sc4002.jpg",
    descripcion: "Cuidado, esta afilada",
    usuario: "Cliente2",
    enStock: true
  });

  Productos.insert({
    nombre: "NES",
    precio: "12.50",
    imagenURL: "http://regalopedia.es/wp-content/uploads/2012/11/sheldon.jpg",
    descripcion: "Tiene poco uso, estado casi perfecto",
    usuario: "Cliente1",
    enStock: true
  });
}
