package com.jeffery.jeffietechx.pages.landingpage.landingpage_styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms

/**
 * Styling for the back-to-top button. It rotates the button by 180 degrees initially
 * and transitions the rotation property with a duration of 200 milliseconds. On hover,
 * it rotates the button back to its original position (0 degrees).
 */
val BackToTopStyle by ComponentStyle {
    base {
        Modifier
            .rotate(a = 180.deg)
            .transition(CSSTransition(property = "rotate", duration = 200.ms))
    }
    hover {
        Modifier.rotate(a = 0.deg)
    }
}