package com.example.newsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.domain4.use_cases.GetNewsArticleUseCases4
import com.example.newsapp.presentation.HomeStateHolder4
import com.example.newsapp.utils.Resource4
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel4 @Inject constructor(private val getNewsArticleUseCase4: GetNewsArticleUseCases4)

    :ViewModel() {


val articles= mutableStateOf(HomeStateHolder4())
    init {
        getNewsArticles()
    }
    fun getNewsArticles(){
        getNewsArticleUseCase4().onEach{
            when(it){
                is Resource4.Loading->{
                    articles.value = HomeStateHolder4(isLoading = true)
                }
                is Resource4.Success->{
                    articles.value = HomeStateHolder4(data = it.data)
                }
                is Resource4.Error->{
                    articles.value = HomeStateHolder4(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)


    }
}

