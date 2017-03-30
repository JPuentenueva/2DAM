package di.footballplayerslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView liVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FootballPlayer> li = new ArrayList<>();
        li.add(new FootballPlayer("Oliver Atom", "New Team", 22, (float) 4.7, 11, 56));
        li.add(new FootballPlayer("Mark Lenders", "Meiwa F.C", 36, (float) 4.4, 8, 43));
        li.add(new FootballPlayer("Benji Price", "New Team", 24, (float) 3.8, 10, 1));
        li.add(new FootballPlayer("Tom Becker", "New Team", 22, (float) 2.5, 3, 21));

        liVi = (ListView) findViewById(R.id.players_list);
        FootballPlayerAdapter fpa = new FootballPlayerAdapter(this, R.layout.item_jugador, li);
        liVi.setAdapter(fpa);
    }
}
