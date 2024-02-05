package com.jeffery.jeffietechx.pages.blog.blog_models

actual enum class Category(val color: String) {
    Technology(color = Theme.Blue.hex),
    DataScience(color = Theme.Green.hex),
    Design(color = Theme.Purple.hex),
    AI(color = Theme.Red.hex),
    Programming(color = Theme.Yellow.hex)
}