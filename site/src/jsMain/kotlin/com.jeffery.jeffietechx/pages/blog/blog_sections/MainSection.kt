package com.jeffery.jeffietechx.pages.blog.blog_sections

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_components.PostPreview
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiListResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun MainSection(
    breakpoint : Breakpoint,
    posts : ApiListResponse,
    onClick: (String) -> Unit
){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(Theme.SecondaryLight.rgb),
        contentAlignment = Alignment.Center
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(PAGE_WIDTH.px),
            contentAlignment = Alignment.Center
        ){
            when (posts) {
                is ApiListResponse.Idle -> {}
                is ApiListResponse.Success -> {
                    MainPosts(
                        breakpoint = breakpoint,
                        posts = posts.data,
                        onClick = onClick
                    )
                }
                is ApiListResponse.Error -> {}
            }
        }
    }
}

@Composable
fun MainPosts(
    breakpoint: Breakpoint,
    posts: List<PostWithoutDetails>,
    onClick: (String) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint > Breakpoint.MD) 80.percent
                else 90.percent
            )
            .margin(topBottom = 50.px)
    ){
            if (breakpoint == Breakpoint.XL) {
                    PostPreview(
                        post = posts.first(),
                        thumbnailHeight = 470.px,
                        onClick = {onClick(posts.first()._id)}
                    )
                    Row  (
                        modifier = Modifier
                            .fillMaxWidth(95.percent)
                    ){
                        posts.drop(1).forEach { postWithoutDetails ->
                            PostPreview(
                                modifier = Modifier.margin(right = 10.px),
                                post = postWithoutDetails,
                                vertical = false,
                                thumbnailHeight = 150.px,
                                titleMaxLines = 2,
                                onClick = { onClick(postWithoutDetails._id)}
                            )
                        }
                    }

            } else if (breakpoint >= Breakpoint.LG) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Box (
                        modifier = Modifier
                            .margin(right = 10.px)
                    ){
                        PostPreview(
                            post = posts.first(),
                            thumbnailHeight = 300.px,
                            onClick = { onClick(posts.first()._id)}
                        )
                    }
                    Box (
                        modifier = Modifier
                            .margin(left = 10.px)
                    ){
                        PostPreview(
                            post = posts[1],
                            thumbnailHeight = 300.px,
                            onClick = { onClick(posts[1]._id)}
                        )
                    }
                }
            } else {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    PostPreview(
                        post = posts.first(),
                        thumbnailHeight = 500.px,
                        onClick = { onClick(posts.first()._id)}
                    )
                }
            }
    }
}