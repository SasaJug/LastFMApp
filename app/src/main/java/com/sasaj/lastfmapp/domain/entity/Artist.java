
package com.sasaj.lastfmapp.domain.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


import static com.sasaj.lastfmapp.domain.constants.TableNames.ARTIST_TABLE_NAME;

@Entity(tableName = ARTIST_TABLE_NAME)
public class Artist extends BaseModel {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("playcount")
    @Expose
    private String playcount;

    @SerializedName("listeners")
    @Expose
    private String listeners;

    @PrimaryKey
    @NonNull
    @SerializedName("mbid")
    @Expose
    private String mbid;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("streamable")
    @Expose
    private String streamable;

    @Ignore
    @SerializedName("image")
    @Expose
    private List<Image> image = null;

    @Ignore
    public Artist() {
    }

    /**
     * @param listeners
     * @param mbid
     * @param name
     * @param image
     * @param streamable
     * @param playcount
     * @param url
     */
    @Ignore
    public Artist(String name, String playcount, String listeners, String mbid, String url, String streamable, List<Image> image) {
        super();
        this.name = name;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.image = image;
    }

    public Artist(String name, String playcount, String listeners, String mbid, String url, String streamable) {
        super();
        this.name = name;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}