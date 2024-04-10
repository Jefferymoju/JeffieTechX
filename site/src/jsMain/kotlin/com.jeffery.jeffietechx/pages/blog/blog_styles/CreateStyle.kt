package com.jeffery.jeffietechx.pages.blog.blog_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms

/**
 * Component style for the editor key.
 *
 * @param base The base style for the editor key component. It sets the background color to transparent and adds a transition effect for background changes with a duration of 300 milliseconds.
 * @param hover The style applied when hovering over the editor key component. It changes the background color to the primary theme color.
 */
val EditorKeyStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "background", duration = 300.ms))
    }
    hover {
        Modifier.backgroundColor(Theme.Primary.rgb)
    }
}