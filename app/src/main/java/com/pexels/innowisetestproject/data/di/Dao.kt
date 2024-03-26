package com.pexels.innowisetestproject.data.di

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pexels.innowisetestproject.data.models.Photo

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(photo: Photo)

    @Query("SELECT * FROM Favourite_photos")
    suspend fun getAllBookmarks() : List<Photo>

    @Query("SELECT * FROM Favourite_photos WHERE id LIKE :id")
    suspend fun getPhotoById(id: Int): List<Photo>

    @Query("SELECT COUNT(*) FROM Favourite_photos WHERE id = :id")
    suspend fun  countById(id: Int): Int

    @Delete
    suspend fun removeBookmark(photo: Photo)

}