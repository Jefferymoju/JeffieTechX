package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.PortfolioCard
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.SectionTitle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Portfolio
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun PortfolioSection(){
    Box (
        modifier = Modifier
            .id(Section.Project.id)
            .fillMaxWidth()
            .maxWidth(Constants.PAGE_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.SecondaryLight.rgb),
        contentAlignment = Alignment.Center
    ){
        PortfolioContent()
    }
}
@Composable
fun PortfolioContent(){
    val breakpoint = rememberBreakpoint()
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
            alignment = Alignment.CenterHorizontally,
            section = Section.Project
        )
        PortfolioCards(breakpoint = breakpoint)
        Button (
            attrs = Modifier
                .height(60.px)
                .width(140.px)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .borderRadius(r = 5.px)
                .backgroundColor(BackgroundColor.Transparent)
                .cursor(Cursor.Pointer)
                .margin(bottom = 80.px)
                .toAttrs()
        ){
            Link(
                modifier = Modifier
                    .color(Theme.White.rgb)
                    .textDecorationLine(TextDecorationLine.None)
                    .fontSize(15.px),
                text = "See all Projects",
                path = Section.Project.path
            )
        }
    }
}
@Composable
fun PortfolioCards(
    breakpoint: Breakpoint,
){
    Row(
        modifier = Modifier
            .id("scrollableContainer")
            .fillMaxWidth()
            .margin(bottom = 25.px)
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 950.px
                else if (breakpoint > Breakpoint.SM) 625.px
                else 300.px
            )
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
    ) {
       SimpleGrid(numColumns = numColumns(base = 1, md = 3)) {
           Portfolio.values().forEach { portfolio ->
               PortfolioCard(
                   modifier = Modifier.margin(
                       right = 30.px
                   ),
                   portfolio = portfolio
               )
           }
       }
    }
}