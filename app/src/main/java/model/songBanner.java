package model;

import java.io.Serializable;

public class songBanner implements Serializable {
    private String title;
    private String description;
    private int banner;
    private int picture;

    public songBanner(String title, String description, int banner, int picture) {
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}