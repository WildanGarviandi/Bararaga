package com.ragamania.bararaga.model.ArticlesModel;

import java.util.List;

/**
 * Created by wildangarviandi on 10/31/16.
 */

public class BaseResponseArticles {
    /**
     * status : 200
     * message : Places for 20-15-2016
     * array : []
     */

    private int status;
    private String message;
    private List<ArticlesList> articles;

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

    public List<ArticlesList> getArticles() {
        return articles;
    }

    public void setArray(List<ArticlesList> array) {
        this.articles = array;
    }
}
