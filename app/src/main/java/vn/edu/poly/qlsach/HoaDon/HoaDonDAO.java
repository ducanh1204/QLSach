package vn.edu.poly.qlsach.HoaDon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;

public class HoaDonDAO {

    private MySqliteOpenHelper mySqliteOpenHelper;

    public HoaDonDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    private String HD_TABLE = "Hoadon";

    public String MAHD = "maHoaDon";
    public String NGAY_MUA = "ngayMua";


    public List<Hoadon> getAll() {
        List<Hoadon> hoadonList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + HD_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Hoadon hoadon = new Hoadon();

                    hoadon.setMaHoaDon(cursor.getString(cursor.getColumnIndex(MAHD)));
                    hoadon.setNgayMua(cursor.getString(cursor.getColumnIndex(NGAY_MUA)));

                    hoadonList.add(hoadon);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return hoadonList;
    }

    public long insertHD(Hoadon hoadon) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MAHD, hoadon.getMaHoaDon());
        contentValues.put(NGAY_MUA, hoadon.getNgayMua());

        long result = sqLiteDatabase.insert(HD_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateHD(Hoadon hoadon) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MAHD, hoadon.getMaHoaDon());
        contentValues.put(NGAY_MUA, hoadon.getNgayMua());

        long result = sqLiteDatabase.update(HD_TABLE,contentValues, MAHD + "=?", new String[]{hoadon.getMaHoaDon()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteHD(String id) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        sqLiteDatabase.delete(HD_TABLE, MAHD + "=?", new String[]{id});

    }

}
