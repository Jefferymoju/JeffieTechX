package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Service
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.ServiceCardStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function for rendering a service card.
 */
@Composable
fun ServiceCard(service: Service) {
    Column (
        modifier = ServiceCardStyle.toModifier()
            .maxWidth(250.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
    ){
        // Service icon
        Box (
            modifier = Modifier
                .id("iconBox")
                .padding(all = 10.px)
                .margin(bottom = 20.px)
                .backgroundColor(Theme.White.rgb)
                .align(Alignment.CenterHorizontally)
                .borderRadius(
                    r = 100.percent
                ),
        ){
            Image(
                modifier = Modifier.size(40.px),
                src = service.icon,
                description = service.imageDesc
            )
        }
        // Service title
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px, left = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(22.px)
                .color(Theme.White.rgb)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(service.title)
        }
        // Service description
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 0.px, left = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(17.px)
                .color(Theme.Gray.rgb)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(service.description)
        }
    }
}