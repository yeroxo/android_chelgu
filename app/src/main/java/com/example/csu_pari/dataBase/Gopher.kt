package com.example.csu_pari.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random


@Entity
data class Gopher(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "job") val job: String,
    @ColumnInfo(name = "age") val age: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}


class GopherRaceGenerator{
    fun generate(minGopherCount:Int,maxGopherCount:Int):List<Gopher> {
        val gopherRace:MutableList<Gopher> = mutableListOf()
        for(i in minGopherCount..maxGopherCount){
            gopherRace.add(
                Gopher(
                    Random.nextInt(1,1000).toString(),
                    Random.nextInt(1,1000).toString(),
                    Random.nextInt(1,1000)
                ))
        }
        return gopherRace.toList()
    }
}