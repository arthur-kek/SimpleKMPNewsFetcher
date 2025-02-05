package com.example.kmp.articles.data

import example.kmp.db.SimpleSharedDataBase

class ArticlesDataSource(
    private val dataBase: SimpleSharedDataBase
) {

    fun getArticles(): List<ArticleRaw> =
        dataBase.simpleSharedDataBaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        dataBase.simpleSharedDataBaseQueries.transaction {
            articles.forEach {  articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() = dataBase.simpleSharedDataBaseQueries.removeAllArticles()

    private fun insertArticle(article: ArticleRaw) {
        with(article) {
            dataBase.simpleSharedDataBaseQueries.insertArticle(
                title, description, date, imageUrl
            )
        }
    }

    private fun mapToArticleRaw(
        title: String,
        description: String?,
        date: String,
        url: String?
    ) = ArticleRaw(
        title, description, date, url
    )

}