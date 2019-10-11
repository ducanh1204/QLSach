package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class Add_maHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add_ma_hdct;
    }

    @Override
    public void initView() {
        setTitle("Mã hóa đơn chi tiết");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.next_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next_menu:
                openActivity(Add_maSach_HDCTActivity.class);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
