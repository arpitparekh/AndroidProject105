package com.arpitparekh.kotlinafternoonbatch.room_crud

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Emp :: class), version = 1)
abstract class EmpDatabase : RoomDatabase() {

    abstract fun getDao() : EmpDao
}