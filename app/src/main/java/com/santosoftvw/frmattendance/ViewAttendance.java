package com.santosoftvw.frmattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ActionMenuView;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        Intent intent = this.getIntent();
        HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)
                intent.getSerializableExtra("attendance");
        TableLayout tbl = (TableLayout) findViewById(R.id.tableLayout3);

        int idx = 0;
        for(Map.Entry<String, ArrayList<String>> e : map.entrySet()){
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
            txtDate.setGravity(Gravity.CENTER);
            txtDate.setTypeface(null, Typeface.BOLD);
            txtDate.setText(att.get(2));

            if(idx%2==0){
                tblRow.setBackgroundColor(Color.BLUE);
                txtRollNo.setTextColor(Color.WHITE);
                txtCourseCode.setTextColor(Color.WHITE);
                txtDate.setTextColor(Color.WHITE);
                tblRow.addView(txtRollNo);
                tblRow.addView(txtCourseCode);
                tblRow.addView(txtDate);
            }
            else{
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

    }
}