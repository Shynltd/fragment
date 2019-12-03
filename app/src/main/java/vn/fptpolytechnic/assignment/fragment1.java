package vn.fptpolytechnic.assignment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import vn.fptpolytechnic.assignment.adapter.KhoanChiAdapter;
import vn.fptpolytechnic.assignment.adapter.ThongKeChiAdapter;
import vn.fptpolytechnic.assignment.adapter.ThongKeThuAdapter;
import vn.fptpolytechnic.assignment.model.khoanchi;
import vn.fptpolytechnic.assignment.model.thongkechi;
import vn.fptpolytechnic.assignment.model.thongkethu;
import vn.fptpolytechnic.assignment.sqlite.Database;

public class fragment1 extends Fragment {

    public fragment1() {
    }

    private View rootview;
    ArrayList<thongkechi> thongkechis;
    ArrayList<thongkethu> thongkethus;


    ThongKeChiAdapter thongKeChiAdapter;
    ThongKeThuAdapter thongKeThuAdapter;

    ListView lv_thongkechi, lv_thongkethu;
    Database database;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment1, container, false);
        initView();
        return rootview;
    }

    public void initView() {


        thongkechis = new ArrayList<>();
        lv_thongkechi = rootview.findViewById(R.id.lv_thongkechi);
        database = new Database(getActivity());

        thongKeChiAdapter = new ThongKeChiAdapter(getActivity(), R.layout.list_item_thong_ke_chi, thongkechis);
        Cursor datathongkechi = database.getData("SELECT * FROM CHI");
        thongkechis.clear();
        while(datathongkechi.moveToNext()){
            String a = datathongkechi.getString(0);
            String b = datathongkechi.getString(1);
            String c = datathongkechi.getString(2);
            thongkechis.add(new thongkechi(a,b,c));
        }
        thongKeChiAdapter.notifyDataSetChanged();
        lv_thongkechi.setAdapter(thongKeChiAdapter);

        // thu

        thongkethus = new ArrayList<>();
        lv_thongkethu = rootview.findViewById(R.id.lv_thongkethu);
        database = new Database(getActivity());

        thongKeThuAdapter = new ThongKeThuAdapter(getActivity(), R.layout.list_item_thong_ke_thu, thongkethus);
        Cursor datathongkethu = database.getData("SELECT * FROM THU");
        thongkethus.clear();
        while(datathongkethu.moveToNext()){
            String a = datathongkethu.getString(0);
            String b = datathongkethu.getString(1);
            String c = datathongkethu.getString(2);
            thongkethus.add(new thongkethu(a,b,c));
        }
        thongKeThuAdapter.notifyDataSetChanged();
        lv_thongkethu.setAdapter(thongKeThuAdapter);



    }

}
