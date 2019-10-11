package vn.edu.poly.qlsach.NguoiDung;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class Add_PasswordActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__password;
    }

    private String pass1, pass2;
    private TextInputEditText edt_addPass1, edt_addPass2;

    @Override
    public void initView() {
        setTitle("Mật khẩu");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addPass1 = findViewById(R.id.edt_addPass1);
        edt_addPass2 = findViewById(R.id.edt_addPass2);
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
                pass1 = edt_addPass1.getText().toString().trim();
                pass2 = edt_addPass2.getText().toString().trim();
                if (pass1.equals("") || pass2.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else if (pass1.length() < 6) {
                    Toast.makeText(this, "Mật khẩu yếu", Toast.LENGTH_SHORT).show();
                } else if (!pass2.equals(pass1)) {
                    Toast.makeText(this, "Mật khẩu không khớp nhau", Toast.LENGTH_SHORT).show();
                } else {
                    Nguoidung.Nguoidung[2] = pass2;
                    openActivity(Add_PhoneActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
