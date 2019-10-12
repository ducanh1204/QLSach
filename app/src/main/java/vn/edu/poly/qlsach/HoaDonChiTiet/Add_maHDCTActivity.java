package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class Add_maHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add_ma_hdct;
    }

    private String maHDCT;
    private TextInputEditText edt_addMaHDCT;

    @Override
    public void initView() {
        setTitle("Mã hóa đơn chi tiết");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addMaHDCT = findViewById(R.id.edt_addMaHDCT);

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
                maHDCT = edt_addMaHDCT.getText().toString().trim();
                if (maHDCT.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    HDCT.HDCT[0] = maHDCT;
                    HDCT.HDCT[1] = HDCTActivity.maHD;
                    openActivity(Add_maSach_HDCTActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
