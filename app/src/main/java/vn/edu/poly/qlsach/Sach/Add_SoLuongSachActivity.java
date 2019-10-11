package vn.edu.poly.qlsach.Sach;

import androidx.annotation.NonNull;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.Add_TenTLActivity;

public class Add_SoLuongSachActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__so_luong_sach;
    }

    private String soLuong;
    private TextInputEditText edt_addSoluong;
    @Override
    public void initView() {
        setTitle("Số lượng");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addSoluong=findViewById(R.id.edt_addSoluong);

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
                soLuong = edt_addSoluong.getText().toString().trim();
                if (soLuong.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[5] = soLuong;
                    openActivity(Add_GiaBiaActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
