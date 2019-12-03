package vn.fptpolytechnic.assignment;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import vn.fptpolytechnic.assignment.sqlite.Database;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager pager;
    Database database;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.view_paper);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);


        fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = new Database(MainActivity.this);
                if (pager.getCurrentItem() == 0) {
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_thu);

                    final EditText edt_khoanthu = dialog.findViewById(R.id.edtkhoanthu);
                    final EditText edt_loaithu = dialog.findViewById(R.id.edtloaithu);
                    Button btnvaothu = dialog.findViewById(R.id.btnvaothu);

                    btnvaothu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String a = edt_khoanthu.getText().toString();
                            String b = edt_loaithu.getText().toString();
                            String c = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

                            if (a.isEmpty() || b.isEmpty()) {
                                Toast.makeText(MainActivity.this, "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
                            } else {
                                database.sendData("INSERT INTO THU VALUES('" + c + "','" + a + "','" + b + "', NULL) ");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                pager.setAdapter(adapter);
                                pager.setCurrentItem(2);
                                Toast.makeText(MainActivity.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();

                } else if (pager.getCurrentItem() == 1){
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_chi);

                    final EditText edt_khoanchi = dialog.findViewById(R.id.edtkhoanchi);
                    final EditText edt_loaichi = dialog.findViewById(R.id.edtloaichi);
                    Button btnvaochi = dialog.findViewById(R.id.btnvaochi);

                    btnvaochi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String a = edt_khoanchi.getText().toString();
                            String b = edt_loaichi.getText().toString();
                            String c = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

                            if (a.isEmpty() || b.isEmpty()) {
                                Toast.makeText(MainActivity.this, "Vui lòng không để trống", Toast.LENGTH_SHORT).show();
                            } else {
                                database.sendData("INSERT INTO CHI VALUES('" + c + "','" + a + "','" + b + "', NULL) ");
                                PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
                                pager.setAdapter(adapter);
                                Toast.makeText(MainActivity.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                }


            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_khoanthu) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
            fab.show();
            // Handle the camera action
        } else if (id == R.id.nav_khoanchi) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
            fab.show();
        } else if (id == R.id.nav_thongke) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
            fab.hide();
        } else if (id == R.id.nav_gioithieu) {
            PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
            fab.hide();
        } else if (id == R.id.nav_chiase){

        }
        else if (id == R.id.nav_thoat) {
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
