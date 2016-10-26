package com.ragamania.bararaga.model;

import java.util.List;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class BaseResponseCoaches {
    /**
     * status : 200
     * message : Places for 20-15-2016
     * array : []
     */

    private int status;
    private String message;
    private List<CoachesList> array;

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

    public List<CoachesList> getArray() {
        return array;
    }

    public void setArray(List<CoachesList> array) {
        this.array = array;
    }
}
