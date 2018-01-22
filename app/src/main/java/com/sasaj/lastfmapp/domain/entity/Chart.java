
package com.sasaj.lastfmapp.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chart {

    @SerializedName("artists")
    @Expose
    private Artists artists;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Chart() {
    }

    /**
     * 
     * @param artists
     */
    public Chart(Artists artists) {
        super();
        this.artists = artists;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

}
