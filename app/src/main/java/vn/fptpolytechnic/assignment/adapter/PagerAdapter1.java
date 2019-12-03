package vn.fptpolytechnic.assignment.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import vn.fptpolytechnic.assignment.fragment.FMKT;
import vn.fptpolytechnic.assignment.fragment.FMLT;

public class PagerAdapter1 extends FragmentStatePagerAdapter {

    public PagerAdapter1(FragmentManager fm) { super(fm);}

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return new FMKT();
        } else if (i == 1){
            return new FMLT();
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
                return "Khoản thu";
            case 1:
                return "Loại thu";
        }
        return null;
    }
}
