package com.ragamania.bararaga.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ragamania.bararaga.BaseApplication;
import com.ragamania.bararaga.di.component.ActivityComponent;
import com.ragamania.bararaga.di.component.DaggerActivityComponent;

public abstract class AppActivity extends AppCompatActivity {

    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComponent = DaggerActivityComponent.builder().applicationComponent(getApp().getApplicationComponent()).build();
    }

    protected ActivityComponent getComponent() {
        return mComponent;
    }

    protected BaseApplication getApp() {
        return (BaseApplication) getApplicationContext();
    }

}
