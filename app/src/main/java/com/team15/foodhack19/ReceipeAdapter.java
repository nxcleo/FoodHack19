package com.team15.foodhack19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.team15.foodhack19.objectClass.Receipe;

import java.util.ArrayList;

public class ReceipeAdapter extends ArrayAdapter<Receipe> {
    public ReceipeAdapter(Context context, ArrayList<Receipe> receipes) {
        super(context, 0, receipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Receipe receipe = getItem(position);

        // convertView = LayoutInflater.from(getContext()).inflate(R.layout.receipe_item, parent, false);

        // Lookup view for data population
//        TextView timeStamp = convertView.findViewById(R.id.timestamp);
//        TextView status = convertView.findViewById(R.id.status);


        // Populate the data into the template view using the data object
//        timeStamp.setText(forecastStatus.getTimeStamp());
//        status.setText(forecastStatus.getStatus());


        // Return the completed view to render on screen
        return convertView;
    }
}
