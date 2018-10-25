package com.example.demo.bott;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaolong on 2018/10/25.
 */

public class BottomAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public BottomAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }
    @Override
    public int getCount(){
        return fragments.size();
    }
    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }
}






























