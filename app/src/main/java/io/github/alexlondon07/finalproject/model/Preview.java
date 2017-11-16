package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;

import java.io.Serializable;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@Element(name = "preview")
public class Preview implements Serializable {

    @Element(name ="large")
    private Large large;

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }
}
