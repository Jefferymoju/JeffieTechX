package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.Serializable

@Serializable
data class RandomJoke(
    val id: Int,
    val joke: String
)
