package com.ragamania.bararaga.model.DetailCoaches;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public class Bio {


    /**
     * phone_number : 08161462736
     * email : garviandiwildan@gmail.com
     * address : Kuningan selatan no.1
     * image_url : http://coachparry.com/wp-content/uploads/2014/08/ACP117.jpg
     */

    private String phone_number;
    private String email;
    private String address;
    private String image_url;

    public static List<Bio> arrayBioFromData(String str) {

        Type listType = new TypeToken<ArrayList<Bio>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
