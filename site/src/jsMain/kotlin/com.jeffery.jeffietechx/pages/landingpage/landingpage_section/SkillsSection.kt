package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.ProgrammingToolsCard
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.SectionTitle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.ProgrammingTools
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
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
import com.varabyte.kobweb.compose.ui.modifiers.padding
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

/**
 * Composable function for the Skills section.
 */
@Composable
fun SkillsSection(){
    Box (
        modifier = Modifier
            .id(Section.Skills.id)
            .fillMaxWidth()
            .maxWidth(Constants.PAGE_WIDTH.px)
            .padding(topBottom = 100.px)
            .backgroundColor(Theme.Secondary.rgb),
        contentAlignment = Alignment.Center
    ){
        SkillsContent()
    }
}

/**
 * Composable function for the content of the Skills section.
 */
@Composable
fun SkillsContent(){
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
            section = Section.Skills,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(numColumns = numColumns(base = 1, sm = 3, md = 3, lg = 5)) {
            ProgrammingTools.entries.forEach { programming ->
                ProgrammingToolsCard(programming = programming)
            }
        }
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
                .margin(bottom = 40.px, top = 40.px)
                .toAttrs()
        ){
            Link(
                modifier = Modifier
                    .color(Theme.White.rgb)
                    .textDecorationLine(TextDecorationLine.None)
                    .fontSize(15.px),
                text = "View More",
                path = Section.Project.path
            )
        }
    }
}