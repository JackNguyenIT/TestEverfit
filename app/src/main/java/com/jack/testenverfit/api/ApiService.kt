package com.jack.testenverfit.api

import retrofit2.http.GET

interface ApiService {

    @GET("workouts")
    suspend fun getWorkouts(): WorkoutResponse
}