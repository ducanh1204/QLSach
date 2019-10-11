package vn.edu.poly.qlsach.TheloaiSach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.NguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinTheLoaiActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_the_loai;
    }

    private TextInputEditText edtmaTL, edttenTL, edtvitri, edtmota;
    private String maTL, tenTL, vitri, mota;
    private TheLoaiSach theLoaiSach;

    private TheLoaiDAO theLoaiDAO;

    @Override
    public void initView() {
        setTitle("Thông tin thể loại");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtmaTL = findViewById(R.id.edt_maTL);
        edttenTL = findViewById(R.id.edt_tenTL);
        edtvitri = findViewById(R.id.edt_vitriTL);
        edtmota = findViewById(R.id.edt_motaTL);
        theLoaiSach = new TheLoaiSach();
        theLoaiDAO = new TheLoaiDAO(this);


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("TLSach");
        edtmaTL.setText(bundle.getString("maTL"));
        edttenTL.setText(bundle.getString("tenTL"));
        edtvitri.setText(bundle.getString("vitri"));
        edtmota.setText(bundle.getString("mota"));


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


            maTL = edtmaTL.getText().toString().trim();
            tenTL = edttenTL.getText().toString().trim();
            vitri = edtvitri.getText().toString().trim();
            mota = edtmota.getText().toString().trim();

            theLoaiSach.setMaTheLoai(maTL);
            theLoaiSach.setTenTheLoai(tenTL);
            try {
                theLoaiSach.setVitri(Integer.parseInt(vitri));
            } catch (Exception e) {

            }
            theLoaiSach.setMoTa(mota);
            if (maTL.equals("") || tenTL.equals("") || mota.equals("") || vitri.equals("")) {
                Toast.makeText(this, "Không bỏ trống dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                long result = theLoaiDAO.updateTLSach(theLoaiSach);
                if (result > 0) {
                    openActivity(TheLoaiSashActivity.class);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

}