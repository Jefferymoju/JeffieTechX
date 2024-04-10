package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px

/**
 * Composable function for rendering an error message view.
 *
 * @param message The error message to display.
 */
@Composable
fun ErrorView(
    message: String
){
    Box (
        modifier = Modifier
            .backgroundColor(Theme.SecondaryLighter.rgb)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        SpanText(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .color(Theme.White.rgb)
                .fontWeight(FontWeight.Medium),
            text = message
        )
    }
}