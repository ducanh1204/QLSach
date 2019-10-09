package vn.edu.poly.qlsach.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongtinHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thongtin_hdct;
    }

    @Override
    public void initView() {

        setTitle("Thông tin hóa chi tiết");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.check_menu){
            openActivity(HDCTActivity.class);
        }
        return super.onOptionsItemSelected(item);
    }
}
