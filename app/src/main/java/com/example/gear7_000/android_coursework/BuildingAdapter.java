package com.example.gear7_000.android_coursework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BuildingAdapter extends ArrayAdapter<Building> {

    private int resource;
    private ArrayList<Building> buildings;
    private Context context;

    public BuildingAdapter(Context context, int resource, ArrayList<Building> buildings) {
        super(context, resource, buildings);
        this.resource = resource;
        this.buildings = buildings;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);

            imageView.setImageResource(buildings.get(position).getPhoto());
            textViewName.setText(buildings.get(position).getName());
            textViewDetail.setText(buildings.get(position).getDetail());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }

}