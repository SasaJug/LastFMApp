package com.sasaj.lastfmapp.domain.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.sasaj.lastfmapp.domain.constants.TableNames.IMAGE_TABLE_NAME;

@Entity(tableName = IMAGE_TABLE_NAME)
public class Image extends BaseModel {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private long mbid;

    @SerializedName("#text")
    @Expose
    private String text;

    @SerializedName("size")
    @Expose
    private String size;

    @Ignore
    public Image() {
    }

    /**
     * @param text
     * @param size
     */
    public Image(String text, String size) {
        super();
        this.text = text;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMbid() {
        return mbid;
    }

    public void setMbid(long mbid) {
        this.mbid = mbid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}