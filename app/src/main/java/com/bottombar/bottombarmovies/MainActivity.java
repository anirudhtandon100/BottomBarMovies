package com.bottombar.bottombarmovies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private NonSwipeableViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();



//        loadFragment(new Tab1());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        toolbar.setTitle("Most Popular");
        mViewPager.setPagingEnabled(false);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar.setTitle("Most Popular");
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_gifts:
                    toolbar.setTitle("Top Rated");
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Upcoming");
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: Tab1 tab1 = new Tab1();
                    return tab1;
                case 1: Tab2 tab2 = new Tab2();
                    return tab2;
                case 2: Tab3 tab3 = new Tab3();
                    return tab3;

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Most Popular";
                case 1:
                    return "High Rated";


            }
            return null;
        }
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();
    }

}



