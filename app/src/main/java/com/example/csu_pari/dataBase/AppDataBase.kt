package com.example.csu_pari.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Gopher::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getGopherDao(): GopherDao

    companion object {
        fun createDb(context: Context) =
            Room.databaseBuilder(context, AppDataBase::class.java, "csu_pari").build()
    }
}