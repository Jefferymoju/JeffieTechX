package com.jeffery.jeffietechx.pages.blog.blog_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms

/**
 * Component style for the category drop-down.
 *
 * @param base The base style for the drop-down component.
 * @param anyLink The style for links within the drop-down component.
 * @param hover The style applied when hovering over the drop-down component.
 */
val CategoryDropDownStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.White.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    anyLink {
        Modifier.color(Theme.White.rgb)
    }
    hover {
        Modifier.color(Theme.Primary.rgb)
    }
}