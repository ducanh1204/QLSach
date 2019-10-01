package vn.edu.poly.qlsach.Sach;


import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinSachActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_sach;
    }

    @Override
    public void initView() {

        setTitle("Thông tin Sách");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(SachActivity.class);
        return super.onOptionsItemSelected(item);
    }
}
