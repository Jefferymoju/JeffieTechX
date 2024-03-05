package com.jeffery.jeffietechx.pages.portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_components.CategoryNavigationItems
import com.jeffery.jeffietechx.pages.blog.blog_components.SearchBar
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLInputElement

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
                desc = "Logo Image"
            )
    }
}