package com.ragamania.bararaga.model.ArticlesModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wildangarviandi on 10/31/16.
 */

public class ArticlesList {


    /**
     * id_article :
     * date :
     * title : Manfaat Ikan Baramundi untuk Nutrisi Dietmu
     * source : Kokiku.com
     * icon_source : https://static.glassdoor.com/static/img/mobile/icons/touch-icon-57.png
     * img_article : https://41dcdfcd4dea0e5aba20-931851ca4d0d7cdafe33022cf8264a37.ssl.cf1.rackcdn.com/9588884_ky-cooks--ikan-bakar-siakap_843eed70_m.jpg
     */

    private String id_article;
    private String date;
    private String title;
    private String source;
    private String icon_source;
    private String img_article;

    public static List<ArticlesList> arrayArticlesListFromData(String str) {

        Type listType = new TypeToken<ArrayList<ArticlesList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIcon_source() {
        return icon_source;
    }

    public void setIcon_source(String icon_source) {
        this.icon_source = icon_source;
    }

    public String getImg_article() {
        return img_article;
    }

    public void setImg_article(String img_article) {
        this.img_article = img_article;
    }
}
