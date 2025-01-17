package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

/**
 * Composable function for rendering a view containing a list of posts.
 *
 * @param breakpoint The current breakpoint of the screen layout.
 * @param posts The list of posts to display.
 * @param title Optional title for the posts view.
 * @param selectableMode Flag indicating whether selectable mode is enabled.
 * @param onSelect Callback function when a post is selected.
 * @param onDeselect Callback function when a post is deselected.
 * @param showMoreVisibility Flag indicating the visibility of the "Show More" button.
 * @param onShowMore Callback function when the "Show More" button is clicked.
 * @param onClick Callback function when a post is clicked.
 */
@Composable
fun PostsView(
    breakpoint: Breakpoint,
    posts: List<PostWithoutDetails>,
    title: String? = null,
    selectableMode: Boolean = false,
    onSelect: (String) -> Unit = {},
    onDeselect: (String) -> Unit = {},
    showMoreVisibility: Boolean,
    onShowMore: () -> Unit,
    onClick: (String) -> Unit
) {
    Column (
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 80.percent
            else 90.percent
        ),
        verticalArrangement = Arrangement.Center
    ){
        if (title != null) {
            SpanText(
                modifier = Modifier
                    .margin(bottom = 25.px)
                    .fontFamily(FONT_FAMILY)
                    .color(Theme.White.rgb)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium),
                text = title
            )
        }
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(),
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3)
        ) {
            posts.forEach {
                PostPreview(
                    post = it,
                    selectableMode = selectableMode,
                    onSelect = onSelect,
                    onDeselect = onDeselect,
                    onClick = onClick
                )
            }
        }
        SpanText(
            modifier = Modifier
                .fillMaxWidth()
                .margin(topBottom = 50.px)
                .textAlign(TextAlign.Center)
                .fontFamily(FONT_FAMILY)
                .fontSize(15.px)
                .color(Theme.LighterGray.rgb)
                .fontWeight(FontWeight.Medium)
                .cursor(Cursor.Pointer)
                .visibility(if (showMoreVisibility) Visibility.Visible else Visibility.Hidden)
                .onClick { onShowMore() },
            text = "Show More"
        )
    }
}