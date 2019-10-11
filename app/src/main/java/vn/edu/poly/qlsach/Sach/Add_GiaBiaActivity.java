package vn.edu.poly.qlsach.Sach;

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
import vn.edu.poly.qlsach.TheloaiSach.ThongTinTheLoaiActivity;

public class Add_GiaBiaActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__gia_bia;
    }

    private String gia;
    private TextInputEditText edt_addGiabia;
    private SachDAO sachDAO;
    private SachAdapter sachAdapter;
    private Sach sach;
    private List<Sach> sachList;
    private int position;

    @Override
    public void initView() {
        setTitle("Giá bìa");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addGiabia = findViewById(R.id.edt_addGiabia);
        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
        sachAdapter = new SachAdapter(this, sachList);
        position = sachList.size();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        openActivity(ThongTinSachActivity.class);
        switch (item.getItemId()) {
            case R.id.check_menu:
                gia = edt_addGiabia.getText().toString().trim();
                sach = new Sach();
                if (gia.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Sach.Sach[6] = gia;
                    sach.setMaSach(Sach.Sach[0]);
                    sach.setMaTLSach(Sach.Sach[1]);
                    sach.setTenSach(Sach.Sach[2]);
                    sach.setTacGia(Sach.Sach[3]);
                    sach.setNxb(Sach.Sach[4]);
                    sach.setSoLuong(Integer.parseInt(Sach.Sach[5]));
                    sach.setGiaBia(Sach.Sach[6]);
                    long result = sachDAO.inserBook(sach);
                    if (result > 0) {
                        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        sachList.add(sach);
                        sachAdapter.showInforBook(position);
                    } else {
                        Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
