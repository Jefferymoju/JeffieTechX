package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_models.Blog
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextOverflow
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textOverflow
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function for rendering a Blog Card.
 */
@Composable
fun BlogCard(
    blog: Blog,
    breakpoint: Breakpoint
){
    Column(
        modifier = Modifier
            .maxWidth(
                if (breakpoint > Breakpoint.MD) 500.px
                else if (breakpoint == Breakpoint.MD) 350.px
                else 250.px
            )
            .margin(all = 20.px)
            .padding(all = 20.px)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    if (breakpoint > Breakpoint.MD) 300.px
                    else if (breakpoint == Breakpoint.MD) 220.px
                    else 150.px
                )
                .width(
                    if (breakpoint > Breakpoint.MD) 450.px
                    else if (breakpoint == Breakpoint.MD) 300.px
                    else 200.px
                ),
            src = blog.image,
            description = blog.imageDesc
        )
        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 5.px, bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(
                    if (breakpoint > Breakpoint.MD) 15.px
                    else if (breakpoint == Breakpoint.MD) 12.px
                    else 10.px
                )
                .color(Theme.Gray.rgb)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ){
            Text(blog.date)
        }
        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px,)
                .fontFamily(FONT_FAMILY)
                .fontSize(
                    if (breakpoint > Breakpoint.MD) 25.px
                    else if (breakpoint == Breakpoint.MD) 20.px
                    else 18.px
                )
                .color(Theme.Primary.rgb)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ){
            Text(blog.title)
        }
        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(
                    if (breakpoint > Breakpoint.MD ) 20.px
                    else if (breakpoint == Breakpoint.MD) 17.px
                    else 15.px
                )
                .color(Theme.White.rgb)
                .textOverflow(TextOverflow.Ellipsis)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ){
            Text(blog.subtitle)
        }
    }
}