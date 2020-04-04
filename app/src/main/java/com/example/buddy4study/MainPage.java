package com.example.buddy4study;

import android.service.dreams.DreamService;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;


public class MainPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle =  new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id = menuItem.getItemId();

            switch (id){
                case R.id.inbox_id:
                    Toast.makeText(getApplicationContext(), "Inbox", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.started_id:
                    Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_SHORT).show();

                    break;
                case  R.id.drafts_id:
                    Toast.makeText(getApplicationContext(), "Drafts", Toast.LENGTH_SHORT).show();

                    break;
                case  R.id.sent_id:
                    Toast.makeText(getApplicationContext(), "Sent Mail", Toast.LENGTH_SHORT).show();

                    break;
                case  R.id.spam_id:
                    Toast.makeText(getApplicationContext(), "Spam", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.allmail_id:
                    Toast.makeText(getApplicationContext(), "All Mail", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.trash_id:
                    Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_SHORT).show();

                    break;

            }
            drawerLayout.closeDrawer(GravityCompat.START);
        return  true;
    }
}
