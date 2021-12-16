package com.example.mydbproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database : StudentDatabase
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* var counter = 0
        button.setOnClickListener {
            counter++
            textView.setText(""+ counter)
        }*/
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.startTimer()

        viewModel.sec.observe(this, Observer {
            textView.text = it.toString()
        })

        viewModel.countfinish.observe(this, Observer {
            textView.text = it.toString()
        })

       /* textView.text = viewModel.numb.toString()

        button.setOnClickListener {
            viewModel.incNumber()
            textView.text = viewModel.numb.toString()
        }*/





    /*    database = Room.databaseBuilder(this,StudentDatabase::class.java,
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
        }*/
    }
}