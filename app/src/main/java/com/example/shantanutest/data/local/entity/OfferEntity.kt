package com.example.shantanutest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shantanutest.extra.TableName

@Entity(tableName = TableName.OFFER_TABLE)
data class OfferEntity (
    @PrimaryKey(autoGenerate = true)
    val itemId:Int = 0,
    val offerItemImagePath: Int = 0,
    val offerItemDiscount:String = "",
    val offerItemDiscountName:String = ""
)