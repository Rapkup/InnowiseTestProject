package com.pexels.innowisetestproject.domain.repository

import com.pexels.innowisetestproject.data.models.Photo
import com.pexels.innowisetestproject.domain.models.PhotoDomain


interface ILocalRepository {

    suspend fun getPhotoById(id: Int): PhotoDomain?

    suspend fun getThematicalCollection(): List<PhotoDomain>

    suspend fun  addBookmark(photo: Photo)

    suspend fun  removeBookmark(photo: Photo)

    suspend fun countPhotosById(id: Int) : Int


}