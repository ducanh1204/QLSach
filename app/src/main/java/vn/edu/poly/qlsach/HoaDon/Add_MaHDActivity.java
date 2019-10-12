package vn.edu.poly.qlsach.HoaDon;


import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.Add_UsernameActivity;
import vn.edu.poly.qlsach.R;

public class Add_MaHDActivity extends BaseActivity {
    @Override
    public int setLayout() {
        return R.layout.activity_add__ma_hd;
    }

    private String maHD;
    private TextInputEditText edt_addMaHD;

    @Override
    public void initView() {
        setTitle("Mã hóa đơn");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addMaHD = findViewById(R.id.edt_addMaHD);

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
                maHD = edt_addMaHD.getText().toString().trim();
                if (maHD.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Hoadon.Hoadon[0] = maHD;
                    openActivity(Add_dateHDActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

