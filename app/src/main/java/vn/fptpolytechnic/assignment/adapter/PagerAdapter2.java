package vn.fptpolytechnic.assignment.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.fptpolytechnic.assignment.fragment.FMKC;
import vn.fptpolytechnic.assignment.fragment.FMKT;
import vn.fptpolytechnic.assignment.fragment.FMLC;
import vn.fptpolytechnic.assignment.fragment.FMLT;

public class PagerAdapter2 extends FragmentStatePagerAdapter {

    public PagerAdapter2(FragmentManager fm) { super(fm);}

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return new FMKC();
        } else if (i == 1){
            return new FMLC();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int i) {

        switch (i){
            case 0:
                return "Khoản chi";
            case 1:
                return "Loại chi";
        }
        return null;
    }
}
