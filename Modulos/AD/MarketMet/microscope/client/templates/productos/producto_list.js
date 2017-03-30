Template.productosList.helpers({
  productos: function() {
    return Posts.find();
  }
});
