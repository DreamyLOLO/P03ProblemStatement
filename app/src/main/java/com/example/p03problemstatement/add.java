package com.example.p03problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class add extends AppCompatActivity {

    int requestCodeForAddModule = 3;
    TextView tvweek;
    Button btnsubmit;
    RadioGroup rggrade;
    RadioButton rbgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnsubmit = findViewById(R.id.buttonSubmit);
        rggrade = findViewById(R.id.RadioGroupGrade);
        tvweek = findViewById(R.id.textViewWeek);

        Intent i = getIntent();
        final modules a = (modules) i.getSerializableExtra("module");
        final ArrayList<String> b = a.getDg();
        tvweek.setText("Week " + (b.size() + 1));

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gradeId = rggrade.getCheckedRadioButtonId();
                rbgrade = findViewById(gradeId);
                String grade = rbgrade.getText().toString();
                Intent intent = new Intent(add.this, info.class);
                ArrayList<String> b = a.getDg();
                b.add(grade);
                a.setDg(b);
                intent.putExtra("module", a);
                startActivityForResult(intent, requestCodeForAddModule);
            }
        });
    }
    }

