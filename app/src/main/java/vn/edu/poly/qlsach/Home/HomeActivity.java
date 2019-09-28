package vn.edu.poly.qlsach.Home;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import vn.edu.poly.qlsach.Login.LoginActivity;
import vn.edu.poly.qlsach.NguoiDung.NguoiDungActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSach;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSashActivity;

public class HomeActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        setTitle("Quản lý Sách");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_ql_nguoidung) {
            openActivity(NguoiDungActivity.class);
        } else if (id == R.id.menu_ql_theloai) {
            openActivity(TheLoaiSashActivity.class);
        } else if (id == R.id.menu_dangxuat) {
            openActivity(LoginActivity.class);
        }
        return super.onOptionsItemSelected(item);
    }
}


