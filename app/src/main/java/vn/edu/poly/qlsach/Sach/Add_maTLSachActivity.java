package vn.edu.poly.qlsach.Sach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.Add_TenTLActivity;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiDAO;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSach;

public class Add_maTLSachActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add_ma_tlsach;
    }

    private String maTL;
    private Spinner spn_maTL;
    private List<TheLoaiSach> theLoaiSachList;
    private TheLoaiDAO theLoaiDAO;
    private MaTL_SpinnerAdapter maTL_spinnerAdapter;

    @Override
    public void initView() {
        setTitle("Chọn mã thể loại Sách");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        spn_maTL = findViewById(R.id.spn_maTL);
        theLoaiDAO = new TheLoaiDAO(this);
        theLoaiSachList = theLoaiDAO.getAll();
        maTL_spinnerAdapter = new MaTL_SpinnerAdapter(this, theLoaiSachList);
        spn_maTL.setAdapter(maTL_spinnerAdapter);
        spn_maTL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TheLoaiSach theLoaiSach = theLoaiSachList.get(position);
                maTL = theLoaiSach.getMaTheLoai();
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
                Sach.Sach[1] = maTL;
                openActivity(Add_TenSachActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}