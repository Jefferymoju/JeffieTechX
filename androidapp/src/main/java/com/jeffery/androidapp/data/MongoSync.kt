package com.jeffery.androidapp.data

import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.models.Post
import com.jeffery.androidapp.util.Constants.APP_ID
import com.jeffery.androidapp.util.RequestState
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Object responsible for syncing data with MongoDB Realm.
 */
object MongoSync : MongoSyncRepository {
    private val app = App.create(APP_ID)
    private val user = app.currentUser
    private lateinit var realm: Realm

    init {
        configureTheRealm()
    }

    /**
     * Configures the Realm instance for syncing data.
     */
    override fun configureTheRealm() {
        if (user != null) {
            val config = SyncConfiguration.Builder(user, setOf(Post::class))
                .initialSubscriptions {
                    add(
                        query = it.query(Post::class),
                        name = "Blog Posts"
                    )
                }
                .log(LogLevel.ALL)
                .build()
            realm = Realm.open(config)
        }
    }

    /**
     * Retrieves all posts from the synced Realm database.
     *
     * @return A flow emitting the request state containing the list of posts.
     */
    override fun readAllPosts(): Flow<RequestState<List<Post>>> {
        return if (user != null) {
            try {
                realm.query(Post::class)
                    .asFlow()
                    .map { result ->
                        RequestState.Success(data = result.list)
                    }
            } catch (e: Exception) {
                flow { emit(RequestState.Error(Exception(e.message))) }
            }
        } else {
            flow { emit(RequestState.Error(Exception("User not authenticated."))) }
        }
    }

    /**
     * Searches posts by title from the synced Realm database.
     *
     * @param query The search query for post titles.
     * @return A flow emitting the request state containing the list of posts matching the search query.
     */
    override fun searchPostsByTitle(query: String): Flow<RequestState<List<Post>>> {
        return if (user != null) {
            try {
                realm.query<Post>(query = "title CONTAINS[c] $0", query)
                    .asFlow()
                    .map { result ->
                        RequestState.Success(data = result.list)
                    }
            } catch (e: Exception) {
                flow { emit(RequestState.Error(Exception(e.message))) }
            }
        } else {
            flow { emit(RequestState.Error(Exception("User not authenticated."))) }
        }
    }

    /**
     * Searches posts by category from the synced Realm database.
     *
     * @param category The category to filter posts.
     * @return A flow emitting the request state containing the list of posts belonging to the specified category.
     */
    override fun searchPostsByCategory(category: Category): Flow<RequestState<List<Post>>> {
        return if (user != null) {
            try {
                realm.query<Post>(query = "category == $0", category.name)
                    .asFlow()
                    .map { result ->
                        RequestState.Success(data = result.list)
                    }
            } catch (e: Exception) {
                flow { emit(RequestState.Error(Exception(e.message))) }
            }
        } else {
            flow { emit(RequestState.Error(Exception("User not authenticated."))) }
        }
    }
}