package vn.edu.poly.qlsach.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongtinHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thongtin_hdct;
    }

    private String maHD;

    @Override
    public void initView() {

        setTitle("Thông tin hóa chi tiết");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MA_HD");
        maHD = bundle.getString("MA_HD");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.intent_maHD();
                return true;
            case R.id.check_menu:
                this.intent_maHD();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void intent_maHD(){
        Intent intent = new Intent(this, HDCTActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("maHD", maHD);
        intent.putExtra("MAHD", bundle);
        startActivity(intent);
    }
}
