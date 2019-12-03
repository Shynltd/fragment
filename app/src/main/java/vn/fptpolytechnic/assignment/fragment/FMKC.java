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
import vn.fptpolytechnic.assignment.adapter.KhoanChiAdapter;
import vn.fptpolytechnic.assignment.model.khoanchi;
import vn.fptpolytechnic.assignment.sqlite.Database;

public class FMKC extends Fragment {
    @Override
    public void onStart(){super.onStart();}

    public FMKC() {
        // Required empty public constructor
    }

    private  View rootview;
    KhoanChiAdapter adapter;
    ArrayList<khoanchi> list;
    ListView lv_khoanchi;
    Database database;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_khoan_chi, container, false);
        initView();
        return rootview;
    }

    public void initView(){
        database = new Database(getActivity());
        lv_khoanchi = rootview.findViewById(R.id.lv_khoanchi);
        list = new ArrayList<>();
        adapter = new KhoanChiAdapter(getActivity(), R.layout.list_item_khoan_chi, list);
        Cursor datakhoanchi = database.getData("SELECT * FROM CHI");
        list.clear();

        while (datakhoanchi.moveToNext()){
            String a = datakhoanchi.getString(1);
            int b = datakhoanchi.getInt(3);
            list.add(new khoanchi(a,b));
        }

        adapter.notifyDataSetChanged();
        lv_khoanchi.setAdapter(adapter);
    }
}
