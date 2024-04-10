package com.jeffery.jeffietechx.pages.landingpage.landingpage_styles

import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.filter
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

/**
 * Styling for navigation items. It sets the text color and transitions the color property
 * with a duration of 200ms. On hover, it changes the text color to the primary theme color.
 */
val NavigationItemStyle by ComponentStyle {
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

/**
 * Styling for the logo. It sets the initial rotation to 0 degrees and transitions the
 * transform property with a duration of 200ms. On hover, it rotates the logo by 20 degrees.
 */
@OptIn(ExperimentalComposeWebApi::class)
val LogoStyle by ComponentStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(CSSTransition(property = "transform", duration = 200.ms))
    }
    hover {
        Modifier
            .transform { rotate(20.deg) }
    }
}

/**
 * Styling for the main button. It sets the initial width to 130 pixels and transitions
 * the width property with a duration of 200ms. On hover, it increases the width to 150 pixels.
 */
val MainButtonStyle by ComponentStyle {
    base {
        Modifier
            .width(130.px)
            .transition(CSSTransition(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(150.px)
    }
}

/**
 * Styling for the main image. It applies a grayscale filter with 30% intensity and transitions
 * the filter property with a duration of 200ms. On hover, it reduces the grayscale intensity to 10%.
 */
val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier {
                filter(grayscale(30.percent))
            }
            .transition(CSSTransition(property = "filter", duration = 200.ms))
    }
    hover {
        Modifier.styleModifier {
            filter(grayscale(10.percent))
        }
    }
}