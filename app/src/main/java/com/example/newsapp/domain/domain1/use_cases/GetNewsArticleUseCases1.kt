package com.example.newsapp.domain.domain1.use_cases

import com.example.newsapp.domain.domain1.model.Article1
import com.example.newsapp.domain.domain1.repositories.GetNewsArticleRepo1
import com.example.newsapp.utils.Resource1
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCases1 @Inject constructor(private val getNewsArticleRepo1: GetNewsArticleRepo1) {
    operator  fun invoke():Flow<Resource1<List<Article1>>> = flow {
        emit(Resource1.Loading(""))
        try {
            emit(Resource1.Success(getNewsArticleRepo1.getNewsArticle1()))


        }catch (e:Exception){
           emit(Resource1.Error(e.message))
        }

    }
}