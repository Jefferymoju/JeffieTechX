package com.jeffery.androidapp.data

import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.models.Post
import com.jeffery.androidapp.util.RequestState
import kotlinx.coroutines.flow.Flow

/**
 * Interface defining methods for syncing data with MongoDB Realm.
 */
interface MongoSyncRepository {
    fun configureTheRealm()
    fun readAllPosts(): Flow<RequestState<List<Post>>>
    fun searchPostsByTitle(query: String): Flow<RequestState<List<Post>>>
    fun searchPostsByCategory(category: Category): Flow<RequestState<List<Post>>>
}