package com.example.mydbproject

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class],version = 2,exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDAO

}