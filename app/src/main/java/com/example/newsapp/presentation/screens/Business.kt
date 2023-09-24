package com.example.newsapp.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.newsapp.domain.domain3.model.Article3
import com.example.newsapp.presentation.viewmodel.NewsViewModel3


@Composable
fun Business(viewModel: NewsViewModel3 = hiltViewModel()) {
    val res = viewModel.articles.value


    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }

    }


    res.data?.let {
        LazyColumn {
            items(it) {
                ArticleItem3(it)
            }
        }

    }
}

@Composable
fun ArticleItem3(it: Article3) {
    val context = LocalContext.current
    val onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
        context.startActivity(intent)
    }
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, it.url)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)



    Spacer(modifier=Modifier.height(4.dp))

    Column(modifier = Modifier
        .padding(5.dp)
        .wrapContentWidth()
        .fillMaxHeight()
        .background(color = MaterialTheme.colors.onBackground, RoundedCornerShape(20.dp))
        .clip(shape = RoundedCornerShape(20.dp))
        .shadow(1.5.dp, shape = RoundedCornerShape(3.dp))
        .clickable { onClick() }) {

        Image(
            painter = rememberImagePainter(data = it.urlToImage), contentDescription = null,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),

            contentScale = ContentScale.Crop

        )

        Text(
            text = it.title, style = androidx.compose.ui.text.TextStyle(color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 7.dp)
                .fillMaxWidth()
        )
        Text(
            text = it.author, style = androidx.compose.ui.text.TextStyle(color = MaterialTheme.colors.secondaryVariant,
                fontWeight = FontWeight.Medium, fontSize =10.sp
            ),
            modifier = Modifier.padding(start = 12.dp, bottom = 0.dp)
        )
        IconButton(onClick = { context.startActivity(shareIntent) }) {
            Icon(modifier= Modifier.size(18.dp).align(alignment = Alignment.End),imageVector = Icons.Default.Share, contentDescription = "Share", tint = MaterialTheme.colors.onSurface)
        }
    }
    Spacer(modifier=Modifier.height(5.dp))
}

