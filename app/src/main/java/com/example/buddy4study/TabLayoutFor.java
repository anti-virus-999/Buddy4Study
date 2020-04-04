package com.example.buddy4study;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import  android.support.design.widget.TabLayout;

import com.example.buddy4study.Tab_item.One;
import com.example.buddy4study.Tab_item.Three;
import com.example.buddy4study.Tab_item.Two;
import com.example.buddy4study.Tab_item.ViewPagerAdapter;

public class TabLayoutFor extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        ViewPagerAdapter viewPagerAdapter =  new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new One(),"One");
        viewPagerAdapter.addFragment(new Two(),"Two");
        viewPagerAdapter.addFragment(new Three(),"Three");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        tabLayout.setupWithViewPager(viewPager);




    }


}
