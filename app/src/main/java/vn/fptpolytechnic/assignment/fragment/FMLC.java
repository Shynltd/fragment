package vn.fptpolytechnic.assignment.fragment;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.fptpolytechnic.assignment.R;
import vn.fptpolytechnic.assignment.adapter.LoaiChiAdapter;
import vn.fptpolytechnic.assignment.model.khoanthu;
import vn.fptpolytechnic.assignment.model.loaichi;
import vn.fptpolytechnic.assignment.sqlite.Database;


public class FMLC extends Fragment {
    @Override
    public void onStart(){super.onStart();}

    public FMLC() {
        // Required empty public constructor
    }

    private  View rootview;
    LoaiChiAdapter adapter;
    ArrayList<loaichi> list;
    ListView lv_loaichi;
    Database database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_loai_chi, container, false);
        initView();
        return rootview;
    }

    public void initView(){
        database = new Database(getActivity());
        lv_loaichi = rootview.findViewById(R.id.lv_loaichi);
        list = new ArrayList<>();
        adapter = new LoaiChiAdapter(getActivity(), R.layout.list_item_loai_chi, list);
        Cursor dataloaichi = database.getData("SELECT * FROM CHI");
        list.clear();

        while (dataloaichi.moveToNext()){
            String a = dataloaichi.getString(2);
            int b = dataloaichi.getInt(3);
            list.add(new loaichi(a,b));
        }

        adapter.notifyDataSetChanged();
        lv_loaichi.setAdapter(adapter);
    }
}
