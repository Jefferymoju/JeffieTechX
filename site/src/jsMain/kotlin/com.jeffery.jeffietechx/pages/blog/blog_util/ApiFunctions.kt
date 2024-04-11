package com.jeffery.jeffietechx.pages.blog.blog_util

import com.jeffery.jeffietechx.pages.blog.blog_models.ApiListResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.AUTHOR_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.CATEGORY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POST_ID_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.QUERY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.SKIP_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.NewsLetter
import com.jeffery.jeffietechx.pages.blog.blog_models.Post
import com.jeffery.jeffietechx.pages.blog.blog_models.RandomJoke
import com.jeffery.jeffietechx.pages.blog.blog_models.User
import com.jeffery.jeffietechx.pages.blog.blog_models.UserWithoutPassword
import com.jeffery.jeffietechx.util.Constants
import com.varabyte.kobweb.browser.api
//import com.varabyte.kobweb.compose.http.http
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.get
import org.w3c.dom.set
import kotlin.js.Date

/**
 * Suspended function to check the existence of a user.
 *
 * @param user The user whose existence needs to be checked.
 * @return UserWithoutPassword if the user exists, null otherwise.
 */
suspend fun checkUserExistence(user: User): UserWithoutPassword? {
    return try {
        window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray()
        )?.decodeToString().parseData()
    }catch (e: Exception){
        println(e.message)
        null
    }
}

/**
 * Suspended function to check if a user ID exists.
 *
 * @param id The user ID to check.
 * @return True if the user ID exists, false otherwise.
 */
suspend fun checkUserId(id: String): Boolean {
    return try {
        window.api.tryPost(
            apiPath = "checkuserid",
            body = Json.encodeToString(id).encodeToByteArray()
        )?.decodeToString().parseData()
    }catch (e: Exception) {
        println(e.message.toString())
        false
    }
}

/**
 * Suspended function to fetch a random joke.
 *
 * @param onComplete Callback function to execute when the joke is fetched.
 */
suspend fun fetchRandomJoke(onComplete: (RandomJoke) -> Unit) {
    val date = localStorage["date"]
    if (date != null) {
        val difference = (Date.now() - date.toDouble())
        val dayHasPassed = difference >= 86400000
        if (dayHasPassed) {
            try {
                val result = window.http.get(Constants.HUMOR_API_URL).decodeToString()
                onComplete(result.parseData())
                localStorage["date"] = Date.now().toString()
                localStorage["joke"] = result
            } catch (e: Exception) {
                onComplete(RandomJoke(id = -1, joke = e.message.toString()))
                println(e.message)
            }
        } else {
            try {
                localStorage["joke"]?.parseData<RandomJoke>()?.let { onComplete(it) }
            } catch (e: Exception) {
                onComplete(RandomJoke(id = -1, joke = e.message.toString()))
                println(e.message)
            }
        }
    } else {
        try {
            val result = window.http.get(Constants.HUMOR_API_URL).decodeToString()
            onComplete(result.parseData())
            localStorage["date"] = Date.now().toString()
            localStorage["joke"] = result
        } catch (e: Exception) {
            onComplete(RandomJoke(id = -1, joke = e.message.toString()))
            println(e.message)
        }
    }
}

/**
 * Suspended function to add a post.
 *
 * @param post The post to add.
 * @return True if the post is added successfully, false otherwise.
 */
suspend fun addPost(post: Post): Boolean {
    return try {
        window.api.tryPost(
            apiPath = "addpost",
            body = Json.encodeToString(post).encodeToByteArray()
        )?.decodeToString().toBoolean()
    } catch (e: Exception) {
        println(e.message)
        false
    }
}

/**
 * Suspended function to update a post.
 *
 * @param post The post to update.
 * @return True if the post is updated successfully, false otherwise.
 */
suspend fun updatePost(post: Post): Boolean {
    return try {
        window.api.tryPost(
            apiPath = "updatepost",
            body = Json.encodeToString(post).encodeToByteArray()
        )?.decodeToString().toBoolean()
    } catch (e: Exception) {
        println(e.message)
        false
    }
}

