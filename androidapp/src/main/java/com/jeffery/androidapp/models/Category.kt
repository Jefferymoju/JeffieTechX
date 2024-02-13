package com.jeffery.androidapp.models

import com.jeffery.jeffietechx.pages.blog.CategoryCommon

enum class Category(override val color: String): CategoryCommon {
    Technology(color = ""),
    DataScience(color = ""),
    Design(color = ""),
    AI(color = ""),
    Programming(color = "")
}