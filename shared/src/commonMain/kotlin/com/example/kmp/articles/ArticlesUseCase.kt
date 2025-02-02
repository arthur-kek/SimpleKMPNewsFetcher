package com.example.kmp.articles

class ArticlesUseCase(private val service: ArticleService) {

    suspend fun getArticles(): List<Article> {
        val articleRows = service.fetchArticles()
        return articleRows.map { raw ->
            Article(
                title = raw.title,
                description = raw.description ?: "Click more to find the description",
                date = raw.date,
                imageUrl = raw.imageUrl ?: "https://picsum.photos/800/400?random=1"
            )
        }
    }
}