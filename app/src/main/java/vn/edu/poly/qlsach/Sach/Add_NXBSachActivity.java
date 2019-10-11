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

public class Add_NXBSachActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__nxbsach;
    }

    private String NXB;
    private TextInputEditText edt_addNXB;
    @Override
    public void initView() {
        setTitle("NXB Sách");
        Drawable drawable= getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addNXB=findViewById(R.id.edt_addNXB);

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
                NXB = edt_addNXB.getText().toString().trim();
                if (NXB.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[4] = NXB;
                    openActivity(Add_SoLuongSachActivity.class);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
