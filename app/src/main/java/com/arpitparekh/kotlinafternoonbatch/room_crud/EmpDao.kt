package com.arpitparekh.kotlinafternoonbatch.room_crud

import androidx.room.*

@Dao
interface EmpDao {

    @Insert
    fun insertData(e : Emp)
    @Update
    fun updateData(e : Emp)
    @Delete
    fun deleteData(e : Emp)
    @Query("select * from emptable")
    fun fetchData() : List<Emp>

}