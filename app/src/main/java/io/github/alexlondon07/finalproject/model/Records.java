package io.github.alexlondon07.finalproject.model;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alexlondon07 on 11/4/17.
 */

@Root(name = "records")
public class Records  implements Serializable{

    @Attribute(name="date", required = false)
    private String date;

    @ElementList(entry = "movieinfo", inline = true)
    private ArrayList<MovieInfo> movieInfo;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<MovieInfo> getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(ArrayList<MovieInfo> movieInfo) {
        this.movieInfo = movieInfo;
    }
}
