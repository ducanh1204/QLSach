package vn.edu.poly.qlsach.NguoiDung;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinNguoiDungActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_nguoi_dung;
    }

    private TextInputEditText edtUsername, edtName, edtPass, edtPhone, edtAddress;

    private Nguoidung nguoidung;

    private NguoiDungDAO nguoiDungDAO;

    private String id, name, pass, phone, address;

    @Override
    public void initView() {
        setTitle("Thông tin người dùng");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtUsername = findViewById(R.id.edt_Username);
        edtName = findViewById(R.id.edt_name);
        edtPass = findViewById(R.id.edt_password);
        edtPhone = findViewById(R.id.edt_phone);
        edtAddress = findViewById(R.id.edt_address);
        nguoiDungDAO = new NguoiDungDAO(this);
        nguoidung = new Nguoidung();


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("User");
        edtUsername.setText(bundle.getString("id"));
        edtName.setText(bundle.getString("name"));
        edtPass.setText(bundle.getString("pass"));
        edtPhone.setText(bundle.getString("phone"));
        edtAddress.setText(bundle.getString("address"));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.check_menu) {

            id = edtUsername.getText().toString().trim();
            name = edtName.getText().toString().trim();
            pass = edtPass.getText().toString().trim();
            phone = edtPhone.getText().toString().trim();
            address = edtAddress.getText().toString().trim();

            nguoidung.setId(id);
            nguoidung.setName(name);
            nguoidung.setPhoneNumber(phone);
            nguoidung.setPassword(pass);
            nguoidung.setAddress(address);

            if (id.equals("") || name.equals("") || pass.equals("") || phone.equals("") || address.equals("")) {
                Toast.makeText(this, "Không bỏ trống dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                long result = nguoiDungDAO.updateUser(nguoidung);
                if (result > 0) {
                    Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    openActivity(NguoiDungActivity.class);
                } else {
                    Toast.makeText(this, "Cập nhật thất bạt", Toast.LENGTH_SHORT).show();
                }
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
