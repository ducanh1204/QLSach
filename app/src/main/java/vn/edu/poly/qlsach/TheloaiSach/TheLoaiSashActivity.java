package vn.edu.poly.qlsach.TheloaiSach;


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

public class TheLoaiSashActivity extends BaseActivity {

    private RecyclerView rvList;
    private TheLoaiSachAdapter theLoaiSachAdapter;
    private List<TheLoaiSach> theLoaiSachList;
    private FloatingActionButton fab;

    private TheLoaiDAO theLoaiDAO;
    @Override
    public int setLayout() {
        return R.layout.activity_the_loai_sash;
    }

    @Override
    public void initView() {
        rvList = findViewById(R.id.rvListTheLoaiSach);
        theLoaiDAO = new TheLoaiDAO(this);
        theLoaiSachList = theLoaiDAO.getAll();

        theLoaiSachAdapter = new TheLoaiSachAdapter(this, theLoaiSachList);

        rvList.hasFixedSize();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        rvList.setAdapter(theLoaiSachAdapter);
        setTitle("Quản lý thể loại Sách");

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fab = findViewById(R.id.fabTheLoaiSach);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Add_MaTLActivity.class);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
