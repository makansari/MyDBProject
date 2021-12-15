package com.example.mydbproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_db")
class Student{
    @PrimaryKey (autoGenerate = true)
    var id : Int? = 0

    var name : String = ""
    var email : String = ""
}


