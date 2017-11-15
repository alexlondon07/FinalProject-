package io.github.alexlondon07.finalproject.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Text;

/**
 * Created by alexlondon07 on 11/11/17.
 */

@Element(name = "large")
public class Large {

    @Text
    private String content;

    @Attribute(name = "filesize")
    private String filesize;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }
}
