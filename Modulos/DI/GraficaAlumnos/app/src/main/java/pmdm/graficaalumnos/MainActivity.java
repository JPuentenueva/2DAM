package pmdm.graficaalumnos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import pmdm.graficaalumnos.pojo.Alumno;

public class MainActivity extends AppCompatActivity {
    HorizontalBarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (HorizontalBarChart) findViewById(R.id.chart);

        List<Alumno> dataObjects = new ArrayList<>();
        dataObjects.add(new Alumno())
        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (Alumno data : dataObjects) {

            // turn your data into Entry objects
            entries.add(new BarEntry(data.getNombre(), data.getValueY()));
            Entry
        }
    }
}
