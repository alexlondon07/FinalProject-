package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@Element(name = "cast")
public class Cast{

    @ElementList(name ="name", inline = true)
    private ArrayList<String> name;

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }
}
