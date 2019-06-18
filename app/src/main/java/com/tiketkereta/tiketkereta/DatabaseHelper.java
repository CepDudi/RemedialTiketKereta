package com.tiketkereta.tiketkereta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_tiketkereta";
    public static final String TABLE_NAME = "tb_login";
    public static final String KEY_ID = "id";
    public static final String KEY_USERNAME = "username";



    private SQLiteDatabase db;

    public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "(" + KEY_ID + " STRING PRIMARY KEY ," +
            KEY_USERNAME + " STRING NOT NULL )";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
    }

    public void SimpanData(String id_user, String username){
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id_user);
        values.put(KEY_USERNAME, username);
        db.insert(TABLE_NAME, null,values);
    }

    public Cursor LihatData(){
        String sql = "SELECT * FROM" + TABLE_NAME ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(sql,new String[]{});
        return res;
    }

    public void HapusData(){
        String sql = "DELETE FROM" + TABLE_NAME ;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
