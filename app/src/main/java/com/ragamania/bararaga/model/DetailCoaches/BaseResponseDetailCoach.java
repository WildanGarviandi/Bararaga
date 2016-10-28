package com.ragamania.bararaga.model.DetailCoaches;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public class BaseResponseDetailCoach {

    /**
     * status : 200
     * message : Places for 20-15-2016
     * coaches : {}
     */

    private int status;
    private String message;
    private Coaches coaches;

    public static List<BaseResponseDetailCoach> arrayBaseResponseDetailCoachFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseResponseDetailCoach>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Coaches getCoaches() {
        return coaches;
    }

    public void setCoaches(Coaches coaches) {
        this.coaches = coaches;
    }
}
