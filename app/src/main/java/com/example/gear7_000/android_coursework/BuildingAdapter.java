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

    //variables needed to display building object is declared.
    private int resource;
    private ArrayList<Building> buildings;
    private Context context;

    //constructor receives list of building objects, context and resources as parameter.
    public BuildingAdapter(Context context, int resource, ArrayList<Building> buildings) {
        super(context, resource, buildings);
        this.resource = resource;
        this.buildings = buildings;
        this.context = context;
    }

    @NonNull
    @Override
    //each building object's position, convertView and its parent are received as parameters.
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                //takes a layout XML and parses it to create the view and viewgroup objects. In this case, list_building_item.xml
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            //recognizes three particular components which are imageview, name, and detail.
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);

            //sets the three components with the attributes of each buildding object.
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