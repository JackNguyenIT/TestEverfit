package com.jack.testenverfit.repository

import com.jack.testenverfit.api.ApiService
import com.jack.testenverfit.api.ResultApi
import com.jack.testenverfit.data.Workout
import com.jack.testenverfit.data.database.AppDatabase
import com.jack.testenverfit.utils.handleApiResponse
import kotlinx.coroutines.flow.Flow
import org.joda.time.DateTimeConstants
import org.joda.time.LocalDate
import javax.inject.Inject

class WorkoutRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
) {

    suspend fun getWorkouts(): Flow<ResultApi<List<Workout>>> {
        return handleApiResponse {
            apiService.getWorkouts().data.also { workouts ->
                if (workouts.isNullOrEmpty().not()) {
                    appDatabase.appDao().insertWorkouts(workouts!!)
                }
            } ?: emptyList()
        }
    }

    fun getCurrentWeekDates(): List<LocalDate> {
        val now = LocalDate.now()
        val monday = now.withDayOfWeek(DateTimeConstants.MONDAY)
        return (0..6).map { day ->
            monday.plusDays(day)
        }
    }

    suspend fun getWorkoutsFromDatabase(): List<Workout> {
        return appDatabase.appDao().getWorkouts()
    }
}