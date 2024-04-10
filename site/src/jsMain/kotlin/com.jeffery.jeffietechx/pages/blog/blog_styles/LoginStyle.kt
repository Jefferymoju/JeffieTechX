package com.jeffery.jeffietechx.pages.blog.blog_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

/**
 * Component style for login input fields.
 *
 * @param base The base style for the login input component. It sets the border width to 1 pixel, border style to solid, and border color to the primary theme color. It also adds a transition effect for border changes with a duration of 400 milliseconds.
 * @param focus The style applied when the login input component is focused. It sets the border width to 3 pixels, border style to groove, and border color to the primary theme color.
 */
val LoginInputStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .transition(CSSTransition(property = "border", duration = 400.ms))
    }
    focus {
        Modifier.border(
            width = 3.px,
            style = LineStyle.Groove,
            color = Theme.Primary.rgb
        )
    }
}

/**
 * Component style for the login button.
 *
 * @param base The base style for the login button component. It sets the border radius to 10 pixels and adds a transition effect for border radius changes with a duration of 500 milliseconds.
 * @param hover The style applied when hovering over the login button component. It sets the border radius to 30 pixels.
 */
val LoginButtonStyle by ComponentStyle {
    base {
        Modifier
            .borderRadius(r = 10.px)
            .transition(CSSTransition(property = "border-radius", duration = 500.ms))
    }
    hover {
        Modifier
            .borderRadius(r = 30.px)
    }
}