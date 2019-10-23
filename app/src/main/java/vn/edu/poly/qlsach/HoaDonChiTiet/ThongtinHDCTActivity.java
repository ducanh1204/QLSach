package vn.edu.poly.qlsach.HoaDonChiTiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import vn.edu.poly.qlsach.HoaDon.Hoadon;
import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachActivity;
import vn.edu.poly.qlsach.Sach.SachDAO;

public class ThongtinHDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_thongtin_hdct;
    }

    private String maHD, maHDCT, maSach, soLuong;
    private TextInputEditText edtmaHDCT, edtsoLuongHDCT;
    private Spinner spnMaSach;
    private SachDAO sachDAO;
    private List<Sach> sachList;
    private MaSach_SpinnerAdapter maSach_spinnerAdapter;
    private HDCTDAO hdctdao;
    private int slSach;

    @Override
    public void initView() {
        edtmaHDCT = findViewById(R.id.edt_maHDCT);
        edtsoLuongHDCT = findViewById(R.id.edt_soLuongHDCT);
        spnMaSach = findViewById(R.id.spnmaSach);
        setTitle("Thông tin hóa chi tiết");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        hdctdao = new HDCTDAO(this);
        this.sachList();
        this.setSpinner();
        this.fillInfor();
        spnMaSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Sach sach = sachList.get(position);
                maSach = sach.getMaSach();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void sachList() {
        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
    }

    private void fillInfor() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("HDCT");
        maHD = bundle.getString("HDCT_maHD");
        edtmaHDCT.setText(bundle.getString("HDCT_maHDCT"));
        edtsoLuongHDCT.setText(bundle.getString("HDCT_soLuong"));
        maSach = bundle.getString("HDCT_maSach");
        for (int i = 0; i < sachList.size(); i++) {
            if (sachList.get(i).getMaSach().equals(maSach)) {
                spnMaSach.setSelection(i);
                break;
            }
        }
    }

    private void setSpinner() {
        maSach_spinnerAdapter = new MaSach_SpinnerAdapter(this, sachList);
        spnMaSach.setAdapter(maSach_spinnerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.check_menu:
                maHDCT = edtmaHDCT.getText().toString().trim();
                soLuong = edtsoLuongHDCT.getText().toString().trim();
                for (int i = 0; i < sachList.size(); i++) {
                    if (maSach.equals(sachList.get(i).getMaSach())) {
                        slSach = sachList.get(i).getSoLuong();
                    }
                }

                HDCT hdct = new HDCT();
                hdct.setMaHDCT(maHDCT);
                hdct.setMaHD(maHD);
                hdct.setMaSach(maSach);
                try {
                    hdct.setSoLuong(Integer.parseInt(soLuong));
                } catch (Exception e) {
                }
                if (maHDCT.equals("") || soLuong.equals("")) {
                    Toast.makeText(this, "Không bỏ trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if (slSach < Integer.parseInt(soLuong)) {
                        Toast.makeText(this, "Sách này tối đa chỉ còn " + slSach + " quyển, mời nhập lại", Toast.LENGTH_SHORT).show();
                    } else {
                        long result = hdctdao.updateHDCT(hdct);
                        if (result > 0) {
                            openActivity(HDCTActivity.class);
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
