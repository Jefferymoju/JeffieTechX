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
 * Component style for the category item.
 *
 * @param base The base style for the category item component. It sets the color to the white theme color and adds a transition effect for color changes with a duration of 200 milliseconds.
 * @param anyLink The style applied to any link in the category item component. It sets the color to the white theme color.
 * @param hover The style applied when hovering over the category item component. It changes the color to the primary theme color.
 */
val CategoryItemStyle by ComponentStyle {
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