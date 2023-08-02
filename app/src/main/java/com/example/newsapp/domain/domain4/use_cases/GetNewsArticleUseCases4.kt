package com.example.newsapp.domain.domain4.use_cases

import com.example.newsapp.domain.domain4.model.Article4
import com.example.newsapp.domain.domain4.repositories.GetNewsArticleRepo4
import com.example.newsapp.utils.Resource4
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCases4 @Inject constructor(private val getNewsArticleRepo4: GetNewsArticleRepo4) {
    operator  fun invoke():Flow<Resource4<List<Article4>>> = flow {
        emit(Resource4.Loading(""))
        try {
            emit(Resource4.Success(getNewsArticleRepo4.getNewsArticle4()))


        }catch (e:Exception){
           emit(Resource4.Error(e.message))
        }

    }
}