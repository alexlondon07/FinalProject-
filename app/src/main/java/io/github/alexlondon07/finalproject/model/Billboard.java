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


}
