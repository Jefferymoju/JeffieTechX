package com.jeffery.jeffietechx.pages.blog.navigation

import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POST_ID_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.QUERY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.UPDATED_PARAM


sealed class Screen(val route: String) {
    object AdminHome : Screen(route = "/blog/admin/")
    object AdminLogin : Screen(route = "/blog/admin/login")
    object AdminCreate: Screen(route = "/blog/admin/create"){
        fun passPostId(id: String) = "/blog/admin/create?${POST_ID_PARAM}=$id"
    }
    object AdminMyPosts : Screen(route = "/blog/admin/myposts") {
        fun searchByTitle(query: String) = "/blog/admin/myposts?${QUERY_PARAM}=$query"
    }

    object AdminSuccess: Screen(route = "/blog/admin/success") {
        fun postUpdated() = "/blog/admin/success?${UPDATED_PARAM}=true"
    }
}
