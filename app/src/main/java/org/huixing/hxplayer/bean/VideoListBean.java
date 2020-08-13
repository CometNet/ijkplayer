package org.huixing.hxplayer.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class VideoListBean implements Serializable{
    String videoName;
    String videoLength;
    String videoPath;
    Drawable cover;

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public Drawable getCover() {
        return cover;
    }

    public void setCover(Drawable cover) {
        this.cover = cover;
    }

}