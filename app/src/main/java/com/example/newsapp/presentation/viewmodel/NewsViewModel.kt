package com.example.newsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.domain1.use_cases.GetNewsArticleUseCases1
import com.example.newsapp.presentation.HomeStateHolder
import com.example.newsapp.utils.Resource1
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCases1)

    :ViewModel() {


val articles= mutableStateOf(HomeStateHolder())
    init {
        getNewsArticles1()
    }
    fun getNewsArticles1(){
        getNewsArticleUseCase().onEach{
            when(it){
                is Resource1.Loading->{
                    articles.value = HomeStateHolder(isLoading = true)
                }
                is Resource1.Success->{
                    articles.value = HomeStateHolder(data = it.data)
                }
                is Resource1.Error->{
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)


    }
}

