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

public class Add_NameActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__name;
    }

    private TextInputEditText edt_addName;
    private String name;
    @Override
    public void initView() {
        setTitle("Tên người dùng");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addName=findViewById(R.id.edt_addName);
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
                name=edt_addName.getText().toString().trim();
                if(name.equals("")){
                    Toast.makeText(this,"Không để trống dữ liệu",Toast.LENGTH_SHORT).show();
                } else {
                    Nguoidung.Nguoidung[1]=name;
                    openActivity(Add_PasswordActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
