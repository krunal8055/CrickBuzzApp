package com.example.crickbuzzapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class NavHostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    public NavController navController;
    public DrawerLayout Home_Drawer_Layout;
    public NavigationView HomeNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_host);
        toolbar = findViewById(R.id.home_toolbar);
        setupOperatorNavDrawer();
    }

    private void setupOperatorNavDrawer() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.CrickBuzzDefault));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Home_Drawer_Layout = findViewById(R.id.Homedrawer);
        HomeNavigationView = findViewById(R.id.home_navigationview);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,Home_Drawer_Layout,R.string.app_name,R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.menu_icon);
        actionBarDrawerToggle.syncState();

        //Navigation Controller Setup
        navController = Navigation.findNavController(this,R.id.nav_home_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,Home_Drawer_Layout);
        NavigationUI.setupWithNavController(HomeNavigationView,navController);

        HomeNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_home_host_fragment),Home_Drawer_Layout) || super.onSupportNavigateUp();
    }
    @Override
    public void onBackPressed() {
        if (Home_Drawer_Layout.isDrawerOpen(GravityCompat.START)) {
            Home_Drawer_Layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Home_Drawer_Layout.close();
        int Selected_item = item.getItemId();
        switch (Selected_item)
        {
            case R.id.singin:
                navController.navigate(R.id.action_homeFrag_to_signInFrag);
                break;
            case R.id.signup:
                navController.navigate(R.id.action_homeFrag_to_signUpFrag);
                break;
            case R.id.cricketInfo:
                navController.navigate(R.id.action_homeFrag_to_cricket_info_Frag);
                break;
        }
        return false;
    }
}
