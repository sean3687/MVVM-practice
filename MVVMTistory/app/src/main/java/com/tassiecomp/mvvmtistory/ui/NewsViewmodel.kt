package com.tassiecomp.mvvmtistory.ui

import androidx.lifecycle.ViewModel
import com.tassiecomp.mvvmtistory.repository.NewsRepository

class NewsViewmodel(
    val newsRepository: NewsRepository
): ViewModel() {
}