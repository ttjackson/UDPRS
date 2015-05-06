package com.lenovo.health.urdrs;

/**
 * Created by tianye4 on 2015/5/4.
 */
public class ItemData {
    private int Type;
    private int DrawableID;
    private String Title;
    private String Intro;
    private String URL;


    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


    public int getDrawableID() {
        return DrawableID;
    }

    public void setDrawableID(int drawableID) {
        DrawableID = drawableID;
    }
}
