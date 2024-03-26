package com.pexels.innowisetestproject.data.repository

import com.pexels.innowisetestproject.data.BookmarksDatabase
import com.pexels.innowisetestproject.data.models.Photo
import com.pexels.innowisetestproject.data.models.mapToDomain
import com.pexels.innowisetestproject.domain.models.PhotoDomain
import com.pexels.innowisetestproject.domain.repository.ILocalRepository

class LocalRepository(
    private val db: BookmarksDatabase
) : ILocalRepository{

    override suspend fun getPhotoById(id: Int): PhotoDomain? {
        return runCatching {
            db.dao.getPhotoById(id)
                .firstOrNull()
                ?.mapToDomain()
        }.getOrNull()
    }


    override suspend fun addBookmark(photo: Photo) {
        runCatching {
            db.dao.addBookmark(photo)
        }
    }

    override suspend fun removeBookmark(photo: Photo) {
        db.dao.removeBookmark(photo)
    }

    override suspend fun countPhotosById(id: Int): Int {
        return runCatching {
            db.dao.countById(id)
        }.getOrElse { 0 }
    }

    override suspend fun getThematicalCollection(): List<PhotoDomain> {
        return runCatching {
            db.dao.getAllBookmarks()
                .map {
                it.mapToDomain()
            }
        }.getOrElse { emptyList() }
    }

}