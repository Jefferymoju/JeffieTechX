package com.jeffery.jeffietechx.pages.portfolio.sections

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

/**
 * Composable function for the portfolio header section, displaying the logo.
 * @param breakpoint The current breakpoint to adjust layout responsiveness.
 * @param logo The path to the logo image.
 */
@Composable
fun PortfolioHeaderSection(
    breakpoint: Breakpoint,
    logo: String = Res.Image.logoBlog,
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(Theme.Secondary.rgb),
        contentAlignment = Alignment.Center
    ){
        Box (
            modifier = Modifier
                .backgroundColor(Theme.Secondary.rgb)
                .maxWidth(PAGE_WIDTH.px),
            contentAlignment = Alignment.TopCenter
        ){
            PortfolioHeader(
                breakpoint = breakpoint,
                logo = logo
            )
        }
    }
}

/**
 * Composable function for the portfolio header, displaying the logo.
 * @param breakpoint The current breakpoint to adjust layout responsiveness.
 * @param logo The path to the logo image.
 */
@Composable
fun PortfolioHeader(
    breakpoint: Breakpoint,
    logo: String,
){
    Row (
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 85.percent else 90.percent)
            .height(Constants.HEADER_HEIGHT.px),
        verticalAlignment = Alignment.CenterVertically
    ){
            Image(
                modifier = Modifier
                    .margin(right = 60.px)
                    .width(if (breakpoint >= Breakpoint.SM) 150.px else 70.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
//                        context.router.navigateTo(Screen.HomePage.route)
                    },
                src = logo,
                description = "Logo Image"
            )
    }
}