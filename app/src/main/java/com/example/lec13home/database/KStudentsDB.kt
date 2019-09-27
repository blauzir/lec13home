package com.example.lec13home.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class KStudentsDB(context: Context) : SQLiteOpenHelper(context,
    DB_NAME, null,
    DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREAT_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object{
        val DB_VERSION = 1
        val DB_NAME ="StudentsDB"
        val TABLE_NAME ="Students"

        val CREAT_TABLE_STUDENTS ="""
                                    CREATE TABLE $TABLE_NAME(id INTEGER PRIMARY KEY AUTOINCREMENT);
                                """

    }
}