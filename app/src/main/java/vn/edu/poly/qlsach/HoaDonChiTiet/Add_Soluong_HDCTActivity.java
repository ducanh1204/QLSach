package vn.edu.poly.qlsach.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.ThongTinNguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class Add_Soluong_HDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__soluong__hdct;
    }
    @Override
    public void initView() {
        setTitle("Nhập số lượng");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(ThongTinHDCTActivity.class);
        return super.onOptionsItemSelected(item);
    }
}