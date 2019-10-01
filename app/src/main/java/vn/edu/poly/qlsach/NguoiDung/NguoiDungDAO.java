package vn.edu.poly.qlsach.NguoiDung;

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

    private String USER_TABLE = "nguoiDung";

    public String ID = "id";
    public String NAME = "name";
    public String PASSWORD = "password";
    public String PHONE_NUMBER = "phone";
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


}
