package com.arpitparekh.kotlinafternoonbatch.room_crud

import android.content.Context
import androidx.room.Room

class UtilityHelper {

    companion object{

        fun getInstance(context: Context): EmpDatabase {

            return Room.databaseBuilder(context, EmpDatabase::class.java, "Empdatabase")
                .allowMainThreadQueries()
                .build()
        }

    }
}