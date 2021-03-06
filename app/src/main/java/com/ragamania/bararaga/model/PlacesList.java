package com.ragamania.bararaga.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/22/16.
 */


public class PlacesList {

    /**
     * place_id : 1
     * name : Futsal Patiunus
     * desc : Lapangan Futsal
     * img_url : http://harga.web.id/wp-content/uploads/Lapangan-Futsal-Indoor.jpeg
     */

    private int place_id;
    private String name;
    private String desc;
    private String img_url;

    public static List<PlacesList> arrayPlacesListFromData(String str) {

        Type listType = new TypeToken<ArrayList<PlacesList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
