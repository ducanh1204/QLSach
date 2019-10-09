package vn.edu.poly.qlsach.NguoiDung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qlsach.Home.MySqliteOpenHelper;

public class NguoiDungDAO {

    private MySqliteOpenHelper mySqliteOpenHelper;

    public NguoiDungDAO(Context context) {
        this.mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    private String USER_TABLE = "Nguoidung";

    public String ID = "id";
    public String NAME = "name";
    public String PASSWORD = "password";
    public String PHONE_NUMBER = "phoneNumber";
    public String ADDRESS = "address";


    public List<Nguoidung> getAll() {
        List<Nguoidung> nguoidungList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();

        String SQL = "SELECT * FROM " + USER_TABLE ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Nguoidung nguoidung = new Nguoidung();

                    nguoidung.setId(cursor.getString(cursor.getColumnIndex(ID)));
                    nguoidung.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                    nguoidung.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));
                    nguoidung.setPhoneNumber(cursor.getString(cursor.getColumnIndex(PHONE_NUMBER)));
                    nguoidung.setAddress(cursor.getString(cursor.getColumnIndex(ADDRESS)));

                    nguoidungList.add(nguoidung);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return nguoidungList;
    }

    public long insertUser(Nguoidung nguoidung) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, nguoidung.getId());
        contentValues.put(NAME, nguoidung.getName());
        contentValues.put(PASSWORD, nguoidung.getPassword());
        contentValues.put(PHONE_NUMBER,nguoidung.getPhoneNumber());
        contentValues.put(ADDRESS,nguoidung.getAddress());

        long result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public long updateUser(Nguoidung nguoidung) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, nguoidung.getId());
        contentValues.put(NAME, nguoidung.getName());
        contentValues.put(PASSWORD, nguoidung.getPassword());
        contentValues.put(PHONE_NUMBER,nguoidung.getPhoneNumber());
        contentValues.put(ADDRESS,nguoidung.getAddress());

        long result = sqLiteDatabase.update(USER_TABLE,contentValues, ID + "=?", new String[]{nguoidung.getId()});
        sqLiteDatabase.close();
        return result;
    }
    public void deleteUser(String id) {
        SQLiteDatabase sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();

        sqLiteDatabase.delete(USER_TABLE, ID + "=?", new String[]{id});

    }

}
