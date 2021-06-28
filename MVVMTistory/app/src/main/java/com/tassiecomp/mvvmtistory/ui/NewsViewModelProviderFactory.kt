package com.tassiecomp.mvvmtistory.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tassiecomp.mvvmtistory.repository.NewsRepository

class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewmodel(newsRepository) as T
    }

}