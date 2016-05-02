package com.example.navdrawer;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.navdrawer.fragments.GalleryFragment;
import com.example.navdrawer.fragments.ImportFragment;
import com.example.navdrawer.fragments.SlideshowFragment;
import com.example.navdrawer.fragments.ToolsFragment;

public class NavigationActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        ImportFragment.OnFragmentInteractionListener,
        GalleryFragment.OnFragmentInteractionListener,
        SlideshowFragment.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = this.getSupportFragmentManager();

        if (id == R.id.nav_camera) {
            // Change to the import fragment
            ImportFragment importFragment = (ImportFragment) fragmentManager.findFragmentByTag(ImportFragment.TAG);
            if(importFragment == null) {
                fragmentManager.beginTransaction().replace(R.id.container, ImportFragment.newInstance(id), ImportFragment.TAG).commit();
            }

        } else if (id == R.id.nav_gallery) {
            // Chang to the gallery fragment
            GalleryFragment galleryFragment = (GalleryFragment) fragmentManager.findFragmentByTag(GalleryFragment.TAG);
            if(galleryFragment == null) {
                fragmentManager.beginTransaction().replace(R.id.container, GalleryFragment.newInstance(id), GalleryFragment.TAG).commit();
            }

        } else if (id == R.id.nav_slideshow) {
            // Change to the slideshow fragment
            SlideshowFragment slideShowFragment = (SlideshowFragment) fragmentManager.findFragmentByTag(SlideshowFragment.TAG);
            if(slideShowFragment == null) {
                fragmentManager.beginTransaction().replace(R.id.container, SlideshowFragment.newInstance(id), SlideshowFragment.TAG).commit();
            }

        } else if (id == R.id.nav_manage) {
            // Change to the slideshow fragment
            ToolsFragment toolsFragment = (ToolsFragment) fragmentManager.findFragmentByTag(ToolsFragment.TAG);
            if(toolsFragment == null) {
                fragmentManager.beginTransaction().replace(R.id.container, ToolsFragment.newInstance(id), ToolsFragment.TAG).commit();
            }

        } else if (id == R.id.nav_share) {
            // Make it do something..
            // Doesn't currently do anything


        } else if (id == R.id.nav_send) {
            // Make it do something else..
            // Doesn't currently do anything


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onSectionAttached(int number){

        switch(number) {
            case 1:
//                 mTitle = getString(R.string.title_import);
                break;
            case 2:
                // mTitle = getString(R.string.title_gallery);
                break;
            case 3:
                // mTitle = getString(R.string.title_slideshow);
                break;
            case 4:
                // mTitle = getString(R.string.title_tools);
                break;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // this.onSectionAttached(position);
    }
}
