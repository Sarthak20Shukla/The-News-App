package com.example.newsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.domain3.use_cases.GetNewsArticleUseCases3
import com.example.newsapp.presentation.HomeStateHolder3
import com.example.newsapp.utils.Resource3
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel3 @Inject constructor(private val getNewsArticleUseCase3: GetNewsArticleUseCases3)

    :ViewModel() {


val articles= mutableStateOf(HomeStateHolder3())
    init {
        getNewsArticles3()
    }
    fun getNewsArticles3(){
        getNewsArticleUseCase3().onEach{
            when(it){
                is Resource3.Loading->{
                    articles.value = HomeStateHolder3(isLoading = true)
                }
                is Resource3.Success->{
                    articles.value = HomeStateHolder3(data = it.data)
                }
                is Resource3.Error->{
                    articles.value = HomeStateHolder3(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)


    }
}

