package vn.fptpolytechnic.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GioiThieuActivity extends Fragment {

    private TextView mTextMessage;

    private View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.activity_gioi_thieu, container, false);
        initView();
        return rootview;
    }

    private void initView(){
        mTextMessage = rootview.findViewById(R.id.message);
        BottomNavigationView navigationView = rootview.findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        mTextMessage.setText("Xin chào");
                        return true;
                    case R.id.navigation_dashboard:
                        SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
                        String a = f.format(Calendar.getInstance().getTime());
                        mTextMessage.setText(a);
                        return true;

                    case R.id.navigation_noti:
                        mTextMessage.setText("Hết mất tiu luôn ");
                        return true;
                }

                return false;
            }
        });
    }


}
