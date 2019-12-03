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
import vn.fptpolytechnic.assignment.adapter.LoaiThuAdapter;
import vn.fptpolytechnic.assignment.model.khoanthu;
import vn.fptpolytechnic.assignment.model.khoanthu;
import vn.fptpolytechnic.assignment.model.loaithu;
import vn.fptpolytechnic.assignment.sqlite.Database;


public class FMLT extends Fragment {

    @Override
    public void onStart(){super.onStart();}

    public FMLT() {
        // Required empty public constructor
    }

    private  View rootview;
    LoaiThuAdapter adapter;
    ArrayList<loaithu> list;
    ListView lv_loaithu;
    Database database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_loai_thu, container, false);
        initView();
        return rootview;
    }

    public void initView(){
        database = new Database(getActivity());
        lv_loaithu = rootview.findViewById(R.id.lv_loaithu);
        list = new ArrayList<>();
        adapter = new LoaiThuAdapter(getActivity(), R.layout.list_item_loai_thu, list);
        Cursor dataloaithu = database.getData("SELECT * FROM THU");
        list.clear();

        while (dataloaithu.moveToNext()){
            String a = dataloaithu.getString(2);
            int b = dataloaithu.getInt(3);
            list.add(new loaithu(a,b));
        }

        adapter.notifyDataSetChanged();
        lv_loaithu.setAdapter(adapter);
    }

}
