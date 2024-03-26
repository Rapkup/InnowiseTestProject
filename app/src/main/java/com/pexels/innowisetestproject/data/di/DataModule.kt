package com.pexels.innowisetestproject.data.di

import android.app.Application
import androidx.room.Room
import com.pexels.innowisetestproject.data.BookmarksDatabase
import com.pexels.innowisetestproject.data.api.ApiInterface
import com.pexels.innowisetestproject.data.repository.LocalRepository
import com.pexels.innowisetestproject.data.repository.NetworkRepository
import com.pexels.innowisetestproject.domain.repository.ILocalRepository
import com.pexels.innowisetestproject.domain.repository.INetworkRepostory
import com.pexels.innowisetestproject.utilities.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun  provideBookmarksDataBase(
            application: Application
    ) : BookmarksDatabase{
        return Room.databaseBuilder(
            application,
            BookmarksDatabase::class.java,
            "Bookmarks.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNetwoekRepository(apiService: ApiInterface ): INetworkRepostory {
        return  NetworkRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(db: BookmarksDatabase): ILocalRepository{
      return  LocalRepository(db)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }





}