package io.github.alexlondon07.finalproject.model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by alexlondon07 on 11/4/17.
 */

@Root(name = "records")
public class Records {

    @Element(name="date")
    private String date;

    @ElementList(entry = "movieinfo", inline = true)
    private List<MovieInfo> movieInfo;

    public List<MovieInfo> getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(List<MovieInfo> movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
