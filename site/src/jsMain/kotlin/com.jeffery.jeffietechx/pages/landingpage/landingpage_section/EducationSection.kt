package com.jeffery.jeffietechx.pages.landingpage.landingpage_section

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.SectionTitle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Education
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Section
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
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
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
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

/**
 * Composable function for the Education section.
 */
@Composable
fun EducationSection(){
    Box (
        modifier = Modifier
            .id(Section.Education.id)
            .maxWidth(Constants.PAGE_WIDTH.px)
            .fillMaxWidth()
            .backgroundColor(Theme.SecondaryLight.rgb)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ){
        EducationContent()
    }
}

/**
 * Composable function for the content of the Education section.
 */
@Composable
fun EducationContent(){
    val breakpoint = rememberBreakpoint()
    Column (modifier = Modifier
        .fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 95.percent
            else 85.percent
        )
        .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 3)
        ){
            EducationText(breakpoint = breakpoint)
            if (breakpoint >= Breakpoint.MD){
                EducationImage()
            }
        }
    }

}

/**
 * Composable function for displaying the image in the Education section.
 */
@Composable
fun EducationImage(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = 20.px, top = 130.px, right = 10.px)
            .padding(left = 25.px, right = 10.px),
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .fillMaxHeight(70.percent)
                    .fillMaxWidth(),
                src = Res.Image.study,
                description = "Study Image"
            )
            P (
                attrs = Modifier
                    .margin(all = 10.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(17.px)
                    .fontWeight(FontWeight.Normal)
                    .fontStyle(FontStyle.Normal)
                    .color(Theme.Gray.rgb)
                    .toAttrs()
            ){
                Text("Education allows us build revolutionary ideas")
            }
        }
    }
}

/**
 * Composable function for displaying the text in the Education section.
 */
@Composable
fun EducationText(
    breakpoint: Breakpoint,
){
  Column(
      modifier = Modifier
          .margin(if (breakpoint >= Breakpoint.MD) 20.px else 0.px)
          .width(300.px)
          .height(80.percent)
          .fillMaxHeight()
          .fillMaxWidth(),
      verticalArrangement = Arrangement.Center
  ) {
      SectionTitle(
          section = Section.Education,
          modifier = Modifier.margin(bottom = 25.px)
      )
     Column (
          modifier = Modifier
              .margin(leftRight = 20.px)
              .padding(right = 10.px)
              .fillMaxWidth(),
      ){
              Education.entries.toTypedArray().take(3).forEach { education ->
                 Row (
                     modifier = Modifier
                         .fillMaxWidth()
                         .fillMaxHeight()
                         .margin(topBottom = 10.px),
                 ){
                     P (
                         attrs = Modifier
                             .fontFamily(FONT_FAMILY)
                             .fontSize(20.px)
                             .margin(topBottom = 10.px)
                             .fontWeight(FontWeight.Normal)
                             .fontStyle(FontStyle.Normal)
                             .color(Theme.Primary.rgb)
                             .toAttrs()
                     ){
                         Text(education.date)
                     }
                     Column(
                         modifier = Modifier
                             .margin(left = 20.px)
                     ) {
                         P (
                             attrs = Modifier
                                 .margin(all = 0.px)
                                 .fontFamily(FONT_FAMILY)
                                 .fontSize(15.px)
                                 .fontWeight(FontWeight.Normal)
                                 .fontStyle(FontStyle.Normal)
                                 .color(Theme.White.rgb)
                                 .toAttrs()
                         ){
                             Text(education.title)
                         }
                         P (
                             attrs = Modifier
                                 .fontFamily(FONT_FAMILY)
                                 .margin(all = 0.px)
                                 .fontSize(14.px)
                                 .fontWeight(FontWeight.Normal)
                                 .fontStyle(FontStyle.Normal)
                                 .color(Theme.Gray.rgb)
                                 .toAttrs()
                         ){
                             Text(education.subtitle)
                         }
                     }
                 }
              }


      }
  }
    Column(
        modifier = Modifier
            .width(300.px)
            .height(80.percent)
            .margin(top = if (breakpoint >= Breakpoint.MD) 70.px else 10.px,
                left = if (breakpoint >= Breakpoint.MD) 35.px else 0.px,
                right = if (breakpoint >= Breakpoint.MD) 20.px else 15.px,
                bottom = if (breakpoint >= Breakpoint.MD) 20.px else 0.px
            )
            .padding(right = 15.px)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Column (
            modifier = Modifier
                .margin(leftRight = 20.px)
                .fillMaxWidth(),
        ){
            Education.entries.toTypedArray().takeLast(3).forEach { education ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .margin(topBottom = 10.px),
                ){
                    P (
                        attrs = Modifier
                            .fontFamily(FONT_FAMILY)
                            .margin(topBottom = 10.px)
                            .fontSize(20.px)
                            .fontWeight(FontWeight.Normal)
                            .fontStyle(FontStyle.Normal)
                            .color(Theme.Primary.rgb)
                            .toAttrs()
                    ){
                        Text(education.date)
                    }
                    Column(
                        modifier = Modifier
                            .margin(left = if (breakpoint >= Breakpoint.MD)20.px else 40.px)
                    ) {
                        P (
                            attrs = Modifier
                                .margin(all = 0.px)
                                .fontFamily(FONT_FAMILY)
                                .fontSize(15.px)
                                .fontWeight(FontWeight.Normal)
                                .fontStyle(FontStyle.Normal)
                                .color(Theme.White.rgb)
                                .toAttrs()
                        ){
                            Text(education.title)
                        }
                        P (
                            attrs = Modifier
                                .fontFamily(FONT_FAMILY)
                                .margin(all = 0.px)
                                .fontSize(14.px)
                                .fontWeight(FontWeight.Normal)
                                .fontStyle(FontStyle.Normal)
                                .color(Theme.Gray.rgb)
                                .toAttrs()
                        ){
                            Text(education.subtitle)
                        }
                    }
                }
            }


        }
    }
}