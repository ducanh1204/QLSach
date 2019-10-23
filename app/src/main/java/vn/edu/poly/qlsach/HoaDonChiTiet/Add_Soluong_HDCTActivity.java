package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import vn.edu.poly.qlsach.Home.BaseActivity;
import vn.edu.poly.qlsach.R;
import vn.edu.poly.qlsach.Sach.Sach;
import vn.edu.poly.qlsach.Sach.SachDAO;

public class Add_Soluong_HDCTActivity extends BaseActivity {

    @Override
    public int setLayout() {
        return R.layout.activity_add__soluong__hdct;
    }

    private String soLuong;
    private TextInputEditText edt_addSoluong_hdct;
    private HDCTDAO hdctdao;
    private HDCTAdapter hdctAdapter;
    private List<HDCT> hdctList;
    private int position;
    private HDCT hdct;
    private int slSach;
    private SachDAO sachDAO;
    private List<Sach> sachList;

    @Override
    public void initView() {
        setTitle("Nhập số lượng");
        Drawable drawable = getResources().getDrawable(R.drawable.close_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable);
        edt_addSoluong_hdct = findViewById(R.id.edt_addSoluong_hdct);
        hdctdao = new HDCTDAO(this);
        hdctList = hdctdao.show_HDCT(HDCTActivity.maHD);
        hdctAdapter = new HDCTAdapter(this, hdctList);
        position = hdctList.size();
        sachDAO = new SachDAO(this);
        sachList = sachDAO.getAll();
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
                soLuong = edt_addSoluong_hdct.getText().toString().trim();
                for (int i = 0; i < sachList.size(); i++) {
                    if (sachList.get(i).getMaSach().equals(HDCT.HDCT[2])) {
                        slSach = sachList.get(i).getSoLuong();
                    }
                }
                if (soLuong.equals("")) {
                    Toast.makeText(this, "Không để trống dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(soLuong) > slSach) {
                        Toast.makeText(this, "Sách này tối đa chỉ còn " + slSach + " quyển, mời nhập lại", Toast.LENGTH_SHORT).show();
                    } else {
                        HDCT.HDCT[3] = soLuong;
                        hdct = new HDCT();
                        hdct.setMaHDCT(HDCT.HDCT[0]);
                        hdct.setMaHD(HDCT.HDCT[1]);
                        hdct.setMaSach(HDCT.HDCT[2]);
                        hdct.setSoLuong(Integer.parseInt(HDCT.HDCT[3]));
                        long result = hdctdao.insertHDCT(hdct);
                        if (result > 0) {
                            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                            hdctList.add(hdct);
                            hdctAdapter.notifyDataSetChanged();
                            hdctAdapter.showInforHDCT(position);
                        } else {
                            Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}