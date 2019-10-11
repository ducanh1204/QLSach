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

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class Add_AddressActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add__address;
    }

    private String diaChi;
    private TextInputEditText edt_addAddress;
    private Nguoidung nguoidung;
    private NguoiDungDAO nguoiDungDAO;

    private List<Nguoidung> nguoidungList;
    private int position;

    private NguoiDungAdapter nguoiDungAdapter;

    @Override
    public void initView() {
        setTitle("Địa chỉ");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addAddress = findViewById(R.id.edt_addAddress);
        nguoiDungDAO = new NguoiDungDAO(this);
        nguoidungList = nguoiDungDAO.getAll();
        nguoiDungAdapter = new NguoiDungAdapter(this, nguoidungList);
        position = nguoidungList.size();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.check_menu:
                diaChi = edt_addAddress.getText().toString().trim();
                nguoidung = new Nguoidung();
                if (diaChi.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Nguoidung.Nguoidung[4] = diaChi;
                    nguoidung.setId(Nguoidung.Nguoidung[0]);
                    nguoidung.setName(Nguoidung.Nguoidung[1]);
                    nguoidung.setPassword(Nguoidung.Nguoidung[2]);
                    nguoidung.setPhoneNumber(Nguoidung.Nguoidung[3]);
                    nguoidung.setAddress(Nguoidung.Nguoidung[4]);
                    long result = nguoiDungDAO.insertUser(nguoidung);
                    if (result > 0) {
                        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        nguoidungList.add(nguoidung);
                        nguoiDungAdapter.showInforUser(position);
                    } else {
                        Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}