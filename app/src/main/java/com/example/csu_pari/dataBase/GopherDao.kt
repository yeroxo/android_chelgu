package com.example.csu_pari.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GopherDao {
    @Insert
    fun insert(gopher: Gopher)

    @Query("SELECT * FROM Gopher")
    fun getGophers(): List<Gopher>

    @Query("DELETE FROM Gopher")
    fun clearTable();
}