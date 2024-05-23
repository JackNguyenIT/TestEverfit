package com.jack.testenverfit.api

import com.google.gson.annotations.SerializedName
import com.jack.testenverfit.data.Workout

data class WorkoutResponse(
    @SerializedName("day_data")
    val data: List<Workout>?,
)