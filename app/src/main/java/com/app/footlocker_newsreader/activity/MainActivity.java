package com.app.footlocker_newsreader.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.app.footlocker_newsreader.R;
import com.app.footlocker_newsreader.adapter.ViewPagerAdapter;
import com.app.footlocker_newsreader.fragment.BusinessNewsFragment;
import com.app.footlocker_newsreader.fragment.EntertainmentFragment;
import com.app.footlocker_newsreader.fragment.TopStoriesFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BusinessNewsFragment(), "Business");
        adapter.addFragment(new TopStoriesFragment(), "Top Stories");
        adapter.addFragment(new EntertainmentFragment(), "Entertainment");
        viewPager.setAdapter(adapter);
    }
}