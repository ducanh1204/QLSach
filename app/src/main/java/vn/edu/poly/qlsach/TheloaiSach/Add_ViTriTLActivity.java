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

public class Add_ViTriTLActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__vi_tri_tl;
    }

    private String vitri;
    private TextInputEditText edt_addVitri;

    @Override
    public void initView() {
        setTitle("Vị trí thể loại Sách");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addVitri = findViewById(R.id.edt_addVitri);
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
                vitri = edt_addVitri.getText().toString().trim();
                if (vitri.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    TheLoaiSach.TheLoai[2] = vitri;
                    openActivity(Add_MotaTLActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
