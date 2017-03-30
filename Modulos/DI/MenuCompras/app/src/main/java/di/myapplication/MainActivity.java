package di.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import di.myapplication.fragments.ProductosFragment;
import di.myapplication.interfaces.IProductoListener;
import di.myapplication.pojo.Compra;
import di.myapplication.pojo.Producto;

public class MainActivity extends AppCompatActivity implements IProductoListener {
    MenuItem itemCancel;
    MenuItem itemCart;
    MenuItem itemPrecio;
    Fragment fragmentCatalogo;
    Compra compra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        compra = new Compra();
        fragmentCatalogo = new ProductosFragment();

        //No hace nada, asi que lo he puesto "invisible" en el xml
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        itemCancel = menu.findItem(R.id.action_cancel);
        itemPrecio = menu.findItem(R.id.action_price);
        itemCart = menu.findItem(R.id.action_products);

        itemCancel.setVisible(false);
        itemPrecio.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cancel) {

        }else if (id == R.id.action_price){

        }else if (id == R.id.action_products){

        }else{

        }

        return true;

    }

    @Override
    public void onClickProducto(Producto producto) {
        List<Producto> lista = compra.getProductosAComprar();

        lista.add(producto);
        compra.setProductosAComprar(lista);
        comprobarCatalogo();
    }

    private void comprobarCatalogo() {
        if(compra.getProductosAComprar().isEmpty()){
            itemCancel.setVisible(false);
            itemCart.setIcon(R.drawable.ic_empty_shopping_cart);
            itemPrecio.setVisible(false);
        } else {
            itemCancel.setVisible(true);
            switch (compra.getProductosAComprar().size()){
                case 0:
                    itemCart.setIcon(R.drawable.ic_empty_shopping_cart);
                    break;
                case 1:
                    itemCart.setIcon(R.drawable.cart_1);
                    break;
                case 2:
                    itemCart.setIcon(R.drawable.cart_2);
                    break;
                case 3:
                    itemCart.setIcon(R.drawable.cart_3);
                    break;
                case 4:
                    itemCart.setIcon(R.drawable.cart_4);
                    break;
                case 5:
                    itemCart.setIcon(R.drawable.cart_5);
                    break;
                case 6:
                    itemCart.setIcon(R.drawable.cart_6);
                    break;
                case 7:
                    itemCart.setIcon(R.drawable.cart_7);
                    break;
                case 8:
                    itemCart.setIcon(R.drawable.cart_8);
                    break;
                case 9:
                    itemCart.setIcon(R.drawable.cart_9);
                    break;
                default:
                    itemCart.setIcon(R.drawable.cart_plus9);
                    break;
            }
            itemCart.setVisible(true);
            itemPrecio.setVisible(true);
        }
    }
}
