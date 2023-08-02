package com.example.newsapp.domain.domain3.use_cases

import com.example.newsapp.domain.domain3.model.Article3
import com.example.newsapp.domain.domain3.repositories.GetNewsArticleRepo3
import com.example.newsapp.utils.Resource3
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCases3 @Inject constructor(private val getNewsArticleRepo3: GetNewsArticleRepo3) {
    operator  fun invoke():Flow<Resource3<List<Article3>>> = flow {
        emit(Resource3.Loading(""))
        try {
            emit(Resource3.Success(getNewsArticleRepo3.getNewsArticle3()))


        }catch (e:Exception){
           emit(Resource3.Error(e.message))
        }

    }
}