package com.example.registerandlogin.objects;

import android.widget.ImageButton;

import java.util.ArrayList;

public class Items {
    private final String text;
    private ImageButton imageButton;
    private byte[] photoData;

    public Items(String text, byte[] photoData) {
        this.text = text;
        this.photoData = photoData;
    }

    public String getText() {
        return text;
    }

    public byte[] getPhotoData() {
        return photoData;
    }
}
