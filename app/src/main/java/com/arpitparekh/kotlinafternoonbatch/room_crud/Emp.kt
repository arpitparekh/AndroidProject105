package com.arpitparekh.kotlinafternoonbatch.room_crud

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emptable")
data class Emp(
    @ColumnInfo(name = "name")
    var name : String,

    @ColumnInfo(name="email")
    var email : String,

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0

) {

    override fun toString(): String {
        return "Name is $name\nEmail is $email"
    }
}