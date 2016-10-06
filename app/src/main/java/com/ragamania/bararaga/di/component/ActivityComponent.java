package com.ragamania.bararaga.di.component;

import com.ragamania.bararaga.di.ActivityScope;
import com.ragamania.bararaga.view.activity.auth.AuthActivity;
import com.ragamania.bararaga.view.activity.main.MainActivity;
import com.ragamania.bararaga.view.activity.settings.SettingsActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent extends ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(AuthActivity authActivity);
}