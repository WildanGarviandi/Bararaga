package com.ragamania.bararaga.model.ArticleDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 11/8/16.
 */

public class BaseResponseArticleDetail {

    /**
     * status : 200
     * message : Coaches for 20-15-2016
     * news_id : 299291
     * news : {}
     */

    private int status;
    private String message;
    private String news_id;
    private News news;

    public static List<BaseResponseArticleDetail> arrayBaseResponseArticleDetailFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseResponseArticleDetail>>() {
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

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
