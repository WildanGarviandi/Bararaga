package com.ragamania.bararaga.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;
import com.ragamania.bararaga.view.activity.auth.AuthActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wildangarviandi on 10/27/16.
 */

public class SplashActivity extends AppBaseActivity {
    @Override
    protected int getResourceLayout() {
        return R.layout.splash_activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), AuthActivity.class));
                SplashActivity.this.finish();
            }
        }, 3000);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }
}
