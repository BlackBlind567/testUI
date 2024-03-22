package com.example.shantanutest.di

import android.content.Context
import com.example.shantanutest.data.network.interfaces.LoginApiCall

import com.example.shantanutest.data.network.generic.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideUserApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): LoginApiCall {
        return remoteDataSource.buildApi(
            LoginApiCall::class.java, context,
            tokenApply = false,
            otherUrlApply = false
        )
    }
}