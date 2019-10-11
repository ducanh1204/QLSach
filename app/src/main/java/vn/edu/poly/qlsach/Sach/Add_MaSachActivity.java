package vn.edu.poly.qlsach.Sach;


import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.Add_TenTLActivity;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSach;

public class Add_MaSachActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__ma_sach;
    }

    private String maSach;
    private TextInputEditText edt_addMaSach;
    @Override
    public void initView() {
        setTitle("Mã Sách");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addMaSach=findViewById(R.id.edt_addMaSach);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.next_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.next_menu:
                maSach = edt_addMaSach.getText().toString().trim();
                if (maSach.equals("")){
                    Toast.makeText(this,"Không để trống dữ liệu",Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[0]=maSach;
                    openActivity(Add_maTLSachActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}