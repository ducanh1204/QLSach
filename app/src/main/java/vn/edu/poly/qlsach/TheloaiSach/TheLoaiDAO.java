package vn.edu.poly.qlsach.TheloaiSach;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;

public class TheLoaiDAO {

    private MySqliteOpenHelper mySqliteOpenHelper;

    public TheLoaiDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    private String TL_TABLE = "TheLoaiSach";

    public String MATL = "maTheLoai";
    public String TENTL = "tenTheLoai";
    public String VITRI = "vitri";
    public String MOTA = "moTa";


    public List<TheLoaiSach> getAll() {
        List<TheLoaiSach> theLoaiSachList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + TL_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    TheLoaiSach theLoaiSach = new TheLoaiSach();

                    theLoaiSach.setMaTheLoai(cursor.getString(cursor.getColumnIndex(MATL)));
                    theLoaiSach.setTenTheLoai(cursor.getString(cursor.getColumnIndex(TENTL)));
                    theLoaiSach.setVitri(Integer.parseInt(cursor.getString(cursor.getColumnIndex(VITRI))));
                    theLoaiSach.setMoTa(cursor.getString(cursor.getColumnIndex(MOTA)));

                    theLoaiSachList.add(theLoaiSach);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return theLoaiSachList;
    }

    public long insertTLSach(TheLoaiSach theLoaiSach) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MATL, theLoaiSach.getMaTheLoai());
        contentValues.put(TENTL, theLoaiSach.getTenTheLoai());
        contentValues.put(VITRI, theLoaiSach.getVitri());
        contentValues.put(MOTA,theLoaiSach.getMoTa());

        long result = sqLiteDatabase.insert(TL_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateTLSach(TheLoaiSach theLoaiSach) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MATL, theLoaiSach.getMaTheLoai());
        contentValues.put(TENTL, theLoaiSach.getTenTheLoai());
        contentValues.put(VITRI, theLoaiSach.getVitri());
        contentValues.put(MOTA,theLoaiSach.getMoTa());

        long result = sqLiteDatabase.update(TL_TABLE,contentValues, MATL + "=?", new String[]{theLoaiSach.getMaTheLoai()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteTLSach(String id) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        sqLiteDatabase.delete(TL_TABLE, MATL + "=?", new String[]{id});

    }

}
