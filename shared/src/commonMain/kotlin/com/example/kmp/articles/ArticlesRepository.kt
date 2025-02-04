package com.example.kmp.articles

import com.example.kmp.core.logging.Logger
import com.example.kmp.core.network.NetworkMonitor

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService,
    private val networkMonitor: NetworkMonitor
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (!networkMonitor.isOnline()) {
            Logger.log("Device is offline, fetching data from DB")
            return dataSource.getArticles()
        }

        if (forceFetch) {
            dataSource.clearArticles()
            Logger.log("Force fetching data from internet")
            return fetchArticles()
        }

        val articlesDb = dataSource.getArticles()
        return articlesDb.ifEmpty { fetchArticles() }
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}