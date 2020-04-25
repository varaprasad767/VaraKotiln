package com.example.task

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class MainViewModel(application: Application): AndroidViewModel(application) {
    val scoreReproisitory: ScoreReproisitory
    val total_score: LiveData<List<ScoreDetails_Entity>>
    var run = 0
    var wickets: Int = 0
    var over: Int = 0
    var balls: Int = 0
    var A = true

    init {
        scoreReproisitory = ScoreReproisitory(application)
        total_score = scoreReproisitory.getAll()

    }
    fun insert(scoredetailsEntity: ScoreDetails_Entity) {
        scoreReproisitory.insert(scoredetailsEntity)
    }

