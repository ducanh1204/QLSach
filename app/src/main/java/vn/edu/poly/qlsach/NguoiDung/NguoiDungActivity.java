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


   private RecyclerView rvList;
   private NguoiDungAdapter nguoiDungAdapter;
   private List<Nguoidung> nguoidungList;
   private FloatingActionButton fab;

   private NguoiDungDAO nguoiDungDAO;
    @Override
    public int setLayout() {
        return R.layout.activity_nguoi_dung;
    }

    @Override
    public void initView() {
        rvList=findViewById(R.id.rvListNguoidung);
        fab = findViewById(R.id.fabnguoiDung);
        nguoiDungDAO = new NguoiDungDAO(this);
        nguoidungList = nguoiDungDAO.getAll();

        nguoiDungAdapter = new NguoiDungAdapter(this,nguoidungList);


        rvList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);

        rvList.setAdapter(nguoiDungAdapter);

        setTitle("Quản lý người dùng");

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(Add_UsernameActivity.class);
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
