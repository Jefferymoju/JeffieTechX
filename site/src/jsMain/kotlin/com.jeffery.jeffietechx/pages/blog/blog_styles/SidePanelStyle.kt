package com.jeffery.jeffietechx.pages.blog.blog_styles

import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.ms

/**
 * Component style for blog navigation items.
 *
 * @param cssRule The CSS rules applied to different elements of the blog navigation item component.
 * @param svgParent The parent SVG element ID.
 * @param vectorIcon The vector icon ID within the SVG.
 * @param navigationText The ID of the navigation text element.
 */
val BlogNavigationItemStyle by ComponentStyle {
    cssRule(" > #${Res.Id.svgParent} > #${Res.Id.vectorIcon}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .styleModifier {
                property("stroke", Theme.White.rgb)
            }
    }
    cssRule(":hover > #${Res.Id.svgParent} > #${Res.Id.vectorIcon}") {
        Modifier
            .styleModifier {
                property("stroke", Theme.Primary.hex)
            }
    }
    cssRule(" > #${Res.Id.navigationText}") {
        Modifier
            .transition(CSSTransition(property = TransitionProperty.All, duration = 300.ms))
            .color(Theme.White.rgb)
    }
    cssRule(":hover > #${Res.Id.navigationText}") {
        Modifier.color(Theme.Primary.rgb)
    }
}