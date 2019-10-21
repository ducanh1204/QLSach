package vn.edu.poly.qlsach.SachBanChay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachAdapter;
import vn.edu.poly.qlsach.Sach.SachDAO;

public class SachBanChayActivity extends BaseActivity {
    private RecyclerView rvList;
    private SachAdapter sachAdapter;
    private List<Sach> sachList;
    private SachDAO sachDAO;

    @Override
    public int setLayout() {
        return R.layout.activity_sach_ban_chay;
    }

    @Override
    public void initView() {
        setTitle("Sách bán chạy");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvList = findViewById(R.id.rvList);
        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
        sachAdapter = new SachAdapter(this, sachList);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvList.setLayoutManager(gridLayoutManager);
        rvList.setAdapter(sachAdapter);
    }
}
