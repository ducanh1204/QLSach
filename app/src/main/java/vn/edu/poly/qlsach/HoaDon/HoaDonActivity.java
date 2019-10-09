package vn.edu.poly.qlsach.HoaDon;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class HoaDonActivity extends BaseActivity {

    RecyclerView rvList;
    FloatingActionButton fab;
    HoaDonAdapter hoaDonAdapter;
    List<Hoadon> hoadonList;

    @Override
    public int setLayout() {
        return R.layout.activity_hoa_don;
    }

    @Override
    public void initView() {
        setTitle("Quản lý hóa đơn");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvList = findViewById(R.id.rvListHoadon);
        fab = findViewById(R.id.fabhoaDon);


        hoadonList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            hoadonList.add(new Hoadon("HD00" + (i + 1), "12-04-2019"));
        }
        hoaDonAdapter = new HoaDonAdapter(this, hoadonList);


        rvList.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(hoaDonAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Add_MaHDActivity.class);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
