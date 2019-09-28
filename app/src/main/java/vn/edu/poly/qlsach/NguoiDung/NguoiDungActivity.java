package vn.edu.poly.qlsach.NguoiDung;


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

public class NguoiDungActivity extends BaseActivity {


    RecyclerView rvList;
    NguoiDungAdapter nguoiDungAdapter;
    List<Nguoidung> nguoidungList;
    FloatingActionButton fab;
    @Override
    public int setLayout() {
        return R.layout.activity_nguoi_dung;
    }

    @Override
    public void initView() {

        rvList=findViewById(R.id.rvListNguoidung);
        nguoidungList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            nguoidungList.add(new Nguoidung("865012014","Đức Anh","ducanh","0355740828","Hải Dương"));
        }

        rvList.setHasFixedSize(true);
        nguoiDungAdapter = new NguoiDungAdapter(this,nguoidungList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        rvList.setAdapter(nguoiDungAdapter);

        setTitle("Quản lý người dùng");

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        fab = findViewById(R.id.fabnguoiDung);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
