package vn.edu.poly.qlsach.NguoiDung;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinNguoiDungActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_nguoi_dung;
    }

    @Override
    public void initView() {

        setTitle("Thông tin người dùng");

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
        openActivity(NguoiDungActivity.class);
        return super.onOptionsItemSelected(item);
    }

}
