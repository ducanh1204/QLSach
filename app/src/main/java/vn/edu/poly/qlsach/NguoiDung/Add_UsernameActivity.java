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

public class Add_UsernameActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__username;
    }

    private TextInputEditText edt_addID;
    private String id;
    @Override
    public void initView() {
        setTitle("Tên đăng nhập");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addID = findViewById(R.id.edt_addID);
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
                id = edt_addID.getText().toString().trim();
                if(id.length()<6){
                    Toast.makeText(this,"Nhập ít nhất 6 ký tự",Toast.LENGTH_SHORT).show();
                } else {
                    Nguoidung.Nguoidung[0]=id;
                    openActivity(Add_NameActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
