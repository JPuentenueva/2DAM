package di.myapplication.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmpuentenueva on 02/12/2016.
 */
public class Compra {
    List<Producto> productosAComprar;
    List<Producto> enStock;

    public Compra() {
        productosAComprar = new ArrayList<>();
        enStock = new ArrayList<>();
        enStock.add(new Producto("Ordenador to pepino",804.70));
        enStock.add(new Producto("Salchipapa",1.75));
        enStock.add(new Producto("Petardos \"Layihad\"",5.00));
        enStock.add(new Producto("Bonsai XXL",15.30));
        enStock.add(new Producto("Batamanta",21.21));
        enStock.add(new Producto("Santo grial",0.99));
        enStock.add(new Producto("Semilla senzu",7.90));
        enStock.add(new Producto("Libro \"50 sombras de Jay\"",4.50));
        enStock.add(new Producto("Videojuego \"Final Fantasy LXIX\"",67.23));
    }

    public Compra(List<Producto> productosAComprar) {
        this.productosAComprar = productosAComprar;
        enStock = new ArrayList<>();
        enStock.add(new Producto("Ordenador to pepino",804.70));
        enStock.add(new Producto("Salchipapa",1.75));
        enStock.add(new Producto("Petardos \"Layihad\"",5.00));
        enStock.add(new Producto("Bonsai XXL",15.30));
        enStock.add(new Producto("Batamanta",21.21));
        enStock.add(new Producto("Santo grial",0.99));
        enStock.add(new Producto("Semilla senzu",7.90));
        enStock.add(new Producto("Libro \"50 sombras de Jay\"",4.50));
        enStock.add(new Producto("Videojuego \"Final Fantasy LXIX\"",67.23));
    }

    public List<Producto> getProductosAComprar() {
        return productosAComprar;
    }

    public void setProductosAComprar(List<Producto> productosAComprar) {
        this.productosAComprar = productosAComprar;
    }

    public double calcularPrecioTotal(){
        double precioTotal = 0;

        for(Producto p : this.productosAComprar){
            precioTotal += p.getPrecio();
        }

        return precioTotal;
    }

    public int obtenerNumeroProductos(){
        return this.productosAComprar.size();
    }
}
