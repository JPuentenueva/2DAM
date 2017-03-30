package di.putaditagridviewrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import di.putaditagridviewrecyclerview.interfaces.IOnClickEmail;
import di.putaditagridviewrecyclerview.interfaces.IOnClickOpcionMenu;
import di.putaditagridviewrecyclerview.pojo.EmailItem;
import di.putaditagridviewrecyclerview.pojo.OpcionMenu;

public class MainActivity extends AppCompatActivity implements IOnClickEmail, IOnClickOpcionMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClickEmail(EmailItem e) {

    }

    @Override
    public void onClickOpcionMenu(OpcionMenu opcionMenu) {

    }
}
