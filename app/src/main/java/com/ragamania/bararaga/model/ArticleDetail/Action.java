package com.ragamania.bararaga.model.ArticleDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Action {

    /**
     * type : coaches
     * text_action : get RUNNING COACHES
     */

    private String type;
    private String text_action;

    public static List<Action> arrayActionFromData(String str) {

        Type listType = new TypeToken<ArrayList<Action>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText_action() {
        return text_action;
    }

    public void setText_action(String text_action) {
        this.text_action = text_action;
    }
}
