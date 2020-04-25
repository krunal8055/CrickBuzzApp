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
public class Matches_page_2 extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    public Matches_page_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matches_page_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.pager2);
        tabLayout = view.findViewById(R.id.tabLayout2);

        setFragmentPagerAdapter();
    }

    private void setFragmentPagerAdapter() {
        pagerAdapter = new PagerAdapter(getChildFragmentManager());
        pagerAdapter.AddFragment(new Live_Match_1(),"Live");
        pagerAdapter.AddFragment(new Upcoming_Match_2(),"Upcoming");
        pagerAdapter.AddFragment(new Recent_Match_3(),"Recent");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Live");
        tabLayout.getTabAt(1).setText("Upcoming");
        tabLayout.getTabAt(2).setText("Recent");
    }
}
