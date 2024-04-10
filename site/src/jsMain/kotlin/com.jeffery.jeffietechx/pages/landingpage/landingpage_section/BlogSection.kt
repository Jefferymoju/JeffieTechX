package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.BlogCard
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.SectionTitle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Blog
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function for the Blog section.
 */
@Composable
fun BlogSection(){
    Box (
        modifier = Modifier
            .id(Section.Blog.id)
            .maxWidth(PAGE_WIDTH.px)
            .fillMaxWidth()
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.SecondaryLight.rgb),
        contentAlignment = Alignment.Center
    ){
        BlogContent()
    }
}

/**
 * Composable function for the content of the Blog section.
 */
@Composable
fun BlogContent() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    Column (
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 20.px),
            section = Section.Blog,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(
            modifier = Modifier
                .margin(leftRight = if (breakpoint >= Breakpoint.MD) 200.px else 10.px),
            numColumns = numColumns(base = 1,  md = 2)
        ){
            Blog.entries.forEach { blog ->
                BlogCard(
                    blog = blog,
                    breakpoint = breakpoint
                )
            }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 15.px)
                .padding(bottom = 15.px),
            contentAlignment = Alignment.Center
        ){
            Button (
                attrs = Modifier
                    .height(60.px)
                    .width(120.px)
                    .border(
                        width = 2.px,
                        style = LineStyle.Solid,
                        color = Theme.Primary.rgb
                    )
                    .borderRadius(r = 8.px)
                    .backgroundColor(BackgroundColor.Transparent)
                    .color(Theme.White.rgb)
                    .cursor(Cursor.Pointer)
                    .fontSize(18.px)
                    .onClick { context.router.navigateTo(Screen.HomePage.route) }
                    .toAttrs()
            ){
                Text("Articles")
            }
        }
    }
}