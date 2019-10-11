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

public class Add_TacGiaActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add__tac_gia;
    }

    private String tacGia;
    private TextInputEditText edt_addTacGia;

    @Override
    public void initView() {
        setTitle("Tác giả");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addTacGia = findViewById(R.id.edt_addTacGia);

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
                tacGia = edt_addTacGia.getText().toString().trim();
                if (tacGia.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[3] = tacGia;
                    openActivity(Add_NXBSachActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
