package com.example.newsapp.utils

import com.example.newsapp.domain.domain1.model.Article1
import com.example.newsapp.domain.domain2.model.Article2
import com.example.newsapp.domain.domain3.model.Article3
import com.example.newsapp.domain.domain4.model.Article4


sealed  class Resource1<T>(val data: List<Article1>? =null, val message:String?=null){

    class  Success<T>(data: List<Article1>): Resource1<T>(data = data)

    class Loading<T>(message: String?) : Resource1<T>()

    class Error<T>(message:String?) : Resource1<T>(message = message)

}

sealed  class Resource2<T>(val data: List<Article2>? =null, val message:String?=null){

    class  Success<T>(data: List<Article2>): Resource2<T>(data = data)

    class Loading<T>(message: String?) : Resource2<T>()

    class Error<T>(message:String?) : Resource2<T>(message = message)

}
sealed  class Resource3<T>(val data: List<Article3>? =null, val message:String?=null){

    class  Success<T>(data: List<Article3>): Resource3<T>(data = data)

    class Loading<T>(message: String?) : Resource3<T>()

    class Error<T>(message:String?) : Resource3<T>(message = message)

}
sealed  class Resource4<T>(val data: List<Article4>? =null, val message:String?=null){

    class  Success<T>(data: List<Article4>): Resource4<T>(data = data)

    class Loading<T>(message: String?) : Resource4<T>()

    class Error<T>(message:String?) : Resource4<T>(message = message)

}