package io.github.alexlondon07.finalproject.model.cinemas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alexlondon07 on 12/2/17.
 */

public class Cinema implements Serializable {


    @SerializedName("_id")
    @Expose
    private String id;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("locationsList")
    @Expose
    private List<LocationsList> locationList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LocationsList> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationsList> locationList) {
        this.locationList = locationList;
    }
}
