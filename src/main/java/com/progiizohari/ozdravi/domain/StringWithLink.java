package com.progiizohari.ozdravi.domain;

public class StringWithLink {
    private String string;
    private String link;

    public StringWithLink(String string, String link) {
        this.string = string;
        this.link = link;
    }

    public StringWithLink() {
    }

    public String getString() {
        return string;
    }

    public String getLink() {
        return link;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
