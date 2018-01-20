
package com.sasaj.lastfmapp.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artists {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artists() {
    }

    /**
     * 
     * @param attr
     * @param artist
     */
    public Artists(List<Artist> artist, Attr attr) {
        super();
        this.artist = artist;
        this.attr = attr;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }


}
