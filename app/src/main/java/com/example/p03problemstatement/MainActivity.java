package com.example.p03problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int requestCodeForModuleInfo = 1;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<modules> modules;
    ArrayList<String> dg1;
    ArrayList<String> dg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.ListViewModules);

        modules = new ArrayList<>();
        dg1 = new ArrayList<>();
        dg2 = new ArrayList<>();

        dg1.add("B");
        dg1.add("C");
        dg1.add("A");
        dg2.add("A");
        dg2.add("B");
        dg2.add("C");

        modules.add(new modules("Web Services", "C203", dg1, "jason_lim@rp.edu.sg"));
        modules.add(new modules("Android Programming II", "C347", dg2, "jason_lim@rp.edu.sg"));

        aa = new CustomAdapterMain(this, R.layout.row, modules);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, info.class);
                i.putExtra("module", modules.get(position));
                startActivityForResult(i, requestCodeForModuleInfo);
            }
        });

    }
}
