package com.ragamania.bararaga.view.activity.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.ragamania.bararaga.view.fragment.preference.MyPreferenceFragment;
import com.ragamania.bararaga.data.local.PreferencesHelper;
import com.ragamania.bararaga.view.AppActivity;

import javax.inject.Inject;

public class SettingsActivity extends AppActivity {

    @Inject
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean notificationsPrefs = prefs.getBoolean("prefs_notifications", false);

        preferencesHelper.setNotificationsPrefs(notificationsPrefs);
    }
}