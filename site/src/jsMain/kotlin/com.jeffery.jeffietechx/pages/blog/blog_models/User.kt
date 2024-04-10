package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Serializable actual data class representing a user.
 *
 * @property _id The ID of the user.
 * @property username The username of the user.
 * @property password The password of the user.
 */
@Serializable
actual data class User (
    @SerialName(value = "_id")
    actual val _id: String = "",
    actual val username: String = "",
    actual val password: String = ""
)

/**
 * Serializable actual data class representing a user without password.
 *
 * @property _id The ID of the user.
 * @property username The username of the user.
 */
@Serializable
actual data class UserWithoutPassword(
    @SerialName(value = "_id")
    actual val _id: String = "",
    actual val username: String = ""
)