package com.santosoftvw.frmattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AvgAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avg_attendance);

        BarChart attChart = (BarChart) findViewById(R.id.attChart);
        ArrayList<BarEntry> attRec = new ArrayList<BarEntry>();
        attRec.add(new BarEntry(1f,56.7f));
        attRec.add(new BarEntry(2f,54.2f));
        attRec.add(new BarEntry(3f,63.0f));
        attRec.add(new BarEntry(4f,64.5f));
        attRec.add(new BarEntry(5f,60.9f));
        attRec.add(new BarEntry(6f,44.3f));
        attRec.add(new BarEntry(7f,40.1f));
        attRec.add(new BarEntry(8f,12.0f));
        attRec.add(new BarEntry(9f,14.8f));
        attRec.add(new BarEntry(10f,74.3f));
        attRec.add(new BarEntry(11f,60.2f));
        attRec.add(new BarEntry(12f,28.9f));

        BarDataSet attDataset = new BarDataSet(attRec,"Average Attendance");
        BarData attData = new BarData(attDataset);
        attChart.setData(attData);


        int[] colors = {Color.BLACK, Color.BLUE, Color.rgb(125, 0, 200), Color.WHITE, Color.MAGENTA,
                Color.GRAY, Color.YELLOW, Color.rgb(157,157,157), Color.GREEN, Color.DKGRAY, Color.RED, Color.CYAN  };
        attDataset.setColors(ColorTemplate.createColors(colors));
        attDataset.setValueTextColor(Color.BLUE);
        attDataset.setValueTextSize(10f);
        attChart.setFitBars(true);
        attChart.setHorizontalScrollBarEnabled(true);
        attChart.setVerticalScrollBarEnabled(true);
        attDataset.setValueFormatter(new PercentFormatter());
        attChart.setBackgroundColor(Color.rgb(200,200,200));
        attChart.animateXY(4000, 4000);

    }
}