package com.example.crickbuzzapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.pager);
        tabLayout = view.findViewById(R.id.tabLayout);

        setFragmentPagerAdapter();
    }

    private void setFragmentPagerAdapter() {
        pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.AddFragment(new Home_page_1(),"Home");
        pagerAdapter.AddFragment(new Matches_page_2(),"Matches");
        pagerAdapter.AddFragment(new Videos_page_3(),"Video");
        pagerAdapter.AddFragment(new News_page_4(),"News");
        pagerAdapter.AddFragment(new More_page_5(),"More");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Home").setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setText("Matches").setIcon(R.drawable.cricket_bat);
        tabLayout.getTabAt(2).setText("Videos").setIcon(R.drawable.video_icon);
        tabLayout.getTabAt(3).setText("News").setIcon(R.drawable.news_icon);
        tabLayout.getTabAt(4).setText("More").setIcon(R.drawable.more_icon);

    }
}
