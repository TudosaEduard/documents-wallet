package com.example.registerandlogin.objects;

import java.util.ArrayList;

public class RecyclerViewList {
    ArrayList<Items> items = new ArrayList<>();

    public RecyclerViewList(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void addItems(Items item){
        items.add(item);
    }
}
