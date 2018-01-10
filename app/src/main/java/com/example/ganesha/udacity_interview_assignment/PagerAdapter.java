package com.example.ganesha.udacity_interview_assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Ganesha on 1/9/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
ArrayList<Card> arrayList=new ArrayList<Card>();
    public PagerAdapter(FragmentManager fm,ArrayList<Card> arrayList) {
        super(fm);
        this.arrayList=arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment detailFragment=new DetailFragment();
        Bundle bundle=new Bundle();
        bundle.putString("lastname",arrayList.get(position).getLastname());
        bundle.putString("firstname",arrayList.get(position).getFirstname());
        bundle.putString("email",arrayList.get(position).getEmail());
        bundle.putString("company",arrayList.get(position).getCompany());
        bundle.putString("startDate",arrayList.get(position).getStartdate());
        bundle.putString("bio",arrayList.get(position).getBio());
        bundle.putString("imageurl",arrayList.get(position).getImageurl());
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
