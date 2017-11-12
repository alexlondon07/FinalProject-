package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@Element(name = "preview")
public class Preview  {

    @Element(name ="large")
    private Large large;

    @Override
    public String toString()
    {
        return "ClassPojo [large = "+large+"]";
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }
}
