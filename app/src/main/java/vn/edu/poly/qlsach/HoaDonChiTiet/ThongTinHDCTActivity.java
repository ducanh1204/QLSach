package vn.edu.poly.qlsach.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import vn.edu.poly.qlsach.HoaDon.HoaDonActivity;
import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.NguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_hdct;
    }

    @Override
    public void initView() {

        setTitle("Thông tin hóa đơn chi tiết");

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(HoaDonActivity.class);
        return super.onOptionsItemSelected(item);
    }

}
