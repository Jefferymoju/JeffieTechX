package com.jeffery.androidapp.models

import com.jeffery.jeffietechx.pages.blog.CategoryCommon

/**
 * Enum class representing different categories for posts.
 *
 * @property color The color associated with the category.
 */
enum class Category(override val color: String): CategoryCommon {
    Technology(color = ""),
    DataScience(color = ""),
    Design(color = ""),
    AI(color = ""),
    Programming(color = "")
}