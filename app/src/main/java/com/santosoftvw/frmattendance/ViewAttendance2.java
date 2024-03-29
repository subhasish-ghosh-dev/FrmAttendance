package com.santosoftvw.frmattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewAttendance2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance2);

        Intent intent = this.getIntent();
        HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)
                intent.getSerializableExtra("attendance");
        TableLayout tbl = (TableLayout) findViewById(R.id.tableLayout4);

        int idx = 0;
        for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
            ArrayList<String> att = e.getValue();
            TableRow tblRow = new TableRow(this);
            tblRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            TextView txtRollNo = new TextView(this);
            txtRollNo.setLayoutParams(new TableRow.LayoutParams(138, TableRow.LayoutParams.MATCH_PARENT));
            txtRollNo.setGravity(Gravity.CENTER);
            txtRollNo.setTypeface(null, Typeface.BOLD);
            txtRollNo.setText(att.get(0));

            TextView txtCourseCode = new TextView(this);
            txtCourseCode.setLayoutParams(new TableRow.LayoutParams(138, TableRow.LayoutParams.MATCH_PARENT));
            txtCourseCode.setGravity(Gravity.CENTER);
            txtCourseCode.setTypeface(null, Typeface.BOLD);
            txtCourseCode.setText(att.get(1));

            TextView txtDate = new TextView(this);
            txtDate.setLayoutParams(new TableRow.LayoutParams(138, TableRow.LayoutParams.MATCH_PARENT));
            //txtDate.setGravity(Gravity.CENTER);
            txtDate.setTypeface(null, Typeface.BOLD);
            txtDate.setText(att.get(2));

            if (idx % 2 == 0) {
                tblRow.setBackgroundColor(Color.BLUE);
                txtRollNo.setTextColor(Color.WHITE);
                txtCourseCode.setTextColor(Color.WHITE);
                txtDate.setTextColor(Color.WHITE);
                tblRow.addView(txtRollNo);
                tblRow.addView(txtCourseCode);
                tblRow.addView(txtDate);
            } else {
                tblRow.setBackgroundColor(Color.WHITE);
                txtRollNo.setTextColor(Color.BLUE);
                txtCourseCode.setTextColor(Color.BLUE);
                txtDate.setTextColor(Color.BLUE);
                tblRow.addView(txtRollNo);
                tblRow.addView(txtCourseCode);
                tblRow.addView(txtDate);
            }
            tbl.addView(tblRow);
            idx++;
        }

        Button btnChart = (Button) findViewById(R.id.btnChart);
        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AvgAttendance.class);
                startActivity(intent);
            }
        });

        Button btnChart1 = (Button) findViewById(R.id.button4);
        btnChart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PieChartActivity.class);
                startActivity(intent);
            }
        });

        Button btnChart2 = (Button) findViewById(R.id.button3);
        btnChart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FileIOActivity.class);
                startActivity(intent);
            }
        });

    }
}