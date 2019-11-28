package ru.vorxa.model

import ru.vorxa.dto.PostResponseDto

data class PostModel (
    val id: Long,
    val author: String,
    val content: String? = null,
    val created: Long = System.currentTimeMillis()/1000,
    val postType: PostType = PostType.POST,
    val source: PostResponseDto? = null,
    val address: String? = null,
    val location: Pair<Double, Double>? = null,
    val videoLink: String? = null,
    val adLink: String? = null,
    val likedByMe: Boolean = false,
    val commentedByMe: Boolean = false,
    val sharedByMe: Boolean = false,
    val likes: Long = 0,
    val comments: Long = 0,
    val shares: Long = 0

)

enum class PostType {
    POST,
    REPOST,
    EVENT,
    VIDEO,
    AD
}