package com.example.mydbproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database : StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this,StudentDatabase::class.java,
            "mystudendb").fallbackToDestructiveMigration().build()
        button.setOnClickListener {
            GlobalScope.launch {
                var mystudents = Student()
                mystudents.name = editTextName.text.toString()
                mystudents.email = editTextEmail.text.toString()

                database.studentDao().insertStudent(mystudents)
            }
        }

        buttonShow.setOnClickListener {
            GlobalScope.launch {
                database.studentDao().showData().forEach {
                    var result = "id is ${it.id} and name is ${it.name} and email is ${it.email}"
                    Log.i("mytag",result)
                }
            }
        }
    }
}