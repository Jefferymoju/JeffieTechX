package com.jeffery.jeffietechx.api

import com.jeffery.jeffietechx.pages.blog.blog_models.ApiListResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.AUTHOR_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.CATEGORY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POST_ID_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.QUERY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.SKIP_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Post
import com.jeffery.jeffietechx.pages.data.MongoDB
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.Request
import com.varabyte.kobweb.api.http.Response
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.bson.codecs.ObjectIdGenerator

/**
 * Adds a new post to the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "addpost")
suspend fun addPost(context: ApiContext) {
    try {
        val post = context.req.getBody<Post>()
        val newPost = post?.copy(_id = ObjectIdGenerator().generate().toString())
        context.res.setBody(
            newPost?.let {
                context.data.getValue<MongoDB>()
                    .addPost(it)            }
        )
    } catch (e: Exception) {
        context.res.setBody(e.message)
    }
}

/**
 * Updates an existing post in the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "updatepost")
suspend fun updatePost(context: ApiContext) {
    try {
        val updatePost = context.req.getBody<Post>()
        context.res.setBody(
            updatePost?.let {
                context.data.getValue<MongoDB>()
                    .updatePost(it)
            }
        )
    } catch (e : Exception) {
        context.res.setBody(e.message)
    }
}

/**
 * Retrieves posts created by a specific author from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readmyposts")
suspend fun readMyPosts(context: ApiContext) {
    try {
        val skip = context.req.params[SKIP_PARAM]?.toInt() ?: 0
        val author = context.req.params[AUTHOR_PARAM] ?: ""
        val myPosts = context.data.getValue<MongoDB>().readMyPosts(
            skip = skip,
            author = author
        )
        context.res.setBody(ApiListResponse.Success(data = myPosts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Searches posts by their title in the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "searchpostsbytitle")
suspend fun searchPostsByTitle(context: ApiContext) {
    try {
        val query = context.req.params[QUERY_PARAM] ?: ""
        val skip = context.req.params[SKIP_PARAM]?.toInt() ?: 0
        val posts = context.data.getValue<MongoDB>().searchPostsByTitle(
            query = query,
            skip = skip
        )
        context.res.setBody(ApiListResponse.Success(data = posts))
    } catch (e: Exception){
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Deletes selected posts from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "deleteselectedposts")
suspend fun deleteSelectedPosts(context: ApiContext) {
    try {
        val request = context.req.getBody<List<String>>()
        context.res.setBody(request?.let {
            context.data.getValue<MongoDB>().deleteSelectedPosts(ids = it)
        })
    } catch (e : Exception) {
        context.res.setBody(e.message)
    }
}

/**
 * Retrieves a selected post by its ID from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readselectedpost")
suspend fun readSelectedPost(context: ApiContext) {
    val postId = context.req.params[POST_ID_PARAM]
    if (!postId.isNullOrEmpty()) {
        try {
            val selectedPost = context.data.getValue<MongoDB>().readSelectedPost(id = postId)
            context.res.setBody(ApiResponse.Success(data = selectedPost))
        } catch (e: Exception) {
            context.res.setBody(ApiResponse.Error(message = e.message.toString()))
        }
    } else {
        context.res.setBody(ApiResponse.Error(message = "Selected post does not exist."))
    }
}

/**
 * Retrieves main posts from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readmainposts")
suspend fun readMainPosts(context: ApiContext) {
    try {
        val mainPosts = context.data.getValue<MongoDB>().readMainPosts()
        context.res.setBody(ApiListResponse.Success(data = mainPosts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Retrieves the latest posts from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readlatestposts")
suspend fun readLatestPosts(context: ApiContext){
    try {
        val skip = context.req.params[SKIP_PARAM]?.toInt() ?: 0
        val latestPosts = context.data.getValue<MongoDB>().readLatestPosts(skip = skip)
        context.res.setBody(ApiListResponse.Success(data = latestPosts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Retrieves popular posts from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readpopularposts")
suspend fun readPopularPosts(context: ApiContext) {
    try {
        val skip = context.req.params[SKIP_PARAM]?.toInt() ?: 0
        val popularPosts = context.data.getValue<MongoDB>().readPopularPosts(skip = skip)
        context.res.setBody(ApiListResponse.Success(data = popularPosts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}


/**
 * Retrieves sponsored posts from the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "readsponsoredposts")
suspend fun readSponsoredPosts(context: ApiContext) {
    try {
        val sponsoredPosts = context.data.getValue<MongoDB>().readSponsoredPosts()
        context.res.setBody(ApiListResponse.Success(data = sponsoredPosts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Searches posts by category in the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "searchpostsbycategory")
suspend fun searchPostsByCategory(context: ApiContext) {
    try {
        val category =
            Category.valueOf(context.req.params[CATEGORY_PARAM] ?: Category.Programming.name)
        val skip = context.req.params[SKIP_PARAM]?.toInt() ?: 0
        val posts = context.data.getValue<MongoDB>().searchPostsByCategory(
            category = category,
            skip = skip
        )
        context.res.setBody(ApiListResponse.Success(data = posts))
    } catch (e: Exception) {
        context.res.setBody(ApiListResponse.Error(message = e.message.toString()))
    }
}

/**
 * Extension function to set the response body with a specific type of data.
 * @param data The data to be serialized and set as the response body.
 */
inline fun <reified T> Response.setBody(data: T) {
    setBodyText(Json.encodeToString(data))
}


/**
 * Extension function to deserialize the request body into a specified type.
 * @return The deserialized request body or null if the body is empty or cannot be deserialized.
 */
inline fun <reified T> Request.getBody(): T? {
    return body?.decodeToString()?.let { return Json.decodeFromString(it) }
}