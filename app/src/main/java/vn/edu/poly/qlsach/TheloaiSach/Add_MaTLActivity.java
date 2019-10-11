package vn.edu.poly.qlsach.TheloaiSach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.Add_UsernameActivity;
import vn.edu.poly.qlsach.R;

public class Add_MaTLActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__ma_tl;
    }
    private String maTL;
    private TextInputEditText edt_addMaTL;

    @Override
    public void initView() {
        setTitle("Mã thể loại");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addMaTL = findViewById(R.id.edt_addMaTL);
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
                maTL = edt_addMaTL.getText().toString().trim();
                if (maTL.equals("")){
                    Toast.makeText(this,"Không để trống dữ liệu",Toast.LENGTH_SHORT).show();
                } else {
                    TheLoaiSach.TheLoai[0]=maTL;
                    openActivity(Add_TenTLActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
