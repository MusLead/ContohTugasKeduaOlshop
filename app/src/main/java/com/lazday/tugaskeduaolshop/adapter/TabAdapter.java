package com.lazday.tugaskeduaolshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    //FRAGMENT
    List<Fragment> fragmentList = new ArrayList<>();
    //Titlenya
    List<String> stringList = new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }

    public CharSequence getPageTitle(int position){
        return stringList.get(position);
    }
}
