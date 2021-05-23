package com.example.registerandlogin.objects;

import android.widget.ImageButton;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class RecyclerViewList implements Serializable {
    ArrayList<String> items = new ArrayList<>();
    ArrayList<ImageButton> imageButtons = new ArrayList<>();

    public RecyclerViewList(ArrayList<String> items, ArrayList<ImageButton> imageButtons) {
        this.items = items;
        this.imageButtons = imageButtons;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<ImageButton> getImageButtons() {
        return imageButtons;
    }

    public void addItems(String item){
        items.add(item);
    }
}
