package com.example.p03problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterMain extends ArrayAdapter {
    private ArrayList<modules> modules;
    private Context context;
    private TextView tvModuleName, tvModuleCode;

    public CustomAdapterMain(Context context, int resource, ArrayList<modules> objects){
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvModuleName = rowView.findViewById(R.id.textViewName);
        tvModuleCode = rowView.findViewById(R.id.textViewCode);

        modules currentModules = modules.get(position);

        tvModuleName.setText(currentModules.getName());
        tvModuleCode.setText(currentModules.getCode());
        return rowView;
    }
}
