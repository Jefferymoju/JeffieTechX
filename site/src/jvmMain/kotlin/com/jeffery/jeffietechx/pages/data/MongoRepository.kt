package com.jeffery.jeffietechx.pages.data

import com.jeffery.jeffietechx.pages.blog.blog_models.Post
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.pages.blog.blog_models.User


interface MongoRepository {
    suspend fun checkUserExistence(user: User): User?
    suspend fun checkUserId(id: String): Boolean
    suspend fun addPost(post: Post): Boolean
    suspend fun updatePost(post: Post): Boolean
    suspend fun readMyPosts(skip: Int, author: String): List<PostWithoutDetails>
    suspend fun searchPostsByTitle(query: String, skip: Int): List<PostWithoutDetails>
    suspend fun deleteSelectedPosts(ids: List<String>) : Boolean
    suspend fun readSelectedPost(id: String): Post
    suspend fun readMainPosts(): List<PostWithoutDetails>
    suspend fun readLatestPosts(skip: Int): List<PostWithoutDetails>
    suspend fun readPopularPosts(skip: Int): List<PostWithoutDetails>
    suspend fun readSponsoredPosts(): List<PostWithoutDetails>
}