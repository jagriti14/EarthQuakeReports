package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Dell on 09-07-2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Word>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Word> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Word> result = Utlis.fetchEarthquakeData(mUrl);
        return result;
    }
}
