package vn.edu.poly.qlsach.NguoiDung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class Add_PhoneActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add__phone;
    }

    @Override
    public void initView() {
        setTitle("Số điện thoại");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.next_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(Add_AddressActivity.class);
        return super.onOptionsItemSelected(item);
    }
}
