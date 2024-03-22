package com.example.shantanutest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shantanutest.extra.TableName

@Entity(tableName = TableName.RECOMMENDED_TABLE)
data class RecommendedEntity (
    @PrimaryKey(autoGenerate = true)
    val itemId:Int = 0,
    val itemImagePath: Int = 0,
    val itemTitle:String = "",
    val itemPrice:String = ""
)