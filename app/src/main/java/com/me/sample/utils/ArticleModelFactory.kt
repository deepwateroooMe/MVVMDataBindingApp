package com.me.sample.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.me.sample.repository.ArticleRepository
import com.me.sample.viewmodel.ArticleViewModel

class ArticleModelFactory(private val repository: ArticleRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(repository) as T
    }
}