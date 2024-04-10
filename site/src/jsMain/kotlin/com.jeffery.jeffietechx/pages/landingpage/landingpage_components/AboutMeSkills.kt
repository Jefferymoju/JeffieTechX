package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Skill
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function for rendering the About Me Skills section.
 */
@Composable
fun AboutMeSkills(){
    Column (
        modifier = Modifier
            .margin(right = 13.px, left = 13.px)
            .padding(topBottom = 10.px)
            .width(110.px)
            .borderRadius(r = 5.px)
            .backgroundColor(Theme.SecondaryLighter.rgb),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Skill.entries.forEach { skill ->
            P (
                attrs = Modifier
                    .margin(top = 0.px, bottom = 0.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .color(Theme.Primary.rgb)
                    .fontSize(23.px)
                    .fontWeight(FontWeight.Bolder)
                    .toAttrs()
            ){
                Text(skill.percentage)
            }
            P (
                attrs = Modifier
                    .margin(top = 0.px, bottom = 15.px)
                    .fontFamily(Constants.FONT_FAMILY)
                    .color(Theme.Gray.rgb)
                    .fontSize(13.px)
                    .fontWeight(FontWeight.Bolder)
                    .toAttrs()
            ){
                Text(skill.title)
            }
        }
    }
}