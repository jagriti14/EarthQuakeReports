package com.example.android.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Date;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Dell on 02-07-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private String[] subs = new String[1];
    int j;
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    public WordAdapter(Activity context, ArrayList<Word> androidFlavors) {
        super(context, 0, androidFlavors);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentAndroidFlavor = getItem(position);
        TextView magTextView = (TextView) listItemView.findViewById(R.id.view1);
        magTextView.setText(changetoString(currentAndroidFlavor.getmMagnitude()));

        TextView nearTextView = (TextView) listItemView.findViewById(R.id.view2);
        nearTextView.setText(stringdiv(currentAndroidFlavor.getmCity()));
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.view4);
        nameTextView.setText(subs[1]);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.view3);
        dateTextView.setText(changeIt(currentAndroidFlavor.getmDate()));


        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        String mystring = changetoString(currentAndroidFlavor.getmMagnitude());
        double d = Double.parseDouble(mystring);

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(d);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }

    private String changetoString(double d){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(d);
        return output;
    }
    private String changeIt(long t){
        Date dateObject = new Date(t);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        String dateCompo = dateFormatter.format(dateObject);
        SimpleDateFormat timing = new SimpleDateFormat("hh:mm a");
        String TimeCompo = timing.format(dateObject);
        String dateToDisplay = dateCompo +"\n" +TimeCompo;
        return dateToDisplay;
    }
    private String stringdiv(String place){
        for(j=0;j<place.length();j++)
        {
            int index = place.indexOf(" of ");
            if(index!=-1){
                subs = place.split(" of ");
                subs[0]=subs[0]+" of";
            }
            else{
                subs[0]="Near the";
                subs[1]=place;
            }

        }
        return subs[0];
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

}
