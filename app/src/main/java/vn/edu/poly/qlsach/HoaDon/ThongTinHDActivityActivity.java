package vn.edu.poly.qlsach.HoaDon;


import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;

public class ThongTinHDActivityActivity extends BaseActivity {

    TextInputEditText editText;
    @Override
    public int setLayout() {
        return R.layout.activity_thong_tin_hd;
    }

    @Override
    public void initView() {
        setTitle("Thông tin hóa đơn");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        editText = findViewById(R.id.edt_ngayMua);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(HoaDonActivity.class);
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
                editText.setText(view.getYear() + "/" + view.getMonth() + "/" + view.getDayOfMonth());
            }
        }, nam, thang, ngay);
        dialog.show();

    }



}
