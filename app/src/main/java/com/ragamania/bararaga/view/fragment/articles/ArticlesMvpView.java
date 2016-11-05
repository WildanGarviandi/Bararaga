package com.ragamania.bararaga.view.fragment.articles;


import com.ragamania.bararaga.model.ArticlesModel.ArticlesList;
import com.ragamania.bararaga.view.MvpView;

import java.util.List;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public interface ArticlesMvpView extends MvpView {
    void loadArticles(List<ArticlesList> articlesLists);
}
