package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.pages.blog.blog_util.parseDateString
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextOverflow
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textOverflow
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.CheckboxInput

/**
 * Composable function for rendering a post preview.
 *
 * @param modifier The modifier for positioning and styling the post preview.
 * @param post The post to display in the preview.
 * @param selectableMode Flag indicating whether selectable mode is enabled.
 * @param mainSection Flag indicating whether the post is in the main section.
 * @param vertical Flag indicating whether the post preview is in a vertical layout.
 * @param thumbnailHeight Height of the post thumbnail.
 * @param titleMaxLines Maximum number of lines for the post title.
 * @param titleColor Color of the post title.
 * @param onSelect Callback invoked when a post is selected.
 * @param onDeselect Callback invoked when a post is deselected.
 * @param onClick Callback invoked when the post preview is clicked.
 */
@Composable
fun PostPreview(
    modifier: Modifier = Modifier,
    post: PostWithoutDetails,
    selectableMode: Boolean = false,
    mainSection: Boolean = false,
    vertical : Boolean = true,
    thumbnailHeight: CSSSizeValue<CSSUnit.px> = 200.px,
    titleMaxLines: Int = 2,
    titleColor: CSSColorValue = Theme.White.rgb,
    onSelect: (String) -> Unit = {},
    onDeselect: (String) -> Unit = {},
    onClick: (String) -> Unit
) {
    var checked by remember (selectableMode){ mutableStateOf(false) }
    if (vertical) {
        Column (
            modifier = Modifier
                .fillMaxWidth(
                    if (mainSection) 100.percent
                    else if (titleColor == Theme.Sponsored.rgb) 100.percent
                    else 95.percent
                )
                .margin(bottom = 25.px)
                .padding(all = if (selectableMode) 10.px else 0.px)
                .borderRadius(r = 5.px)
                .border(
                    width = if (selectableMode) 3.px else (0.5).px,
                    style = if (selectableMode) LineStyle.Solid else LineStyle.Solid,
                    color = if (checked) Theme.Primary.rgb else Theme.Secondary.rgb
                )
                .onClick {
                    if (selectableMode) {
                        checked = !checked
                        if (checked) {
                            onSelect(post._id)
                        } else {
                            onDeselect(post._id)
                        }
                    } else {
                        onClick(post._id)
                    }
                }
                .transition(CSSTransition(property = TransitionProperty.All, duration = 200.ms))
                .cursor(Cursor.Pointer)
        ){
                PostsContent(
                    post = post,
                    selectableMode = selectableMode,
                    mainSection = mainSection,
                    vertical = vertical,
                    thumbnailHeight = thumbnailHeight,
                    titleMaxLines = titleMaxLines,
                    titleColor = titleColor,
                    checked = checked
                )
        }
    } else {
        Row (
            modifier = Modifier
                .height(thumbnailHeight)
                .margin(all = 10.px)
                .onClick { onClick(post._id) }
                .cursor(Cursor.Pointer)
        ){
            PostsContent(
                post = post,
                selectableMode = selectableMode,
                mainSection = mainSection,
                vertical = vertical,
                thumbnailHeight = thumbnailHeight,
                titleMaxLines = titleMaxLines,
                titleColor = titleColor,
                checked = checked
            )
        }
    }
}

/**
 * Composable function for rendering the content of a post.
 *
 * @param post The post without details to display.
 * @param selectableMode Flag indicating whether selectable mode is enabled.
 * @param mainSection Flag indicating whether the post is in the main section.
 * @param vertical Flag indicating whether the post content is in a vertical layout.
 * @param thumbnailHeight Height of the post thumbnail.
 * @param titleMaxLines Maximum number of lines for the post title.
 * @param titleColor Color of the post title.
 * @param checked Flag indicating whether the post is checked in selectable mode.
 */
@Composable
fun PostsContent(
    post: PostWithoutDetails,
    selectableMode: Boolean,
    mainSection: Boolean,
    vertical: Boolean,
    thumbnailHeight: CSSSizeValue<CSSUnit.px>,
    titleMaxLines: Int,
    titleColor: CSSColorValue,
    checked: Boolean
) {
    Image(
        modifier = Modifier
            .margin(bottom = if (mainSection) 20.px else 16.px)
            .height(size = thumbnailHeight)
            .fillMaxWidth()
            .objectFit(ObjectFit.Cover),
        src = post.thumbnail,
        description = "Post Thumbnail Image"
    )
    Column(
        modifier = Modifier
            .thenIf(
                condition = !vertical,
                other = Modifier.margin(left = 20.px)
            )
            .padding(all = 12.px)
            .fillMaxWidth()
    ) {
        SpanText(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(12.px)
                .color(Theme.Gray.rgb),
            text = post.date.toLong().parseDateString()
        )
        SpanText(
            modifier = Modifier
                .margin(bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.White.rgb)
                .textOverflow(TextOverflow.Ellipsis)
                .overflow(Overflow.Hidden)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "$titleMaxLines")
                    property("line-clamp", "$titleMaxLines")
                    property("-webkit-box-orient", "vertical")
                },
            text = post.title
        )
        SpanText(
            modifier = Modifier
                .margin(bottom = 8.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .color(Theme.LighterGray.rgb)
                .textOverflow(TextOverflow.Ellipsis)
                .overflow(Overflow.Hidden)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-line-clamp", "3")
                    property("line-clamp", "3")
                    property("-webkit-box-orient", "vertical")
                },
            text = post.subtitle
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            CategoryChip(category = post.category)
            if (selectableMode) {
                CheckboxInput(
                    checked = checked,
                    attrs = Modifier
                        .size(20.px)
                        .toAttrs()
                )
            }
        }
    }
}