package com.jack.testenverfit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jack.testenverfit.data.Workout

@Database(
    entities = [Workout::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(AppConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao
}