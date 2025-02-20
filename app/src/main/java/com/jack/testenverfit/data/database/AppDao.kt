package com.jack.testenverfit.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jack.testenverfit.data.Workout

@Dao
abstract class AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertWorkouts(workout: List<Workout>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertWorkout(workout: Workout)

    @Query("SELECT * FROM workouts")
    abstract suspend fun getWorkouts(): List<Workout>
}