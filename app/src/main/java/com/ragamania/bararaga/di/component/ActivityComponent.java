package com.ragamania.bararaga.di.component;

import com.ragamania.bararaga.di.ActivityScope;
import com.ragamania.bararaga.view.activity.auth.AuthActivity;
import com.ragamania.bararaga.view.activity.detail_list.DetailListActivity;
import com.ragamania.bararaga.view.activity.main.MainActivity;
import com.ragamania.bararaga.view.activity.profile.ProfileActivity;
import com.ragamania.bararaga.view.activity.settings.SettingsActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(AuthActivity authActivity);

    void inject(DetailListActivity detailListActivity);

    void inject(ProfileActivity profileActivity);

}