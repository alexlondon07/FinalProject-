package io.github.alexlondon07.finalproject.model.cinemas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 12/2/17.
 */

public class LocationsList implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("location")
    @Expose
    private Location location;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
