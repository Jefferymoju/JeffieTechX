package com.jeffery.jeffietechx.pages.blog.blog_sections

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_components.PostsView
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

/**
 * Composable function representing the section displaying posts.
 *
 * @param breakpoint The breakpoint at which the content is displayed.
 * @param posts The list of posts to be displayed.
 * @param title The title of the section.
 * @param showMoreVisibility Flag indicating whether the "Show More" button should be visible.
 * @param onShowMore Callback function for when the "Show More" button is clicked.
 * @param onClick Callback function for when a post is clicked.
 */
@Composable
fun PostsSection(
    breakpoint: Breakpoint,
    posts: List<PostWithoutDetails>,
    title: String? = null,
    showMoreVisibility: Boolean,
    onShowMore: () -> Unit,
    onClick: (String) -> Unit
) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .margin(topBottom = 50.px)
            .backgroundColor(Theme.Secondary.rgb)
            .maxWidth(PAGE_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ){
        PostsView(
            breakpoint = breakpoint,
            posts = posts,
            title = title,
            showMoreVisibility = showMoreVisibility,
            onShowMore = onShowMore,
            onClick = onClick
        )
    }
}