package com.example.lab5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    static int dbVersion = 1;
    static String dbName = "users";

    public DbHandler(MainActivity context){
        super(context,dbName,null,dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE user(id INTEGER PRIMARY KEY,name TEXT,password TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public void addUser(User u){
        SQLiteDatabase sd = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",u.getName());
        cv.put("password",u.getPassword());
        sd.insert("user",null,cv);
    }

    public int checkUser(User u){
        int id = -1;
        SQLiteDatabase sd = getReadableDatabase();
        Cursor cursor = sd.rawQuery("SELECT id FROM user WHERE name=? AND password=?",new String[]{u.getName(),u.getPassword()});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            id = cursor.getInt(0);
        }
        return id;
    }

}
