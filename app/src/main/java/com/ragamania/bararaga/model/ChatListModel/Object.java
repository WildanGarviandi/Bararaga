package com.ragamania.bararaga.model.ChatListModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 11/23/16.
 */

public class Object {

    /**
     * img_profile : http://gridgum.com/templates/free-themes/store/images/testimonials/1.jpg
     * username : John Doe
     * title : Long running Coach
     */

    private User user;
    private Pesan pesan;

    public static List<Object> arrayObjectFromData(String str) {

        Type listType = new TypeToken<ArrayList<Object>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pesan getPesan() {
        return pesan;
    }

    public void setPesan(Pesan pesan) {
        this.pesan = pesan;
    }

    public static class User {
        private String img_profile;
        private String username;
        private String title;

        public static List<User> arrayUserFromData(String str) {

            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getImg_profile() {
            return img_profile;
        }

        public void setImg_profile(String img_profile) {
            this.img_profile = img_profile;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Pesan {
        /**
         * message : Hey lets catch up later on weekend while we had a lunch what about this saturday?
         * date : 12-03-2016/22:30
         * viewed : false
         */

        private List<Lastest> lastest;

        public static List<Pesan> arrayPesanFromData(String str) {

            Type listType = new TypeToken<ArrayList<Pesan>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public List<Lastest> getLastest() {
            return lastest;
        }

        public void setLastest(List<Lastest> lastest) {
            this.lastest = lastest;
        }

        public static class Lastest {
            private String message;
            private String date;
            private boolean viewed;

            public static List<Lastest> arrayLastestFromData(String str) {

                Type listType = new TypeToken<ArrayList<Lastest>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public boolean isViewed() {
                return viewed;
            }

            public void setViewed(boolean viewed) {
                this.viewed = viewed;
            }
        }
    }
}
