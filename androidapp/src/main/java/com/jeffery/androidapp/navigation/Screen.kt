package com.jeffery.androidapp.navigation

import com.jeffery.androidapp.util.Constants.CATEGORY_ARGUMENT
import com.jeffery.androidapp.util.Constants.POST_ID_ARGUMENT
import com.jeffery.jeffietechx.pages.blog.blog_models.Category

sealed class Screen(val route: String) {

    object Home : Screen(route = "home_screen")

    object Category : Screen(route = "category_screen/{${CATEGORY_ARGUMENT}}") {
        fun passCategory(category: com.jeffery.jeffietechx.pages.blog.blog_models.Category ) = "category_screen/${category.name}"
    }

    object Details: Screen(route = "details_screen/{${POST_ID_ARGUMENT}}") {
        fun passPostId(id: String) = "details_screen/${id}"
    }
}