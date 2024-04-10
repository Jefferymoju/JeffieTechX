package com.jeffery.jeffietechx.pages.blog.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.UPDATED_PARAM
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun SuccessPage() {
    val context = rememberPageContext()
    val postUpdated = context.route.params.containsKey(UPDATED_PARAM)


    // Navigate back to the admin create screen after a delay of 2 secs
    LaunchedEffect(Unit) {
        delay(2000)
        context.router.navigateTo(Screen.AdminCreate.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Theme.SecondaryLight.rgb)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.margin(bottom = 25.px),
            src = Res.Icon.checkmark,
            description = "Checkmark Icon"
        )
        SpanText(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .color(Theme.White.rgb)
                .fontSize(25.px),
            text = if(postUpdated) "Post Successfully Updated!" else "Post Successfully Created!"
        )
        SpanText(
            modifier = Modifier
                .color(Theme.Primary.rgb)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px),
            text = "Redirecting you back..."
        )
    }
}