package ru.vorxa.dto

import ru.vorxa.model.PostModel
import ru.vorxa.model.PostType


data class PostResponseDto(
    val id: Long,
    val author: String,
    val content: String? = null,
    val created: Long,
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
) {
    companion object {
        fun fromModel(model: PostModel) = PostResponseDto(
             id = model.id,
             author = model.author,
             content = model.content,
             created = model.created,
             postType = model.postType,
             source = model.source,
             address = model.address,
             location = model.location,
             videoLink = model.videoLink,
             adLink = model.adLink,
             likedByMe = model.likedByMe,
             commentedByMe = model.commentedByMe,
             sharedByMe = model.sharedByMe,
             likes = model.likes,
             comments = model.comments,
             shares = model.shares
            )
    }
}
