package io.github.alexlondon07.finalproject.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 11/4/17.
 */

public class Billboard implements Serializable {

    @SerializedName("id_billboard")
    @Expose
    private int idBollboard;


    @SerializedName("avatar")
    @Expose
    private String avatar;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("genre")
    @Expose
    private String genre;


    @SerializedName("sinopsis")
    @Expose
    private String sinopsis;


    @SerializedName("cast")
    @Expose
    private String cast;


    @SerializedName("movie_director")
    @Expose
    private String movie_director;


    @SerializedName("duration")
    @Expose
    private String duration;


    @SerializedName("IMDb")
    @Expose
    private String IMDb;


    public int getIdBollboard() {
        return idBollboard;
    }

    public void setIdBollboard(int idBollboard) {
        this.idBollboard = idBollboard;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIMDb() {
        return IMDb;
    }

    public void setIMDb(String IMDb) {
        this.IMDb = IMDb;
    }
}
