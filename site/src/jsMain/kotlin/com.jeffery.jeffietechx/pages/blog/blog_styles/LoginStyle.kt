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