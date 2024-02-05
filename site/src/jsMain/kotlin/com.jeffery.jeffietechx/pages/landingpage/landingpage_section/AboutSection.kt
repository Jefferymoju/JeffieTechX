package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.AboutMeSkills
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.SectionTitle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants.ABOUT_ME_TEXT
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection(){
    Box (
        modifier = Modifier
            .id(Section.About.id)
            .fillMaxWidth()
            .maxWidth(PAGE_WIDTH.px)
            .backgroundColor(Theme.Secondary.rgb)
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ){
        AboutContent()
    }
}

@Composable
fun AboutContent(){
    val breakpoint = rememberBreakpoint()
    Column (modifier = Modifier
        .fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        )
        .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            AboutMe(breakpoint = breakpoint)
            if (breakpoint >= Breakpoint.MD){
                AboutImage()
            }
        }
    }
}

@Composable
fun AboutImage(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .margin(left = 35.px)
            .padding(left = 35.px),
        contentAlignment = Alignment.Center
    ){
      Row (
          modifier = Modifier
              .fillMaxWidth()
              .align(Alignment.Center),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
      ){
            AboutMeSkills()
            Image(
                modifier = Modifier
                    .fillMaxHeight(90.percent)
                    .fillMaxWidth(70.percent),
                src = Res.Image.about,
                desc = "About Image"
            )
        }
    }
}

@Composable
fun AboutMe(breakpoint: Breakpoint){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .margin(if (breakpoint >= Breakpoint.MD) 40.px else 0.px),
        verticalArrangement = Arrangement.Center
    ){
        SectionTitle(section = Section.About)
        P (
            attrs = Modifier
                .margin(topBottom = 25.px)
                .maxWidth(450.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(20.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Normal)
                .color(Theme.White.rgb)
                .toAttrs()
        ){
            Text(ABOUT_ME_TEXT)
        }
    }
}
