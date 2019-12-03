package vn.fptpolytechnic.assignment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        switch (i){
            case 0:
                fragment = new fragment2();
                break;
            case 1:
                fragment = new fragment3();
                break;
            case 2:
                fragment = new fragment1();
                break;
            case 3:
                fragment = new GioiThieuActivity();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
