package com.jeffery.jeffietechx.pages.blog.blog_models

import com.jeffery.jeffietechx.pages.blog.CategoryCommon

/**
 * Enum class representing different categories for posts.
 * @property color The color associated with the category.
 */
actual enum class Category(override val color: String): CategoryCommon {
    Technology(color = Theme.Blue.hex),
    DataScience(color = Theme.Green.hex),
    Design(color = Theme.Purple.hex),
    AI(color = Theme.Red.hex),
    Programming(color = Theme.Yellow.hex)
}