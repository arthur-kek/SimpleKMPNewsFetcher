package com.example.kmp.articles

import kotlinx.datetime.*
class ArticlesUseCase(private val service: ArticleService) {

    suspend fun getArticles(): List<Article> {
        val articleRows = service.fetchArticles()
        return articleRows.map { raw ->
            Article(
                title = raw.title,
                description = raw.description ?: "Click more to find the description",
                date = formatDateFriendly(raw.date),
                imageUrl = raw.imageUrl ?: "https://picsum.photos/800/400?random=1"
            )
        }
    }

    private fun formatDateFriendly(dateString: String): String =
        runCatching {
            val timeZone = TimeZone.currentSystemDefault()
            val today = Clock.System.todayIn(timeZone)
            val articleDate = Instant.parse(dateString).toLocalDateTime(timeZone).date
            when {
                articleDate > today -> "Invalid date: future date not allowed"
                articleDate == today -> "today"
                articleDate == today.minus(DatePeriod(days = 1)) -> "yesterday"
                else -> "${articleDate.daysUntil(today)} days ago"
            }
        }.getOrElse { "Invalid date" }

}