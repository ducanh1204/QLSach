package vn.edu.poly.qlsach.ThongKe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongKeActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thong_ke;
    }

    @Override
    public void initView() {

        setTitle("Thống kê");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
