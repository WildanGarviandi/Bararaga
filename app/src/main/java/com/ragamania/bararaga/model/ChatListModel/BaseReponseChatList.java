package com.ragamania.bararaga.model.ChatListModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 11/23/16.
 */

public class BaseReponseChatList {

    /**
     * status : 200
     * Message : Date-02-10-12
     * object : [{}]
     */

    private int status;
    private String Message;
    private List<Object> object;

    public static List<BaseReponseChatList> arrayBaseReponseChatListFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseReponseChatList>>() {
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
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<Object> getObject() {
        return object;
    }

    public void setObject(List<Object> object) {
        this.object = object;
    }
}
