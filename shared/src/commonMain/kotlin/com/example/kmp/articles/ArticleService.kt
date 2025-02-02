package com.example.kmp.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "5af78040b09c4868ad84b5512a527dac"

    suspend fun fetchArticles() : List<ArticleRaw> {
        val response: ArticlesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }

}