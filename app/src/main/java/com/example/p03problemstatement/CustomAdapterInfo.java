package com.example.p03problemstatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterInfo extends ArrayAdapter {
    private ArrayList<String> grades;
    private Context context;
    private TextView tvGrade, tvWeek;

    public CustomAdapterInfo(Context context, int resource, ArrayList<String> objects){
        super(context, resource, objects);
        grades = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        tvGrade = rowView.findViewById(R.id.textViewGrade);
        tvWeek = rowView.findViewById(R.id.textViewWeek);

        String grade = grades.get(position);

        tvGrade.setText(grade);
        tvWeek.setText("Week " + (position + 1));
        return rowView;
    }
}
