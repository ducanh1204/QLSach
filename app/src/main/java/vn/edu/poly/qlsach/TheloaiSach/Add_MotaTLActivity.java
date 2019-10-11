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

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.NguoiDung.ThongTinNguoiDungActivity;
import vn.edu.poly.qlsach.R;

public class Add_MotaTLActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__mota_tl;
    }

    private String moTa;
    private TextInputEditText edt_addMoTa;
    private TheLoaiDAO theLoaiDAO;
    private TheLoaiSachAdapter theLoaiSachAdapter;
    private List<TheLoaiSach> theLoaiSachList;
    private TheLoaiSach theLoaiSach;
    private int position;

    @Override
    public void initView() {
        setTitle("Mô tả thể loại Sách");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addMoTa = findViewById(R.id.edt_addMota);
        theLoaiDAO = new TheLoaiDAO(this);
        theLoaiSachList = theLoaiDAO.getAll();
        theLoaiSachAdapter = new TheLoaiSachAdapter(this, theLoaiSachList);
        position = theLoaiSachList.size();
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
                moTa = edt_addMoTa.getText().toString().trim();
                theLoaiSach = new TheLoaiSach();
                if (moTa.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    TheLoaiSach.TheLoai[3] = moTa;
                    theLoaiSach.setMaTheLoai(TheLoaiSach.TheLoai[0]);
                    theLoaiSach.setTenTheLoai(TheLoaiSach.TheLoai[1]);
                    theLoaiSach.setVitri(Integer.parseInt(TheLoaiSach.TheLoai[2]));
                    theLoaiSach.setMoTa(TheLoaiSach.TheLoai[3]);
                    long result = theLoaiDAO.insertTLSach(theLoaiSach);
                    if (result > 0) {
                        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        theLoaiSachList.add(theLoaiSach);
                        theLoaiSachAdapter.showInforTL(position);
                    } else {
                        Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}