package com.app.footlocker_newsreader.restapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootResponse {

    @SerializedName("Items")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
