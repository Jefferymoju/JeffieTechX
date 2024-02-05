package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.Header
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.MainButtonStyle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.MainImageStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier

@Composable
fun MainSection(onMenuClicked: () -> Unit){
    Box (
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(PAGE_WIDTH.px)
            .backgroundColor(Theme.Secondary.rgb),
        contentAlignment = Alignment.TopCenter
    ){
        MainContent(onMenuClicked = onMenuClicked)
    }
}

@Composable
fun MainContent(onMenuClicked: () -> Unit){
    val breakpoint = rememberBreakpoint()
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Header(onMenuClicked = onMenuClicked)
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 80.percent
                    else 90.percent
                ),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint = breakpoint)
                JtImage()
            }
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            P (
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if (breakpoint >= Breakpoint.LG) 25.px else 15.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.White.rgb)
                    .toAttrs()
            ){
                Text("Hello, I'm")
            }
            Row {
                P (
                    attrs = Modifier
                        .margin(top = 0.px, bottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .color(Theme.White.rgb)
                        .fontSize(if (breakpoint >= Breakpoint.LG) 65.px else 35.px)
                        .fontWeight(FontWeight.Bolder)
                        .toAttrs()
                ){
                    Text("Jeffery")
                }
                P (
                    attrs = Modifier
                        .margin(top = 0.px, bottom = 0.px, left = 10.px)
                        .fontFamily(FONT_FAMILY)
                        .color(Theme.Primary.rgb)
                        .fontSize(if (breakpoint >= Breakpoint.LG) 65.px else 35.px)
                        .fontWeight(FontWeight.Bolder)
                        .toAttrs()
                ){
                    Text("Moju")
                }
            }
            P (
                attrs = Modifier
                    .margin(top = 0.px, bottom = 25.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(25.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.White.rgb)
                    .toAttrs()
            ){
                Text("Mobile & Web Developer/Designer")
            }
            Button (
                attrs = MainButtonStyle.toModifier()
                    .height(60.px)
                    .width(120.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Theme.White.rgb)
                    .cursor(Cursor.Pointer)
                    .margin(bottom = 80.px)
                    .toAttrs()
            ){
                Link(
                    modifier = Modifier
                        .color(Theme.White.rgb)
                        .textDecorationLine(TextDecorationLine.None)
                        .fontSize(15.px),
                    text = "View Portfolio",
                    path = Section.Project.path
                )
            }
        }
    }
}

@Composable
fun JtImage() {
    Column (
        modifier = MainImageStyle.toModifier()
            .fillMaxSize(80.percent)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom

    ){
        Image(
            modifier = Modifier.fillMaxWidth(),
            src = Res.Image.main,
            desc = "Main Image"
        )
    }
}