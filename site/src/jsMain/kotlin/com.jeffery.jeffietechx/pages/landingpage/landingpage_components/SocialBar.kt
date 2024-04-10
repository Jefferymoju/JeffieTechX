package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.INSTAGRAM
import com.jeffery.jeffietechx.util.Constants.LINKEDIN
import com.jeffery.jeffietechx.util.Constants.TWITTER
import com.jeffery.jeffietechx.util.Constants.WHATSAPP
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.SocialLinkStyle
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin
import com.varabyte.kobweb.silk.components.icons.fa.FaTwitter
import com.varabyte.kobweb.silk.components.icons.fa.FaWhatsapp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

/**
 * Composable function for rendering a social media bar.
 */
@Composable
fun SocialBar(breakpoint: Breakpoint){
    Row (
        modifier = Modifier
            .margin(top = 25.px)
            .padding(leftRight = if (breakpoint >= Breakpoint.MD) 25.px
            else 15.px)
            .minHeight(35.px)
            .borderRadius(r = 15.px)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .backgroundColor(BackgroundColor.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        // Render social links
        SocialLinks(breakpoint = breakpoint)
    }
}

/**
 * Composable function for rendering social links.
 */
@Composable
private fun SocialLinks(breakpoint: Breakpoint){
    // WhatsApp link
    Link(
        path = WHATSAPP,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaWhatsapp(
            modifier = SocialLinkStyle.toModifier()
                .margin(right = if (breakpoint >= Breakpoint.MD) 25.px
                else 15.px),
            size = if (breakpoint >= Breakpoint.MD) IconSize.LG
            else IconSize.SM
        )
    }

    // Twitter link
    Link(
        path = TWITTER,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaTwitter(
            modifier = SocialLinkStyle.toModifier()
                .margin(right = if (breakpoint >= Breakpoint.MD) 25.px
                else 15.px),
            size = if (breakpoint >= Breakpoint.MD) IconSize.LG
            else IconSize.SM
        )
    }

    // Instagram link
    Link(
        path = INSTAGRAM,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(right = if (breakpoint >= Breakpoint.MD) 25.px
                else 15.px),
            size = if (breakpoint >= Breakpoint.MD) IconSize.LG
            else IconSize.SM
        )
    }

    // LinkedIn link
    Link(
        path = LINKEDIN,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier(),
            size = if (breakpoint >= Breakpoint.MD) IconSize.LG
            else IconSize.SM
        )
    }
}