package com.example.lec13home.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lec13home.models.KStudent;
import com.example.lec13home.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private SQLiteDatabase db;

    private StudentDAO(SQLiteDatabase db){
        this.db = db;
    }


    //allow only one instance (singleton)
    private static StudentDAO instance;

    public synchronized static StudentDAO getInstance(Context c) {
        if (instance ==null){
            StudentsDB sdb = new StudentsDB(c);
            SQLiteDatabase db = sdb.getWritableDatabase();

            instance = new StudentDAO(db);
        }
        return instance;
    }

    public int addStudent(KStudent s){
        //db.insert()
        ContentValues cv = from(s);
        int id = (int) db.insert(StudentsDB.TABLE_NAME,null,cv);
        s.setId(id);

        return id;
    }

    //returns the number of rows affected
    public boolean updateStudent(KStudent s){
        ContentValues cv = from(s);
        return db.update(StudentsDB.TABLE_NAME, cv,"_id = ?",new String[]{s.getId() + ""}) > 0;
    }

    public boolean deleteStudent(KStudent s){
        return db.delete(StudentsDB.TABLE_NAME,"_id = ?",new String[]{""+ s.getId()})>0;
    }

    public ContentValues from(KStudent s){
        ContentValues cv = new ContentValues();
        cv.put("name",s.getName());
        cv.put("email",s.getEmail());
        return cv;
    }

    //read:
    public List<KStudent> getStudents(){
        //new list
        List<KStudent>students = new ArrayList<>();

        //witch columns do we want
        String[]projection = {"_id","name","email"};

        //selection == filter
        String selection = "name LIKE ? AND email LIKE ? ";
        String [] selectionArgs = {"m%","%@%"};

        //query -> fill the list
        //groupBy & having is for mor smart query
        //ASC = ascending - from law to high
        Cursor cursor = db.query(StudentsDB.TABLE_NAME, projection,
                null, null, null, null, "name ASC");

        if (!cursor.moveToFirst()){
            return students;
        }

        do {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String email = cursor.getString(2);
            students.add(new KStudent(name,email,id));
        }while (cursor.moveToNext());

        cursor.close();

        //return list
        return students;
    }






}
