package model;

public class Song {
    String songName;
    int picture;
    String singer;
    int songLink;

    public Song(String songName, int picture, String singer, int songLink) {
        this.songName = songName;
        this.picture = picture;
        this.singer = singer;
        this.songLink = songLink;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSongLink() {
        return songLink;
    }

    public void setSongLink(int songLink) {
        this.songLink = songLink;
    }
}
