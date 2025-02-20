package com.jack.testenverfit.di

import android.content.Context
import androidx.room.Room
import com.jack.testenverfit.data.database.AppConverter
import com.jack.testenverfit.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
        converter: AppConverter,
    ): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "app_everfit.db")
            .addTypeConverter(converter)
            .fallbackToDestructiveMigration()
            .build()
    }
}