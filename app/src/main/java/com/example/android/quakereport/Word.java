package com.example.android.quakereport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 02-07-2017.
 */

public class Word {
    private double  mMagnitude;
    private String mCity;
    private long mDate;
    private String mUrl;

    public Word(double magnitude,String city,long date,String url)
    {
        mMagnitude = magnitude;
        mCity=city;
        mDate = date;
        mUrl = url;
    }

    public double getmMagnitude()
    {
        return mMagnitude;
    }
    public long getmDate()
    {
        return mDate;
    }
    public String getmCity()
    {
        return mCity;
    }
    public String getmUrl(){
        return mUrl;
    }

}
