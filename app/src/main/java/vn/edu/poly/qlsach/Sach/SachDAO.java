package vn.edu.poly.qlsach.Sach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;
import vn.edu.poly.qlsach.SachBanChay.SachBanChay;

public class SachDAO {

    private MySqliteOpenHelper mySqliteOpenHelper;

    public SachDAO(Context context) {
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

        String SQL = "SELECT s.maSach , sum(h.soLuong) FROM Sach s JOIN HDCT h ON s.maSach=h.maSach GROUP BY h.maSach ORDER BY h.soLuong DESC ";

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

    public List<Sach> getAll() {
        List<Sach> sachList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + BOOK_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Sach sach = new Sach();

                    sach.setMaSach(cursor.getString(cursor.getColumnIndex(MASACH)));
                    sach.setMaTLSach(cursor.getString(cursor.getColumnIndex(MATL)));
                    sach.setTenSach(cursor.getString(cursor.getColumnIndex(TENSACH)));
                    sach.setTacGia(cursor.getString(cursor.getColumnIndex(TACGIA)));
                    sach.setNxb(cursor.getString(cursor.getColumnIndex(NXB)));
                    sach.setSoLuong(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOLUONG))));
                    sach.setGiaBia(cursor.getString(cursor.getColumnIndex(GIA)));

                    sachList.add(sach);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return sachList;
    }

    public long inserBook(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MASACH, sach.getMaSach());
        contentValues.put(MATL, sach.getMaTLSach());
        contentValues.put(TENSACH, sach.getTenSach());
        contentValues.put(TACGIA, sach.getTacGia());
        contentValues.put(NXB, sach.getNxb());
        contentValues.put(SOLUONG, sach.getSoLuong());
        contentValues.put(GIA, sach.getGiaBia());

        long result = sqLiteDatabase.insert(BOOK_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateBook(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MASACH, sach.getMaSach());
        contentValues.put(MATL, sach.getMaTLSach());
        contentValues.put(TENSACH, sach.getTenSach());
        contentValues.put(TACGIA, sach.getTacGia());
        contentValues.put(NXB, sach.getNxb());
        contentValues.put(SOLUONG, sach.getSoLuong());
        contentValues.put(GIA, sach.getGiaBia());

        long result = sqLiteDatabase.update(BOOK_TABLE, contentValues, MASACH + "=?", new String[]{sach.getMaSach()});
        sqLiteDatabase.close();
        return result;
    }

    public void deleteBook(String id) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        sqLiteDatabase.delete(BOOK_TABLE, MASACH + "=?", new String[]{id});

    }

}
