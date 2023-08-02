package com.example.newsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.domain2.use_cases.GetNewsArticleUseCases2
import com.example.newsapp.presentation.HomeStateHolder2
import com.example.newsapp.utils.Resource2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel2 @Inject constructor(private val getNewsArticleUseCase2: GetNewsArticleUseCases2)

    :ViewModel() {


val articles= mutableStateOf(HomeStateHolder2())
    init {
        getNewsArticles2()
    }
    fun getNewsArticles2(){
        getNewsArticleUseCase2().onEach{
            when(it){
                is Resource2.Loading->{
                    articles.value = HomeStateHolder2(isLoading = true)
                }
                is Resource2.Success->{
                    articles.value = HomeStateHolder2(data = it.data)
                }
                is Resource2.Error->{
                    articles.value = HomeStateHolder2(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)


    }
}

