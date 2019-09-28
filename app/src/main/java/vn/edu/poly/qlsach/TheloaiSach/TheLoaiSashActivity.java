package vn.edu.poly.qlsach.TheloaiSach;


import android.view.Menu;
import android.view.MenuInflater;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class TheLoaiSashActivity extends BaseActivity {

    RecyclerView rvList;
    TheLoaiSachAdapter theLoaiSachAdapter;
    List<TheLoaiSach> theLoaiSachList;
    @Override
    public int setLayout() {
        return R.layout.activity_the_loai_sash;
    }

    @Override
    public void initView() {
        rvList = findViewById(R.id.rvListTheLoaiSach);
        theLoaiSachList = new ArrayList<>();
        theLoaiSachAdapter = new TheLoaiSachAdapter(this,theLoaiSachList);

        for (int i=0;i<11;i++){
            theLoaiSachList.add(new TheLoaiSach("TL012","Tin học","hay",12));
        }

        rvList.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        rvList.setAdapter(theLoaiSachAdapter);
        setTitle("Quản lý thể loại Sách");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view,menu);
        return super.onCreateOptionsMenu(menu);
    }



}
