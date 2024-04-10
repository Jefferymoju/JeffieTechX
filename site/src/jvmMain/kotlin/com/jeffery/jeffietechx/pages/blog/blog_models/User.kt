package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.Serializable
import org.bson.codecs.ObjectIdGenerator

/**
 * Serializable data class representing a user.
 * @property _id The unique identifier of the user.
 * @property username The username of the user.
 * @property password The password of the user.
 */
@Serializable
actual data class User (
    actual val _id: String = ObjectIdGenerator().generate().toString(),
    actual val username: String = "",
    actual val password: String = ""
)

/**
 * Serializable data class representing a user without password.
 * @property _id The unique identifier of the user.
 * @property username The username of the user.
 */
@Serializable
actual data class UserWithoutPassword(
    actual val _id: String = ObjectIdGenerator().generate().toString(),
    actual val username: String = ""
)