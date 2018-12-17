package com.example.melon.withgil;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by melon on 2018-09-27.
 */

public class DefaultRegionDatabase extends SQLiteOpenHelper {
    public DefaultRegionDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE DEFAULTREGIONDB(district text, region text PRIMARY KEY);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addDR(String district, String region) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlDelete = "DELETE FROM DEFAULTREGIONDB";
        String sql = "INSERT INTO DEFAULTREGIONDB(district, region) VALUES ('" + district + "', '" + region + "')";
        db.execSQL(sqlDelete);
        db.execSQL(sql);
        //db.execSQL(sql, new Object[]{userInfo.getUid(), userInfo.getPhone_number(), userInfo.getName(), userInfo.getSex(), userInfo.getBirthday(), userInfo.getEmail(), userInfo.getNation()});
        //Log.d("userInfoDatabase", userInfo.getUid());
    }

    public String getDR() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM DEFAULTREGIONDB";

        Cursor cursor = db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            Log.d("Log : pNum output db", cursor.getString(0));
            return cursor.getString(0) + " " + cursor.getString(1);
        }
        cursor.close();

        return null;
    }

    public void updateUser(String uid, String attribute,  String updateValue) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "";
        switch (attribute){
            case "name":
                sql = "UPDATE USERINFO SET name = '" + updateValue + "' WHERE uId = '" + uid +"'";
            case "email":
                sql = "UPDATE USERINFO SET email = '" + updateValue + "' WHERE uId = '" + uid +"'";
        }

        db.execSQL(sql);
    }
}