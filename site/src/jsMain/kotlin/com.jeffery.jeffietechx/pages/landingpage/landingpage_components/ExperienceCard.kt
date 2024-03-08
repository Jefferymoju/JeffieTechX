package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Experience
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(experience: Experience) {
    Column (
        modifier = Modifier
            .maxWidth(320.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
            .borderRadius(r = 35.px)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.Blue.rgb
            )
    ){
        P(attrs = Modifier
            .fillMaxWidth()
            .margin(topBottom = 5.px)
            .fontFamily(FONT_FAMILY)
            .fontSize(18.px)
            .color(Theme.White.rgb)
            .fontWeight(FontWeight.Bold)
            .toAttrs()
        ) {
            Text(experience.title)
        }
        P(attrs = Modifier
            .fillMaxWidth()
            .margin(bottom = 12.px)
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .color(Theme.LighterGray.rgb)
            .fontWeight(FontWeight.Normal)
            .toAttrs()
        ) {
            Text(experience.subtitle)
        }
        Row (
        ) {
            ExperienceChip(
                experience = experience.subject
            )
            ExperienceChip(
                experience = experience.date
            )
        }
    }
}