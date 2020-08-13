package org.huixing.hxplayer.widget.media;

public interface IProgressChangeListener {
    void onStartTrackingTouch();

    void onProgressChanged(String s, long newposition);

    void onStopTrackingTouch();
}