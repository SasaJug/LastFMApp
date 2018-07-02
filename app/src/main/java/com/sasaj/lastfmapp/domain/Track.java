package com.sasaj.lastfmapp.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sasaj.lastfmapp.repository.local.database.converter.ArtistConverter;
import com.sasaj.lastfmapp.repository.local.database.converter.ImageConverter;
import com.sasaj.lastfmapp.repository.local.database.converter.StreamableConverter;

import java.util.List;

import static com.sasaj.lastfmapp.repository.local.database.constants.TableNames.TRACK_TABLE_NAME;

@Entity(tableName = TRACK_TABLE_NAME)
public class Track extends BaseModel{

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("playcount")
    @Expose
    private String playcount;

    @SerializedName("listeners")
    @Expose
    private String listeners;

    @SerializedName("mbid")
    @Expose
    private String mbid;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("streamable")
    @Expose
    @TypeConverters(StreamableConverter.class)
    private Streamable streamable;

    @SerializedName("artist")
    @Expose
    @TypeConverters(ArtistConverter.class)
    private Artist artist;

    @SerializedName("image")
    @Expose
    @TypeConverters(ImageConverter.class)
    private List<Image> images = null;

    @Ignore
    public Track(String name, String duration, String playcount, String listeners, String mbid, String url, Streamable streamable, Artist artist, List<Image> images) {
        super();
        this.name = name;
        this.duration = duration;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.images = images;
    }

    public Track(long id, String name, String duration, String playcount, String listeners, String mbid, String url, Streamable streamable, Artist artist, List<Image> images) {
        super();
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.playcount = playcount;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.artist = artist;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public Streamable getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> image) {
        this.images = image;
    }


}
