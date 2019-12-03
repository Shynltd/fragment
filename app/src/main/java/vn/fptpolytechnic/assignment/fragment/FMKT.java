package vn.fptpolytechnic.assignment.fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.fptpolytechnic.assignment.R;
import vn.fptpolytechnic.assignment.adapter.KhoanThuAdapter;
import vn.fptpolytechnic.assignment.model.khoanthu;
import vn.fptpolytechnic.assignment.sqlite.Database;


public class FMKT extends Fragment {

    @Override
    public void onStart(){super.onStart();}

    public FMKT() {
        // Required empty public constructor
    }

    private  View rootview;
    KhoanThuAdapter adapter;
    ArrayList<khoanthu> list;
    ListView lv_khoanthu;
    Database database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_khoan_thu, container, false);
        initView();
        return rootview;
    }

    public void initView(){
        database = new Database(getActivity());
        lv_khoanthu = rootview.findViewById(R.id.lv_khoanthu);
        list = new ArrayList<>();
        adapter = new KhoanThuAdapter(getActivity(), R.layout.list_item_khoan_thu, list);
        Cursor datakhoanthu = database.getData("SELECT * FROM THU");
        list.clear();

        while (datakhoanthu.moveToNext()){
            String a = datakhoanthu.getString(1);
            int b = datakhoanthu.getInt(3);
            list.add(new khoanthu(a,b));
        }

        adapter.notifyDataSetChanged();
        lv_khoanthu.setAdapter(adapter);
    }


}
