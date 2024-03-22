package com.example.shantanutest.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase.QueryCallback
import com.example.shantanutest.data.local.database.TestDatabase
import com.example.shantanutest.data.local.entity.MenuEntity
import com.example.shantanutest.data.local.entity.OfferEntity
import com.example.shantanutest.data.local.entity.RecommendedEntity
//import com.example.shantanutest.data.local.database.TestDatabase
//import com.example.shantanutest.data.local.entity.TestEntity

import com.example.shantanutest.extra.DatabaseName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
//Hilt needs to know how to create an instance of NoteDatabase. For that add another method below provideDao.
    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, TestDatabase::class.java, DatabaseName.TEST_DATABASE)
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .setQueryCallback(object : QueryCallback {
            override fun onQuery(sqlQuery: String, bindArgs: List<Any?>) {
//                println("SQL Query: $sqlQuery SQL Args: $bindArgs")

            }

        }, Executors.newSingleThreadExecutor())
        .build()
    //This annotation marks the method provideDao as a provider of noteDoa.
    @Provides
    @Singleton
    fun provideDao(db: TestDatabase) = db.databaseDao()

    @Provides
    fun provideMenuEntity() = MenuEntity()

    @Provides
    fun provideOfferEntity() = OfferEntity()

    @Provides
    fun provideRecommendedEntity() = RecommendedEntity()




}