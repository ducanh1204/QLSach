package vn.edu.poly.qlsach.NguoiDung;

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
import vn.edu.poly.qlsach.R;

public class Add_PhoneActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add__phone;
    }

    private String phone;
    private TextInputEditText edt_addPhone;

    @Override
    public void initView() {
        setTitle("Số điện thoại");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addPhone = findViewById(R.id.edt_addPhone);
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
                phone = edt_addPhone.getText().toString().trim();
                if (phone.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 10) {
                    Toast.makeText(this, "Số điện thoại đúng 10 số", Toast.LENGTH_SHORT).show();
                } else {
                    Nguoidung.Nguoidung[3] = phone;
                    openActivity(Add_AddressActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
