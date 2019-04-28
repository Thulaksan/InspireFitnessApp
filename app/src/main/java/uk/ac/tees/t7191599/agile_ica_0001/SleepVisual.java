package uk.ac.tees.t7191599.agile_ica_0001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SleepVisual extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_visual);

        AnyChartView BMICHart  = findViewById(R.id.BMIView);
        User u = (User) getIntent().getSerializableExtra("User");

        Cartesian line = AnyChart.area();
        List<DataEntry> DataPionts = new ArrayList<>();

        for (SleepTracler bd : u.getSleep())
        {

            Calendar Cal = Calendar.getInstance();
            Cal.setTimeInMillis(bd.getDate());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String BmiDate = dateFormat.format(date);
            ValueDataEntry x = new ValueDataEntry(BmiDate , bd.getSleepAmount());
            DataPionts.add(x);
        }
        line.data(DataPionts);
        line.normal().stroke("#04b404");
        line.background().stroke("5 black");

        line.labels();
        BMICHart.setChart(line);

    }
}
