package com.ragamania.bararaga.di.component;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.data.local.PreferencesHelper;
import com.ragamania.bararaga.data.remote.APIService;
import com.ragamania.bararaga.data.remote.UnauthorisedInterceptor;
import com.ragamania.bararaga.di.module.ApplicationModule;
import com.ragamania.bararaga.view.activity.auth.AuthPresenter;
import com.ragamania.bararaga.view.activity.detail_list.DetailListPresenter;
import com.ragamania.bararaga.view.activity.main.MainPresenter;
import com.ragamania.bararaga.view.activity.message_list.MessagePresenter;
import com.ragamania.bararaga.view.fragment.articles.ArticlesPresenter;
import com.ragamania.bararaga.view.fragment.coaches.CoachesPresenter;
import com.ragamania.bararaga.view.fragment.login.LoginPresenter;
import com.ragamania.bararaga.view.fragment.places.PlacesPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainPresenter mainPresenter);

    void inject(AuthPresenter authPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(PlacesPresenter placesPresenter);

    void inject(CoachesPresenter coachesPresenter);

    void inject(ArticlesPresenter articlesPresenter);

    void inject(BaseApplication baseApplication);

    void inject(UnauthorisedInterceptor unauthorisedInterceptor);

    void inject(DetailListPresenter detailListPresenter);

    void inject(MessagePresenter messagePresenter);

    APIService apiService();

    EventBus eventBus();

    PreferencesHelper prefsHelper();

}