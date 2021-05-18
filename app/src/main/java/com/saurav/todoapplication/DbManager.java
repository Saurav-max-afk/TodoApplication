package com.saurav.todoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {
    public static final String dbname = "dbcontacts";

    public DbManager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "create table table_contact (id integer primary key autoincrement, name text,contact text,email text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS table_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);

    }

    public String addData(String name, String contact, String email) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("email", email);

        float result = database.insert("table_contact", null, contentValues);

        if (result == -1) {
            return "failed";
        } else {
            return "successfully inserted";
        }
    }

    public Cursor readalldata() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select * from table_contact order by id desc";
        Cursor cursor = database.rawQuery(query, null);
        return cursor;
    }

}