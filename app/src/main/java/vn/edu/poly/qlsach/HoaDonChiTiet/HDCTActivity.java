package vn.edu.poly.qlsach.HoaDonChiTiet;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class HDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_hdct;
    }

    private RecyclerView rvListHDCT;
    private FloatingActionButton fabHDCT;

    private List<HDCT> hdctList;

    private HDCTAdapter hdctAdapter;

    private HDCTDAO hdctdao;

    private String maHD;

    @Override
    public void initView() {
        rvListHDCT = findViewById(R.id.rvListHDCT);
        fabHDCT = findViewById(R.id.fabHDCT);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Danh sách hóa đơn chi tiết");
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MAHD");
        maHD = bundle.getString("maHD");
        hdctdao = new HDCTDAO(this);

        hdctList = hdctdao.show_HDCT(maHD);

        hdctAdapter = new HDCTAdapter(this, hdctList);
        rvListHDCT.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListHDCT.setLayoutManager(linearLayoutManager);
        rvListHDCT.setAdapter(hdctAdapter);


        fabHDCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Add_maHDCTActivity.class);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_view, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
