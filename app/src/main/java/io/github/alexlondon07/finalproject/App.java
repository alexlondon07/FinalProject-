package io.github.alexlondon07.finalproject;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by alexlondon07 on 12/2/17.
 */

public class App extends Application {

    private Tracker tracker;

    synchronized  public Tracker getDefaultTracker(){

        if(tracker == null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }
}
