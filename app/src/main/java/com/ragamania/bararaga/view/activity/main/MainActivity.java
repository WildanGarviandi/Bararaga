package com.ragamania.bararaga.view.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.ragamania.bararaga.R;
import com.ragamania.bararaga.view.AppBaseActivity;
import com.ragamania.bararaga.view.activity.message.MessageActivity;
import com.ragamania.bararaga.view.activity.profile.ProfileActivity;
import com.ragamania.bararaga.view.activity.settings.SettingsActivity;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends AppBaseActivity implements MainMvpView, NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    private static ProgressBar mProgressBar = null;
    private MainPresenter mMainPresenter;
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;

    @Inject
    EventBus eventBus;

    @Override
    protected int getResourceLayout() {
        return R.layout.main_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);

        mTitle = mDrawerTitle = getTitle();
        mPlanetTitles = getResources().getStringArray(R.array.menu_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close
        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        //drawer
        mNavigationView.setNavigationItemSelectedListener(this);

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
//        mMainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_exit:
                finish();
                return true;
            case R.id.action_refresh:
                if (getBaseFragmentManager().getBackStackEntryCount() > 0) {
                    //--- we are in the details fragment.

                } else {
                    //--- we are here
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        eventBus.register(this);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_profile :
                Intent i = new Intent(this, ProfileActivity.class);
                startActivity(i);
                this.overridePendingTransition(0,0);
                return true;
            case R.id.navigation_message :
                Intent message = new Intent(this, MessageActivity.class);
                startActivity(message);
                this.overridePendingTransition(0,0);
                return true;
            case R.id.navigation_calendar :
                return true;
            case R.id.navigation_settings :
                return true;
            default:
                return true;
        }
    }
}
