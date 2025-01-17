package com.jeffery.jeffietechx.pages.blog.blog_sections

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_components.PostPreview
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.silk.components.icons.fa.FaTag
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

/**
 * Composable function representing the section displaying sponsored posts.
 *
 * @param breakpoint The breakpoint at which the content is displayed.
 * @param posts The list of sponsored posts to be displayed.
 * @param onClick Callback function for when a sponsored post is clicked.
 */
@Composable
fun SponsoredPostsSection(
    breakpoint: Breakpoint,
    posts: List<PostWithoutDetails>,
    onClick: (String) -> Unit
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 100.px)
            .backgroundColor(Theme.Secondary.rgb),
        contentAlignment = Alignment.Center
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(PAGE_WIDTH.px)
                .margin(topBottom = 50.px),
            contentAlignment = Alignment.TopCenter
        ){
            SponsoredPosts(
                breakpoint = breakpoint,
                posts = posts,
                onClick = onClick
            )
        }
    }
}

/**
 * Composable function representing the section displaying sponsored posts.
 *
 * @param breakpoint The breakpoint at which the content is displayed.
 * @param posts The list of sponsored posts to be displayed.
 * @param onClick Callback function for when a sponsored post is clicked.
 */
@Composable
fun SponsoredPosts(
    breakpoint: Breakpoint,
    posts: List<PostWithoutDetails>,
    onClick: (String) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint > Breakpoint.MD) 80.percent
                else 90.percent
            ),
        verticalArrangement = Arrangement.Center
    ){
       Row (
           modifier = Modifier
               .margin(bottom = 30.px),
           verticalAlignment = Alignment.CenterVertically
       ){
           FaTag(
               modifier = Modifier
                   .margin(right = 10.px)
                   .color(Theme.Sponsored.rgb),
               size = IconSize.XL
           )
           SpanText(
               modifier = Modifier
                   .fontFamily(FONT_FAMILY)
                   .fontSize(18.px)
                   .fontWeight(FontWeight.Medium)
                   .color(Theme.Sponsored.rgb),
               text = "Sponsored"
           )
       }
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth(),
            numColumns = numColumns(base = 1, xl = 2)
        ) {
            posts.forEach { post->
                PostPreview(
                    modifier = Modifier
                        .margin(right = 50.px),
                    post = post,
                    vertical = breakpoint < Breakpoint.MD,
                    titleMaxLines = 1,
                    titleColor = Theme.Sponsored.rgb,
                    thumbnailHeight = if (breakpoint >= Breakpoint.MD) 200.px else 300.px,
                    onClick = onClick
                )
            }
        }
    }
}