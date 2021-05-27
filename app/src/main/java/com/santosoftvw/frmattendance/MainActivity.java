package com.santosoftvw.frmattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Serializable {


    /*class Attendance implements Serializable {
        private String rollNo;
        private String course;
        private String date;

        Attendance(String r, String c, String d){
            this.rollNo = r;
            this.course = c;
            this.date = d;
        }

        public String getRollNo() {
            return rollNo;
        }

        public String getCourse() {
            return course;
        }

        public String getDate() {
            return date;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtRoll = (EditText) findViewById(R.id.editTextRollNo);
        EditText txtCode = (EditText) findViewById(R.id.editTextCode);
        EditText txtDate = (EditText) findViewById(R.id.editTextDate);

        Button btnSave = (Button) findViewById(R.id.button);
        Button btnSend = (Button) findViewById(R.id.button2);



        HashMap<String, ArrayList<String>> att = new HashMap<>();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 /*String msg = " Roll No: "+txtRoll.getText().toString() +" Course: "+txtCode.getText().toString()+" Date: "+txtDate.getText().toString();
                 Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
                 toast.setMargin(50,50);
                 toast.show();*/
                 ArrayList<String> details =new ArrayList<String>();
                 details.add(txtRoll.getText().toString());
                 details.add(txtCode.getText().toString());
                 details.add(txtDate.getText().toString());

                 att.put(txtRoll.getText().toString(),details);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewAttendance2.class);
                intent.putExtra("attendance", att);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}