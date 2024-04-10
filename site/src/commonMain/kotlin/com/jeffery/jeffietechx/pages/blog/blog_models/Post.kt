package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.Serializable

/**
 * Represents a post in the blog.
 * @property _id The unique identifier of the post.
 * @property author The author of the post.
 * @property date The date of the post in milliseconds since epoch.
 * @property title The title of the post.
 * @property subtitle The subtitle of the post.
 * @property thumbnail The URL or base64-encoded image of the post's thumbnail.
 * @property content The content of the post.
 * @property category The category of the post.
 * @property popular Indicates whether the post is popular.
 * @property main Indicates whether the post is a main feature.
 * @property sponsored Indicates whether the post is sponsored.
 */
@Serializable
data class Post(
    val _id: String = "",
    val author: String = "",
    val date: Double = 0.0,
//    val date: Long = 0L,
    val title: String,
    val subtitle: String,
    val thumbnail: String,
    val content: String,
    val category: Category,
    val popular: Boolean = false,
    val main: Boolean = false,
    val sponsored: Boolean = false
)

/**
 * Represents a simplified version of a post without full details.
 * @property _id The unique identifier of the post.
 * @property author The author of the post.
 * @property date The date of the post in milliseconds since epoch.
 * @property title The title of the post.
 * @property subtitle The subtitle of the post.
 * @property thumbnail The URL or base64-encoded image of the post's thumbnail.
 * @property category The category of the post.
 * @property popular Indicates whether the post is popular.
 * @property main Indicates whether the post is a main feature.
 * @property sponsored Indicates whether the post is sponsored.
 */
@Serializable
data class PostWithoutDetails(
    val _id: String = "",
    val author: String,
    val date: Double,
//    val date: Long,
    val title: String,
    val subtitle: String,
    val thumbnail: String,
    val category: Category,
    val popular: Boolean = false,
    val main: Boolean = false,
    val sponsored: Boolean = false
)