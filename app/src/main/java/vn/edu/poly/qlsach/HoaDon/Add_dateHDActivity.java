package vn.edu.poly.qlsach.HoaDon;


import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.ThongTinNguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class Add_dateHDActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_add_date_hd;
    }

    private TextInputEditText edt_addNgayMua;
    private Hoadon hoadon;
    private HoaDonDAO hoaDonDAO;
    private HoaDonAdapter hoaDonAdapter;
    private List<Hoadon> hoadonList;
    private int position;

    @Override
    public void initView() {
        setTitle("Ngày mua");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addNgayMua = findViewById(R.id.edt_addNgayMua);
        hoaDonDAO = new HoaDonDAO(this);
        hoadonList = hoaDonDAO.getAll();
        hoaDonAdapter = new HoaDonAdapter(this, hoadonList);
        position = hoadonList.size();
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
                if (edt_addNgayMua.getText().toString().trim().equals("")) {
                    Toast.makeText(this, "Chọn ngày mua", Toast.LENGTH_SHORT).show();

                } else {
                    Hoadon.Hoadon[1] = edt_addNgayMua.getText().toString().trim();
                    hoadon = new Hoadon();
                    hoadon.setMaHoaDon(Hoadon.Hoadon[0]);
                    hoadon.setNgayMua(Hoadon.Hoadon[1]);
                    long result = hoaDonDAO.insertHD(hoadon);
                    if (result > 0) {
                        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        hoadonList.add(hoadon);
                        hoaDonAdapter.showInforHD(position);
                    } else {
                        Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
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
                edt_addNgayMua.setText(view.getDayOfMonth() + "/" + (view.getMonth() + 1) + "/" + view.getYear());
            }
        }, nam, thang, ngay);
        dialog.show();
    }
}
