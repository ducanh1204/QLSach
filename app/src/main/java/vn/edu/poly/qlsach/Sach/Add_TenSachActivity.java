package vn.edu.poly.qlsach.Sach;

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
import vn.edu.poly.qlsach.TheloaiSach.Add_TenTLActivity;

public class Add_TenSachActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add__ten_sach;
    }

    private String tenSach;
    private TextInputEditText edt_addTenSach;
    @Override
    public void initView() {
        setTitle("Tên Sách");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        findViewById(R.id.edt_addTenSach);
        edt_addTenSach=findViewById(R.id.edt_addTenSach);

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
                tenSach = edt_addTenSach.getText().toString().trim();
                if (tenSach.equals("")){
                    Toast.makeText(this,"Không để trống dữ liệu",Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[2]=tenSach;
                    openActivity(Add_TacGiaActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
