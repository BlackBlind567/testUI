package com.example.shantanutest.data.local.database

import androidx.room.Database

import androidx.room.RoomDatabase
import com.example.shantanutest.data.local.dao.DatabaseDao
import com.example.shantanutest.data.local.entity.MenuEntity
import com.example.shantanutest.data.local.entity.OfferEntity
import com.example.shantanutest.data.local.entity.RecommendedEntity


@Database(
    entities = [MenuEntity::class, OfferEntity::class,
        RecommendedEntity::class], version = 1, exportSchema = false,
)
abstract class TestDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}