package vn.edu.poly.qlsach.SachBanChay;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;

public class SachBanChayDAO {
    private MySqliteOpenHelper mySqliteOpenHelper;

    public SachBanChayDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    private String BOOK_TABLE = "Sach";

    public String MASACH = "maSach";
    public String MATL = "maTLSach";
    public String TENSACH = "tenSach";
    public String TACGIA = "tacGia";
    public String NXB = "nxb";
    public String SOLUONG = "soLuong";
    public String GIA = "giaBia";

    private String HDCT_TABLE = "HDCT";

    public String MA_HDCT = "maHDCT";
    public String MA_HD = "maHD";
    public String MA_SACH = "maSach";
    public String SO_LUONG = "soLuong";


    public List<SachBanChay> getAllSachBanChay() {
        List<SachBanChay> sachBanChayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT s.maSach , sum(h.soLuong) FROM Sach s JOIN HDCT h ON s.maSach=h.maSach GROUP BY h.maSach ORDER BY sum(h.soLuong) DESC ";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    SachBanChay sachBanChay = new SachBanChay();

                    sachBanChay.setMaSach(cursor.getString(cursor.getColumnIndex(MASACH)));
                    sachBanChay.setSoLuong(cursor.getInt(1));

                    sachBanChayList.add(sachBanChay);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return sachBanChayList;
    }
}
