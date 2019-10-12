package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachAdapter;
import vn.edu.poly.qlsach.Sach.SachDAO;

public class Add_maSach_HDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add_ma_sach__hdct;
    }

    private Spinner spn_maSach_hdct;
    private MaSach_SpinnerAdapter maSach_spinnerAdapter;
    private SachDAO sachDAO;
    private String maSach;
    private List<Sach> sachList;

    @Override
    public void initView() {
        setTitle("Chọn mã Sách");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        spn_maSach_hdct = findViewById(R.id.spn_maSach_hdct);
        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
        maSach_spinnerAdapter = new MaSach_SpinnerAdapter(this, sachList);
        spn_maSach_hdct.setAdapter(maSach_spinnerAdapter);
        spn_maSach_hdct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Sach sach = sachList.get(position);
                maSach = sach.getMaSach();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
                HDCT.HDCT[2] = maSach;
                openActivity(Add_Soluong_HDCTActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
