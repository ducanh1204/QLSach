package vn.edu.poly.qlsach.HoaDonChiTiet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;

public class HDCTDAO {

    private MySqliteOpenHelper mySqliteOpenHelper;

    public HDCTDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    private String HDCT_TABLE = "HDCT";

    public String MA_HDCT = "maHDCT";
    public String MA_HD = "maHD";
    public String MA_SACH = "maSach";
    public String SO_LUONG = "soLuong";


    public List<HDCT> show_HDCT(String maHD) {
        List<HDCT> hoadonList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + HDCT_TABLE + " where " + MA_HD + "=?";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, new String[]{maHD});

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    HDCT hdct = new HDCT();

                    hdct.setMaHDCT(cursor.getString(cursor.getColumnIndex(MA_HDCT)));
                    hdct.setMaHD(cursor.getString(cursor.getColumnIndex(MA_HD)));
                    hdct.setMaSach(cursor.getString(cursor.getColumnIndex(MA_SACH)));
                    hdct.setSoLuong(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SO_LUONG))));

                    hoadonList.add(hdct);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return hoadonList;
    }

    public long insertHDCT(HDCT hdct) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MA_HDCT, hdct.getMaHDCT());
        contentValues.put(MA_HD, hdct.getMaHD());
        contentValues.put(MA_SACH, hdct.getMaSach());
        contentValues.put(SO_LUONG, hdct.getSoLuong());

        long result = sqLiteDatabase.insert(HDCT_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateHDCT(HDCT hdct) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MA_HDCT, hdct.getMaHDCT());
        contentValues.put(MA_HD, hdct.getMaHD());
        contentValues.put(MA_SACH, hdct.getMaSach());
        contentValues.put(SO_LUONG, hdct.getSoLuong());

        long result = sqLiteDatabase.update(HDCT_TABLE,contentValues, MA_HDCT + "=?", new String[]{hdct.getMaHDCT()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteHDCT(String id) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        sqLiteDatabase.delete(HDCT_TABLE, MA_HDCT + "=?", new String[]{id});

    }

}
