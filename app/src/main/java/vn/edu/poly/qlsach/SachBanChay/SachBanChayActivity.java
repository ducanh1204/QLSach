package vn.edu.poly.qlsach.SachBanChay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class SachBanChayActivity extends BaseActivity {
    private RecyclerView rvList;
    private SachBanChayAdapter sachBanChayAdapter;
    private List<SachBanChay> sachBanChayList;
    private SachBanChayDAO sachBanChayDAO;

    @Override
    public int setLayout() {
        return R.layout.activity_sach_ban_chay;
    }

    @Override
    public void initView() {
        setTitle("Sách bán chạy");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvList = findViewById(R.id.rvList);
        sachBanChayDAO = new SachBanChayDAO(this);
        sachBanChayList = sachBanChayDAO.getAllSachBanChay();
        sachBanChayAdapter = new SachBanChayAdapter(this, sachBanChayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(sachBanChayAdapter);
    }
}
