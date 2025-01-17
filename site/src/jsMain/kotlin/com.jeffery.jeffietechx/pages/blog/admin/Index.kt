package com.jeffery.jeffietechx.pages.blog.admin

import LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_components.AdminPageLayout
import com.jeffery.jeffietechx.pages.blog.blog_models.RandomJoke
import com.jeffery.jeffietechx.pages.blog.blog_util.fetchRandomJoke
import com.jeffery.jeffietechx.pages.blog.blog_util.isUserLoggedIn
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Constants.SIDE_PANEL_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaPlus
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Page
@Composable
fun AdminPage() {
    isUserLoggedIn {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    var randomJoke: RandomJoke? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        fetchRandomJoke { randomJoke = it }
    }
    AdminPageLayout {
        HomeContent(randomJoke = randomJoke)
        AddButton()
    }
}

@Composable
fun HomeContent(randomJoke: RandomJoke?) {
    val breakpoint = rememberBreakpoint()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(left = if (breakpoint > Breakpoint.MD) SIDE_PANEL_WIDTH.px else 0.px),
        contentAlignment = Alignment.Center
    ) {
        // Check if randomJoke is available
        if (randomJoke != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(topBottom = 50.px),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Display laugh image if available
                if (randomJoke.id != -1) {
                    Image(
                        modifier = Modifier
                            .size(150.px)
                            .margin(bottom = 50.px),
                        src = Res.Image.laugh,
                        description = "Laugh Image"
                    )
                }
                // Display joke content
                if (randomJoke.joke.contains("Q:")) {
                    // If joke contains question and answer format
                    SpanText(
                        modifier = Modifier
                            .margin(bottom = 14.px)
                            .fillMaxWidth(40.percent)
                            .textAlign(TextAlign.Center)
                            .color(Theme.White.rgb)
                            .fontSize(28.px)
                            .fontFamily(FONT_FAMILY)
                            .fontWeight(FontWeight.Bold),
                        text = randomJoke.joke.split(":")[1].dropLast(1)
                    )
                    SpanText(
                        modifier = Modifier
                            .fillMaxWidth(40.percent)
                            .textAlign(TextAlign.Center)
                            .color(Theme.Gray.rgb)
                            .fontSize(20.px)
                            .fontFamily(FONT_FAMILY)
                            .fontWeight(FontWeight.Normal),
                        text = randomJoke.joke.split(":").last()
                    )
                } else {
                    // If joke is a single sentence
                    SpanText(
                        modifier = Modifier
                            .margin(bottom = 14.px)
                            .fillMaxWidth(40.percent)
                            .textAlign(TextAlign.Center)
                            .color(Theme.White.rgb)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(28.px)
                            .fontWeight(FontWeight.Bold),
                        text = randomJoke.joke
                    )
                }
            }
        } else {
            // Display loading indicator if randomJoke is null
            LoadingIndicator()
        }
    }
}

/**
 *  A floating add button that remains fixed at the bottom end of the screen even while scrolling
 */
@Composable
fun AddButton() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    Box (
        modifier = Modifier
            .height(100.vh)
            .fillMaxWidth()
            .maxWidth(PAGE_WIDTH.px)
            .position(Position.Fixed)
            .styleModifier {
                property("pointer-events", "none")
            },
        contentAlignment = Alignment.BottomEnd
    ){
        Box (
            modifier = Modifier
                .margin(
                    right = if (breakpoint > Breakpoint.MD) 35.px else 20.px,
                    bottom = if (breakpoint > Breakpoint.MD) 35.px else 20.px
                )
                .backgroundColor(Theme.Primary.rgb)
                .size(if (breakpoint > Breakpoint.MD) 70.px else 35.px)
                .borderRadius(r = 15.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    context.router.navigateTo(Screen.AdminCreate.route)
                }
                .styleModifier {
                    property("pointer-events", "auto")
                },
            contentAlignment = Alignment.Center
        ){
            FaPlus(
                modifier = Modifier.color(Theme.White.rgb),
                size = IconSize.LG
            )
        }
    }
}