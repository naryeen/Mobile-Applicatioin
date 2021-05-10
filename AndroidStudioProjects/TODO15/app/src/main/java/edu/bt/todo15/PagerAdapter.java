package edu.bt.todo15;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int numOfTab;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior){
        super(fm,behavior);
        numOfTab = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0 : return new FirstFragment();
            case 1 : return new SecondFragment();
            case 2 : return new ThirdFragment();
            default : return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTab;
    }


}
