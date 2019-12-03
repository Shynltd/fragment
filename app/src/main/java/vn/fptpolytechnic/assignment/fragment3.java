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
import vn.fptpolytechnic.assignment.adapter.PagerAdapter2;


public class fragment3 extends Fragment {

    public fragment3() {
    }

    private View rootview;

    TabLayout tl;
    PagerAdapter2 pagerAdapter;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment3, container, false);
        initView();
        return rootview;
    }

    public void initView() {

        viewPager = rootview.findViewById(R.id.view_paper2);
        tl = rootview.findViewById(R.id.tab_layout2);

        pagerAdapter = new PagerAdapter2(getActivity().getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tl.setupWithViewPager(viewPager);

    }

}
