package com.example.lec13home.controllers

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.lec13home.R
import com.example.lec13home.database.KStudentsDB
import com.example.lec13home.database.StudentDAO
import com.example.lec13home.database.StudentsDB
import com.example.lec13home.models.KStudent

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //insert
        val dao = StudentDAO.getInstance(this)

        dao.addStudent(
            KStudent("Dave","dave@gmail.com",null)
        )


        //update
        dao.updateStudent(KStudent("sacha","sach@gmail.com",1))

        //get:
        println(dao.students)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
