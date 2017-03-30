Template.postItem.helpers({
  domain: function() {
    var a = document.createElement('a');
    a.href = this.url;
    return a.hostname;
  },

  producto: function() {
    return this;
  }
});


window.onload = function() {
  var div = document.findElementById("panel");
  var carritoUser = Session.get("carrito");

    if (producto.enStock) {
      if (carritoUser != null || carritoUser.count() != 0) {
        for each (var currProd in carrito){
          if (currProd.nombreProducto == producto.nombre) { <!--Cómo saco el producto actual-->
            div.className += "panel-success"
          } else {
            div.className += "panel-primary"
          }
        }
      }
    } else {
      div.className += "panel-danger"
    }

}
