package com.mytodo.di

import com.mytodo.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun providesTodoDao(appDataBase: AppDatabase) = appDataBase.todoDao()


}