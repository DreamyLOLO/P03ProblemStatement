package com.example.p03problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class info extends AppCompatActivity {
    int requestCodeForAdd = 2;
    int requestCodeInternet = 3;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<String> grades;
    Button btnEmail, btnAdd, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btnEmail = findViewById(R.id.buttonEmail);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);

        grades = new ArrayList<>();

        Intent i = getIntent();
        final modules first = (modules) i.getSerializableExtra("module");
        final ArrayList<String> dg = first.getDg();
        for(int f = 0; f < dg.size(); f++){
            grades.add(dg.get(f));
        }
        lv = this.findViewById(R.id.ListViewDailyGrade);

        aa = new CustomAdapterInfo(this, R.layout.row, grades);
        lv.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String gradeComment = "";
                for(int f = 0; f < dg.size(); f++) {
                    gradeComment += "Week " + (f+1) + ": " + dg.get(f) + "\n";
                }
                String msg = "Hi faci,\n\nI am ...\nPlease see my remarks so far,thank you!\n\n" + gradeComment;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{first.getEmail()});
                email.putExtra(Intent.EXTRA_SUBJECT,"Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT, msg);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }});

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(info.this, add.class);
                i.putExtra("module", first);
                startActivityForResult(i, requestCodeForAdd);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                if(first.getCode().equalsIgnoreCase("C347")) {
                    i.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                } else if(first.getCode().equalsIgnoreCase("C203")) {
                    i.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C203"));
                }
                startActivityForResult(i, requestCodeInternet);
            }
        });
    }
}
