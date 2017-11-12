package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@ElementList(name = "movieInfo")
public class MovieInfo implements Serializable {

    @Element(name = "id")
    private String id;

    @Element(name = "info")
    private Info info;

    @ElementList(required = false,entry="genre",inline = true)
    private ArrayList<Genre> genre;

    @ElementList(required = false,entry="cast",inline = true)
    private ArrayList<Cast> cast;

    @ElementList(required = false, entry="poster", inline = true)
    private ArrayList<Poster> poster;

    @Element(name="preview")
    private Preview preview;

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", genre = "+genre+", cast = "+cast+", preview = "+preview+", poster = "+poster+", info = "+info+"]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public ArrayList<Poster> getPoster() {
        return poster;
    }

    public void setPoster(ArrayList<Poster> poster) {
        this.poster = poster;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }
}
