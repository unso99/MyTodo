package com.mytodo.di

import com.mytodo.data.dao.TodoDao
import com.mytodo.repository.TodoRepository
import com.mytodo.repository.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TodoRepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesTodoRepository(todoDao: TodoDao): TodoRepository = TodoRepositoryImpl(todoDao)
}