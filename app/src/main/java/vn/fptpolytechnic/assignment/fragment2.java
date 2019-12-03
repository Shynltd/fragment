package vn.fptpolytechnic.assignment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import vn.fptpolytechnic.assignment.adapter.PagerAdapter1;


public class fragment2 extends Fragment {

    public fragment2() {
    }

    private View rootview;

    TabLayout tl;
    PagerAdapter1 pagerAdapter;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment2, container, false);
        initView();
        return rootview;
    }

    public void initView() {

        pagerAdapter = new PagerAdapter1(getActivity().getSupportFragmentManager());
        tl = rootview.findViewById(R.id.tab_layout1);
        viewPager = rootview.findViewById(R.id.view_paper1);
        viewPager.setAdapter(pagerAdapter);
        tl.setupWithViewPager(viewPager);
    }

}
