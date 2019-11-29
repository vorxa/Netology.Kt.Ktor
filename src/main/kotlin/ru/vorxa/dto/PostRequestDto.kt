package ru.vorxa.dto

import ru.vorxa.model.PostType

data class PostRequestDto(
    val id: Long,
    val author: String,
    val content: String? = null,
    val postType: PostType = PostType.POST
)