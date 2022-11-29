package com.me.sample.viewmodel

import com.me.sample.model.Data
import com.me.sample.repository.ArticleRepository
import com.me.sample.repository.StateLiveData

class ArticleViewModel(private val respository: ArticleRepository) : BaseViewModel() {

    val data = StateLiveData<List<Data>>()

// 这个相对复杂一点儿:    
    fun getArticle() {
        launch({
// 它说,从网络去抓取数据,并保存仓库里,并通知所有的观察者            
            respository.getArticle()?.let {
                data.postValueAndSuccess(it)
            }
        }, {
        }, data)
    }
}
