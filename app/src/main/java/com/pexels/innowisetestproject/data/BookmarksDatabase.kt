package com.pexels.innowisetestproject.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.pexels.innowisetestproject.data.models.Photo


@Database(entities = [Photo::class], version = 1)
abstract class BookmarksDatabase : RoomDatabase(){
    abstract val dao: com.pexels.innowisetestproject.data.di.Dao
}