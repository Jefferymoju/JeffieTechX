package com.jeffery.jeffietechx.pages.blog.navigation

import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.CATEGORY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POST_ID_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.QUERY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.UPDATED_PARAM


/**
 * Sealed class representing different screens in the application.
 *
 * @property route The route associated with the screen.
 */
sealed class Screen(val route: String) {
    object AdminHome : Screen(route = "/blog/admin/")
    object AdminLogin : Screen(route = "/blog/admin/login")
    object AdminCreate: Screen(route = "/blog/admin/create"){

        /**
         * Generates a route for creating a new post with the specified post ID.
         *
         * @param id The ID of the post.
         * @return The generated route.
         */
        fun passPostId(id: String) = "/blog/admin/create?${POST_ID_PARAM}=$id"
    }
    object AdminMyPosts : Screen(route = "/blog/admin/myposts") {

        /**
         * Generates a route for searching posts by title.
         *
         * @param query The search query.
         * @return The generated route.
         */
        fun searchByTitle(query: String) = "/blog/admin/myposts?${QUERY_PARAM}=$query"
    }

    object AdminSuccess: Screen(route = "/blog/admin/success") {

        /**
         * Generates a route indicating a successful post update.
         *
         * @return The generated route.
         */
        fun postUpdated() = "/blog/admin/success?${UPDATED_PARAM}=true"
    }
    object HomePage : Screen(route = "/blog/")
    object SearchPage : Screen(route = "/blog/search/query") {

        /**
         * Generates a route for searching posts by category.
         *
         * @param category The category to search for.
         * @return The generated route.
         */
        fun searchByCategory(category: Category) =
            "/blog/search/query?${CATEGORY_PARAM}=${category.name}"

        /**
         * Generates a route for searching posts by title.
         *
         * @param query The search query.
         * @return The generated route.
         */
        fun searchByTitle(query: String) = "/blog/search/query?${QUERY_PARAM}=$query"
    }

    object PostPage : Screen(route = "/blog/posts/post") {

        /**
         * Generates a route for retrieving a specific post by ID.
         *
         * @param id The ID of the post.
         * @return The generated route.
         */
        fun getPost(id: String) = "/blog/posts/post?${POST_ID_PARAM}=$id"
    }

    object PortfolioPage : Screen(route = "/portfolio/")
}