/**
 * Suspended function to fetch posts authored by the logged-in user.
 *
 * @param skip The number of posts to skip.
 * @param onSuccess Callback function to execute when fetching posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun fetchMyPosts(
    skip: Int,
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(
            apiPath = "readmyposts?${SKIP_PARAM}=$skip&${AUTHOR_PARAM}=${localStorage["username"]}"
        )?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

/**
 * Suspended function to search posts by title.
 *
 * @param query The search query.
 * @param skip The number of posts to skip.
 * @param onSuccess Callback function to execute when fetching posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun searchPostsByTitle(
    query: String,
    skip: Int,
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(
            apiPath = "searchpostsbytitle?${QUERY_PARAM}=$query&${SKIP_PARAM}=$skip"
        )?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e.message)
        onError(e)
    }
}

/**
 * Suspended function to delete selected posts.
 *
 * @param ids The IDs of the posts to delete.
 * @return True if the posts are deleted successfully, false otherwise.
 */
suspend fun deleteSelectedPosts(ids: List<String>): Boolean {
    return try {
        val result = window.api.tryPost(
            apiPath = "deleteselectedposts",
            body = Json.encodeToString(ids).encodeToByteArray()
        )?.decodeToString()
        result.toBoolean()
    } catch (e: Exception) {
        println(e.message)
        false
    }
}


/**
 * Suspended function to fetch a selected post.
 *
 * @param id The ID of the post to fetch.
 * @return ApiResponse containing the fetched post or an error message.
 */
suspend fun fetchSelectedPost(id: String): ApiResponse {
    return try {
        val result = window.api.tryGet(
            apiPath = "readselectedpost?${POST_ID_PARAM}=$id"
        )?.decodeToString()
        result?.parseData() ?: ApiResponse.Error(message = "Result is null")
    } catch (e: Exception) {
        println(e)
        ApiResponse.Error(message = e.message.toString())
    }
}

/**
 * Suspended function to fetch main posts.
 *
 * @param onSuccess Callback function to execute when fetching main posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun fetchMainPosts(
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(apiPath = "readmainposts")?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

/**
 * Suspended function to fetch portfolio posts.
 *
 * @param skip The number of posts to skip.
 * @param onSuccess Callback function to execute when fetching portfolio posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun fetchPortfolioPosts(
    skip: Int,
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result =
            window.api.tryGet(apiPath = "readlatestposts?${SKIP_PARAM}=$skip")?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

/**
 * Suspended function to fetch popular posts.
 *
 * @param skip The number of posts to skip.
 * @param onSuccess Callback function to execute when fetching popular posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun fetchPopularPosts(
    skip: Int,
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result =
            window.api.tryGet(apiPath = "readpopularposts?${SKIP_PARAM}=$skip")?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

/**
 * Suspended function to fetch sponsored posts.
 *
 * @param onSuccess Callback function to execute when fetching sponsored posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun fetchSponsoredPosts(
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(apiPath = "readsponsoredposts")?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e)
        onError(e)
    }
}

/**
 * Suspended function to search posts by category.
 *
 * @param category The category to search for.
 * @param skip The number of posts to skip.
 * @param onSuccess Callback function to execute when fetching posts is successful.
 * @param onError Callback function to execute when an error occurs during fetching.
 */
suspend fun searchPostsByCategory(
    category: Category,
    skip: Int,
    onSuccess: (ApiListResponse) -> Unit,
    onError: (Exception) -> Unit
) {
    try {
        val result = window.api.tryGet(
            apiPath = "searchpostsbycategory?${CATEGORY_PARAM}=${category.name}&${SKIP_PARAM}=$skip"
        )?.decodeToString()
        onSuccess(result.parseData())
    } catch (e: Exception) {
        println(e.message)
        onError(e)
    }
}

/**
 * Suspended function to subscribe to the newsletter.
 *
 * @param newsLetter The newsletter subscription data.
 * @return The response message after subscribing.
 */
suspend fun subscribeToNewsLetter(
    newsLetter: NewsLetter
) : String {
    return window.api.tryPost(
        apiPath = "subscribe",
        body = Json.encodeToString(newsLetter).encodeToByteArray()
    )?.decodeToString().toString().replace("\"", "")
}

/**
 * Inline function to parse JSON data.
 *
 * @param T The type of data to parse.
 * @return Parsed data of type T.
 */
inline fun <reified T> String?.parseData(): T {
    return Json.decodeFromString(this.toString())
}