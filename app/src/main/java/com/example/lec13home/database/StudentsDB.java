package com.example.lec13home.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentsDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentsDB";
    public static final int DB_VERSION = 2;
    public static final String TABLE_NAME = "Students";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_NAME +"(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "email TEXT)";


    public StudentsDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE Students");
        onCreate(db);
    }
}
