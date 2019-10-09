package vn.edu.poly.qlsach.SachBanChay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachAdapter;

public class SachBanChayActivity extends BaseActivity {
    RecyclerView rvList;
    SachAdapter sachAdapter;
    List<Sach> sachList;

    @Override
    public int setLayout() {
        return R.layout.activity_sach_ban_chay;
    }

    @Override
    public void initView() {
        setTitle("Sách bán chạy");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvList = findViewById(R.id.rvList);

        sachList = new ArrayList<>();
        for(int i=0;i<10;i++){
            sachList.add(new Sach("Người nam châm","s006","Android cơ bản","ducanh","ducanh",200,"100000"));
        }
        sachAdapter = new SachAdapter(this,sachList);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rvList.setLayoutManager(gridLayoutManager);
        rvList.setAdapter(sachAdapter);
    }
}
