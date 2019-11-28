package ru.vorxa.repository

import ru.vorxa.model.PostModel

interface PostRepository {
    suspend fun getAll(): List<PostModel>
    suspend fun getById(id: Long): PostModel?
    suspend fun save(item: PostModel): PostModel
    suspend fun removeById(id: Long)
    suspend fun likeById(id: Long): PostModel?
    suspend fun dislikeById(id: Long): PostModel?
    suspend fun commentById(id: Long): PostModel?
    suspend fun shareById(id: Long): PostModel?
}