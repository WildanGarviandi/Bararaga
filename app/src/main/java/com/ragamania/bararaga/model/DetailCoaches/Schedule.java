package com.ragamania.bararaga.model.DetailCoaches;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public class Schedule {

    /**
     * day : Senin
     * time : 28-03-2016 : 18.00-22.30
     */

    private String day;
    private String time;

    public static List<Schedule> arrayScheduleFromData(String str) {

        Type listType = new TypeToken<ArrayList<Schedule>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
