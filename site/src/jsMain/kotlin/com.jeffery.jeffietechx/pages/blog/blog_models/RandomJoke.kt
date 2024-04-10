package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.Serializable

/**
 * Serializable data class representing a random joke.
 *
 * @property id The ID of the joke.
 * @property joke The content of the joke.
 */
@Serializable
data class RandomJoke(
    val id: Int,
    val joke: String
)
