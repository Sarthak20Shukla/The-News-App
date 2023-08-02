package com.example.newsapp.domain.domain2.use_cases

import com.example.newsapp.domain.domain2.model.Article2
import com.example.newsapp.domain.domain2.repositories.GetNewsArticleRepo2
import com.example.newsapp.utils.Resource2
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCases2 @Inject constructor(private val getNewsArticleRepo2: GetNewsArticleRepo2) {
    operator  fun invoke():Flow<Resource2<List<Article2>>> = flow {
        emit(Resource2.Loading(""))
        try {
            emit(Resource2.Success(getNewsArticleRepo2.getNewsArticle2()))


        }catch (e:Exception){
           emit(Resource2.Error(e.message))
        }

    }
}