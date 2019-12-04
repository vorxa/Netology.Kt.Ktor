package ru.vorxa.dto

import ru.vorxa.model.PostType

data class PostRequestDto(
    val id: Long,
    val author: String,
    val content: String? = null,
    val postType: PostType? = PostType.POST,
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