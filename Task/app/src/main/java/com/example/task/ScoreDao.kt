package com.example.task

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ScoreDao {


    @Insert
    fun insert(studentsDetails: ScoreDetails_Entity)


    @Query("select * from score_board")
    fun getAll(): LiveData<List<ScoreDetails_Entity>>

}