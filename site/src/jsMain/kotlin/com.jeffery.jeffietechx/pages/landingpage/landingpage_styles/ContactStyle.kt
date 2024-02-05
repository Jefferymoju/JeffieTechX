package com.jeffery.jeffietechx.pages.landingpage.landingpage_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val InputStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Secondary.rgb
            )
            .backgroundColor(Theme.Secondary.rgb)
            .color(Theme.White.rgb)
            .borderBottom(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .transition(CSSTransition(property = TransitionProperty.All, duration = 200.ms))
    }
    focus {
        Modifier
            .backgroundColor(Theme.Secondary.rgb)
            .color(Theme.White.rgb)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Secondary.rgb
            )
            .borderBottom(
            width = 3.px,
            style = LineStyle.Solid,
            color = Theme.Gray.rgb
        )
    }
    hover {
        Modifier
            .backgroundColor(Theme.Secondary.rgb)
            .color(Theme.White.rgb)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Secondary.rgb
            )
            .borderBottom(
            width = 3.px,
            style = LineStyle.Solid,
            color = Theme.Gray.rgb
        )
    }
}

val SocialLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(Theme.Gray.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }
    hover {
        Modifier
            .color(Theme.Primary.rgb)
    }
}