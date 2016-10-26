package com.ragamania.bararaga.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class CoachesList {

    /**
     * coaches_id : 1
     * name : Mochamad Slamet
     * desc : Long Distance Running Coach
     * img_url : http://cdn.running.competitor.com/files/2011/07/long-run.jpg
     */

    private int coaches_id;
    private String name;
    private String desc;
    private String img_url;

    public static List<CoachesList> arrayCoachesListFromData(String str) {

        Type listType = new TypeToken<ArrayList<CoachesList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getCoaches_id() {
        return coaches_id;
    }

    public void setCoaches_id(int coaches_id) {
        this.coaches_id = coaches_id;
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
