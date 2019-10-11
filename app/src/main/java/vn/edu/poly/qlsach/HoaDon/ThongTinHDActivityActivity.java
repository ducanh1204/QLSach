package vn.edu.poly.qlsach.HoaDon;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.NguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinHDActivityActivity extends BaseActivity {

    private TextInputEditText edtNgaymua, edtMaHD;
    private String maHD, ngayMua;
    private HoaDonDAO hoaDonDAO;
    private Hoadon hoadon;

    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_hd;
    }

    @Override
    public void initView() {
        setTitle("Thông tin hóa đơn");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        edtNgaymua = findViewById(R.id.edt_ngayMua);
        edtMaHD = findViewById(R.id.edt_maHD);
        hoaDonDAO = new HoaDonDAO(this);
        hoadon = new Hoadon();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("HD");
        edtMaHD.setText(bundle.getString("maHD"));
        edtNgaymua.setText(bundle.getString("ngayMua"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.check_menu) {
            maHD = edtMaHD.getText().toString().trim();
            ngayMua = edtNgaymua.getText().toString().trim();

            hoadon.setNgayMua(ngayMua);
            hoadon.setMaHoaDon(maHD);

            if (maHD.equals("") || ngayMua.equals("")) {
                Toast.makeText(this, "Không bỏ trống dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                long result = hoaDonDAO.updateHD(hoadon);
                if (result > 0) {
                    Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    openActivity(HoaDonActivity.class);
                } else {
                    Toast.makeText(this, "Cập nhật thất bạt", Toast.LENGTH_SHORT).show();
                }
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void CallDialog(View view) {
        Calendar calendar = Calendar.getInstance(); //khoi tao
        int nam = calendar.get(Calendar.YEAR);  //thiet lap ngay thang nam
        int thang = calendar.get(Calendar.MONTH);  //thiet lap ngay thang nam
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);  //thiet lap ngay thang nam
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edtNgaymua.setText(view.getDayOfMonth() + "/" + (view.getMonth() + 1) + "/" + view.getYear());
            }
        }, nam, thang, ngay);
        dialog.show();

    }

}
