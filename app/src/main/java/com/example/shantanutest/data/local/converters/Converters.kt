package com.example.shantanutest.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
//    @TypeConverter
//    fun fromString(value: String?): List<BaselineDataEntity> {
//        if (value == null) {
//            return emptyList()
//        }
//        val listType = object : TypeToken<List<BaselineDataEntity>>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun fromList(list: List<BaselineDataEntity>?): String {
//        return Gson().toJson(list)
//    }
//
//    @TypeConverter
//    fun fromStringToValue(value: String?): List<LandOwnerCookStoveTranEntity> {
//        if (value == null) {
//            return emptyList()
//        }
//        val listType = object : TypeToken<List<LandOwnerCookStoveTranEntity>>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun toString(value: List<LandOwnerCookStoveTranEntity>?): String {
//        return Gson().toJson(value)
//    }
//
//    @TypeConverter
//    fun fromStringToBaselineDataValue(value: String?): List<BaselineDataRepoEntity> {
//        if (value == null) {
//            return emptyList()
//        }
//        val listType = object : TypeToken<List<BaselineDataRepoEntity>>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun toBaselineDataString(value: List<BaselineDataRepoEntity>?): String {
//        return Gson().toJson(value)
//    }
}