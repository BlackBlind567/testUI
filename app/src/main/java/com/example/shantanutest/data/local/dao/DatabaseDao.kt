package com.example.shantanutest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shantanutest.data.local.entity.MenuEntity
import com.example.shantanutest.data.local.entity.OfferEntity
import com.example.shantanutest.data.local.entity.RecommendedEntity
import com.example.shantanutest.extra.TableName

//import com.example.shantanutest.data.local.entity.TestEntity

@Dao
interface DatabaseDao {

    //InsertData
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommended(recommendedEntity: List<RecommendedEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(offerEntity: List<OfferEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu(menuEntity: List<MenuEntity>)

    //FetchList
    @Query("SELECT * FROM ${TableName.MENU_TABLE}")
    fun menuData(): List<MenuEntity>

    @Query("SELECT * FROM ${TableName.OFFER_TABLE}")
    fun offerData(): List<OfferEntity>

    @Query("SELECT * FROM ${TableName.RECOMMENDED_TABLE}")
    fun recommendedData(): List<RecommendedEntity>

}