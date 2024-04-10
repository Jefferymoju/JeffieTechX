package com.jeffery.jeffietechx.pages.blog.blog_models

/**
 * Represents a user entity.
 * @property _id The unique identifier of the user.
 * @property username The username of the user.
 * @property password The password of the user.
 */
expect class User{
    val _id: String
    val username: String
    val password: String
}

/**
 * Represents a user entity without password information.
 * @property _id The unique identifier of the user.
 * @property username The username of the user.
 */
expect class UserWithoutPassword {
    val _id : String
    val username: String
}