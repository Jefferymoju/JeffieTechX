package com.jeffery.jeffietechx.pages.landingpage.landingpage_styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

/**
 * Styling for the portfolio section. It defines CSS rules for different elements within the portfolio section.
 * - Initially, it sets the width of the blue overlay to 0 pixels and transitions the width property with a duration of 500ms.
 * - On hover, it increases the width of the blue overlay to 300 pixels.
 * - It hides the link icon initially and makes it visible on hover.
 */
val PortfolioSectionStyle by ComponentStyle {
    cssRule(" > #columnParent > #boxParent > #blueOverlay") {
        Modifier
            .width(0.px)
            .transition(CSSTransition(property = "width", duration = 500.ms))
    }

    cssRule(":hover > #columnParent > #boxParent > #blueOverlay"){
        Modifier.width(300.px)
    }

    cssRule(" > #columnParent > #boxParent > #blueOverlay > #linkIcon"){
        Modifier.visibility(Visibility.Hidden)
    }

    cssRule(":hover > #columnParent > #boxParent > #blueOverlay > #linkIcon"){
        Modifier.visibility(Visibility.Visible)
    }
}