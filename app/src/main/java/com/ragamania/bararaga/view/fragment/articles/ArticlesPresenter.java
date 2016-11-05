package com.ragamania.bararaga.view.fragment.articles;

import android.content.Context;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.model.ArticlesModel.BaseResponseArticles;

import net.derohimat.baseapp.presenter.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public class ArticlesPresenter implements BasePresenter<ArticlesMvpView> {
    private ArticlesMvpView mArticlesMvpView;
    private Subscription mSubscription;
    private BaseResponseArticles mResponse;

    @Inject
    public ArticlesPresenter(Context context) {
        ((BaseApplication) context.getApplicationContext()).getApplicationComponent().inject(this);
    }

    @Inject
    APIService mAPIService;

    @Override
    public void attachView(ArticlesMvpView view) {
        mArticlesMvpView = view;
    }

    @Override
    public void detachView() {
        mArticlesMvpView = null;
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadArticlesList() {

        if (mSubscription != null) mSubscription.unsubscribe();

        BaseApplication baseApplication = BaseApplication.get(mArticlesMvpView.getContext());

        mSubscription = mAPIService.getArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(baseApplication.getSubscribeScheduler())
                .subscribe(new Subscriber<BaseResponseArticles>() {
                    @Override
                    public void onCompleted() {
                        Timber.i("Articles loaded %s", mResponse);
                        mArticlesMvpView.loadArticles(mResponse.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("Error loading merror %s", e);
                    }

                    @Override
                    public void onNext(BaseResponseArticles baseResponseArticles) {
                        mResponse = baseResponseArticles;
                    }
                });
    }
}
