package vn.edu.poly.qlsach.Sach;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiDAO;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSach;
import vn.edu.poly.qlsach.TheloaiSach.TheLoaiSashActivity;

public class ThongTinSachActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_sach;
    }

    private SachDAO sachDAO;
    private TextInputEditText edtMa, edtTen, edtTacgia, edtNXB, edtSoluong, edtGia;
    private Spinner spnMaTL;
  private   String maSach, maTL, ten, tacgia, nxb, soluong, gia;
    private MaTL_SpinnerAdapter maTL_spinnerAdapter;
    private TheLoaiDAO theLoaiDAO;
    private List<TheLoaiSach> theLoaiSachList;

    private SachAdapter sachAdapter;
    private List<Sach> sachList;

    @Override
    public void initView() {
        setTitle("Thông tin Sách");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtMa = findViewById(R.id.edt_maSach);
        edtTen = findViewById(R.id.edt_tenSach);
        edtTacgia = findViewById(R.id.edt_tacGia);
        edtNXB = findViewById(R.id.edt_nxb);
        edtSoluong = findViewById(R.id.edt_soLuongSach);
        edtGia = findViewById(R.id.edt_gia);
        spnMaTL = findViewById(R.id.spnmaTL);


        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
        sachAdapter = new SachAdapter(this, sachList);

        theLoaiDAO = new TheLoaiDAO(this);
        theLoaiSachList = theLoaiDAO.getAll();
        maTL_spinnerAdapter = new MaTL_SpinnerAdapter(this, theLoaiSachList);
        spnMaTL.setAdapter(maTL_spinnerAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Sach");
        edtMa.setText(bundle.getString("ma"));
        edtTen.setText(bundle.getString("ten"));
        edtTacgia.setText(bundle.getString("tacgia"));
        edtSoluong.setText(bundle.getString("soluong"));
        edtNXB.setText(bundle.getString("nxb"));
        edtGia.setText(bundle.getString("gia"));
        maTL = bundle.getString("maTL");

        for (int i = 0; i < theLoaiSachList.size(); i++) {
            if (theLoaiSachList.get(i).getMaTheLoai().equals(maTL)) {
                spnMaTL.setSelection(i);
                break;
            }
        }

        spnMaTL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               TheLoaiSach theLoaiSach = theLoaiSachList.get(position);
                maTL = theLoaiSach.getMaTheLoai();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.check_menu) {
            maSach = edtMa.getText().toString().trim();
            ten = edtTen.getText().toString().trim();
            tacgia = edtTacgia.getText().toString().trim();
            nxb = edtNXB.getText().toString().trim();
            soluong = edtSoluong.getText().toString().trim();
            gia = edtGia.getText().toString().trim();


            Sach sach = new Sach();
            sach.setMaSach(maSach);
            sach.setMaTLSach(maTL);
            sach.setTenSach(ten);
            sach.setTacGia(tacgia);
            sach.setNxb(nxb);
            try {
                sach.setSoLuong(Integer.parseInt(soluong));
            } catch (Exception e) {

            }
            sach.setGiaBia(gia);
            if (maSach.equals("") || ten.equals("") || tacgia.equals("") || nxb.equals("") || soluong.equals("") || gia.equals("")) {
                Toast.makeText(this, "Không bỏ trống dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                long result = sachDAO.updateBook(sach);
                if (result > 0) {
                    Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    openActivity(SachActivity.class);
                } else {
                    Toast.makeText(this, "Cập nhật thất bạt", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
