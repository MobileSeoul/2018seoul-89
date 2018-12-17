package com.example.melon.withgil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by melon on 2018-09-27.
 */

public class LocationInfoDatabase extends SQLiteOpenHelper {
    public LocationInfoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LOCATIONINFO(idx integer, lat real, lon real);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addLocation(int idx, double lat, double lon) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO LOCATIONINFO(idx, lat, lon) VALUES (" + idx + ", " + lat + ", " + lon + ")";
        db.execSQL(sql);
        //db.execSQL(sql, new Object[]{userInfo.getUid(), userInfo.getPhone_number(), userInfo.getName(), userInfo.getSex(), userInfo.getBirthday(), userInfo.getEmail(), userInfo.getNation()});
        //Log.d("userInfoDatabase", userInfo.getUid());
    }

    public ArrayList<Double> getLocation(int idx) {
        ArrayList<Double> locArr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM LOCATIONINFO WHERE idx = " + idx;

        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()) {
            locArr.add(cursor.getDouble(1));
            locArr.add(cursor.getDouble(2));
        }
        cursor.close();

        return locArr;
    }

}
