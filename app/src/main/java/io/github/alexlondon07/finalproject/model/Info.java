package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 11/11/17.
 */


@Element(name = "info")
public class Info implements Serializable {

    @Element(name ="title")
    private String title;

    @Element(name ="runtime")
    private String runtime;

    @Element(name ="rating")
    private String rating;

    @Element(name ="studio")
    private String studio;

    @Element(name ="postdate")
    private String postdate;

    @Element(required = false,name="releasedate")
    private String releasedate;

    @Element(name ="copyright")
    private String copyright;

    @Element(name ="director")
    private String director;

    @Element(name ="description")
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
