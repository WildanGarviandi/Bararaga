package com.ragamania.bararaga.model.DetailCoaches;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public class Coaches {


    /**
     * coach_id : 1
     * bio : {}
     * name : MOCHAMMAD SLAMET
     * profession : Running Coach
     * overview : I am a running coach. I train athletes that wants to become olympians. My classes are usually located around southern parts of Jakarta
     * schedule : [{}]
     */

    private String coach_id;
    private Bio bio;
    private String name;
    private String profession;
    private String overview;
    private List<Schedule> schedule;

    public static List<Coaches> arrayCoachesDetailFromData(String str) {

        Type listType = new TypeToken<ArrayList<Coaches>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    public Bio getBio() {
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}
