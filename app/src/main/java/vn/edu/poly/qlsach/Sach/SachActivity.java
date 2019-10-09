package vn.edu.poly.qlsach.Sach;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class SachActivity extends BaseActivity {

    private RecyclerView rvList;
    private SachAdapter sachAdapter;
    private List<Sach> sachList;
    private FloatingActionButton fab;
    private SachDAO sachDAO;

    @Override
    public int setLayout() {
        return R.layout.activity_sach;
    }

    @Override
    public void initView() {
        setTitle("Quản lý Sách");
        rvList = findViewById(R.id.rvListSach);
        fab = findViewById(R.id.fabSach);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();

        sachAdapter = new SachAdapter(this, sachList);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvList.setLayoutManager(gridLayoutManager);
        rvList.setAdapter(sachAdapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Add_MaSachActivity.class);
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
