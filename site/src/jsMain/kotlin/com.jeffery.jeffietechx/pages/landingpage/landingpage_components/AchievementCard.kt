package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Achievement
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function for rendering an Achievement Card.
 *
 * @param modifier Modifier for styling and layout customization.
 * @param animatedNumber The animated number to display.
 * @param achievement The achievement object.
 */
@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    animatedNumber: Int,
    achievement: Achievement
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .size(80.px)
                .margin(right = 20.px),
            src = achievement.icon,
            description = "Achievement Icon"
        )
        Column {
            P (
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(30.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.White.rgb)
                    .toAttrs()
            ){
                Text(
                    if (achievement == Achievement.Completed)
                    "${animatedNumber}+" else "$animatedNumber"
                )
            }
            P (
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.LighterGray.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ){
                Text(achievement.description)
            }
        }
    }
}