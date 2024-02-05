package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.ProgrammingTools
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProgrammingToolsCard(
    programming: ProgrammingTools
){
    Column(
        modifier = Modifier
            .margin(all = 20.px)
            .padding(all = 10.px)
            .maxWidth(250.px),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (
            modifier = Modifier
                .padding(all = 20.px)
                .margin(bottom = 10.px)
                .height(120.px)
                .width(120.px)
                .borderRadius(100.percent)
                .align(Alignment.CenterHorizontally)
                .border(
                    width = 4.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .backgroundColor(BackgroundColor.Transparent),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.size(60.px),
                src = programming.icon,
                desc = programming.iconDescription
            )
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .fontFamily(Constants.FONT_FAMILY)
                .padding(left = 35.px)
                .fontSize(18.px)
                .align(Alignment.CenterHorizontally)
                .color(Theme.White.rgb)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(programming.title)
        }
    }
}