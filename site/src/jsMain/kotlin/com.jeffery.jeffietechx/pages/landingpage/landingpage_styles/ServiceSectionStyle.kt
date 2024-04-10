package com.jeffery.jeffietechx.pages.landingpage.landingpage_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

/**
 * Styling for the service cards. It defines CSS rules for different elements within the service cards.
 * - Base styling sets the background color and transitions the border and background properties.
 * - On hover, it adds a border, adjusts border radius, and changes the background color to create a hover effect.
 * - It defines CSS rules for the icon box within the service card, adjusting background color on hover.
 * - Also, it sets the color of paragraph text and transitions it accordingly on hover.
 */
val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .backgroundColor(Theme.SecondaryLight.rgb)
            .transition(
                CSSTransition(property = "border", duration = 200.ms),
                CSSTransition(property = "background", duration = 200.ms)
            )
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Secondary.rgb
            )
            .borderRadius(
                topLeft = 20.px,
                topRight = 20.px,
                bottomLeft = 20.px,
                bottomRight = 0.px
            )
            .backgroundColor(Theme.Secondary.rgb)
    }

    cssRule(" > #iconBox") {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(CSSTransition(property = "background", duration = 200.ms))
    }

    cssRule(":hover > #iconBox") {
        Modifier.backgroundColor(Theme.White.rgb)
    }

    cssRule(" > p"){
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(CSSTransition(property = "color", duration = 200.ms))
    }

    cssRule(":hover > p"){
        Modifier.color(Theme.White.rgb)
    }
}