package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

/**
 * Composable function for displaying a category chip.
 *
 * @param category The category to display in the chip.
 */
@Composable
fun CategoryChip(
    category: Category,
) {
    Box (
        modifier = Modifier
            .height(32.px)
            .padding(leftRight = 15.px)
            .borderRadius(r = 100.px)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.entries.find { it.hex == category.color }?.rgb
            ),
        contentAlignment = Alignment.Center
    ){
        SpanText(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(12.px)
                .color(
                    Theme.entries.find { it.hex == category.color }?.rgb ?: Theme.Gray.rgb
                ),
            text = category.name
        )
    }
}