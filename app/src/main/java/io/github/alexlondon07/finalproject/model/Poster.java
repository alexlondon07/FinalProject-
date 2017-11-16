package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@Element(name = "poster")
public class Poster implements Serializable {

    @Element(name ="location")
    private String location;

    @Element(name ="xlarge")
    private String xlarge;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getXlarge() {
        return xlarge;
    }

    public void setXlarge(String xlarge) {
        this.xlarge = xlarge;
    }
}
