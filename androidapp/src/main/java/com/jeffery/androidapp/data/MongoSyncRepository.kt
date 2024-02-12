package com.jeffery.androidapp.data

import com.jeffery.androidapp.models.Post
import com.jeffery.androidapp.util.RequestState
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import kotlinx.coroutines.flow.Flow

interface MongoSyncRepository {
    fun configureTheRealm()
    fun readAllPosts(): Flow<RequestState<List<Post>>>
    fun searchPostsByTitle(query: String): Flow<RequestState<List<Post>>>
    fun searchPostsByCategory(category: Category): Flow<RequestState<List<Post>>>
}