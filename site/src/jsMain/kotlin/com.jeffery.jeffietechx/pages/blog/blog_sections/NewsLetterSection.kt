package com.jeffery.jeffietechx.pages.blog.blog_sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_components.MessagePopUp
import com.jeffery.jeffietechx.pages.blog.blog_models.NewsLetter
import com.jeffery.jeffietechx.pages.blog.blog_util.noBorder
import com.jeffery.jeffietechx.pages.blog.blog_util.subscribeToNewsLetter
import com.jeffery.jeffietechx.pages.blog.blog_util.validateEmail
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.PAGE_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
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
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement

/**
 * Composable function representing the newsletter section.
 *
 * @param breakpoint The breakpoint at which the content is displayed.
 */
@Composable
fun NewsLetterSection(
    breakpoint: Breakpoint
) {
    val scope = rememberCoroutineScope()
    var responseMessage by remember { mutableStateOf("") }
    var invalidEmailPopup by remember { mutableStateOf(false) }
    var subscribedPopup by remember { mutableStateOf(false) }

    if (invalidEmailPopup) {
        MessagePopUp(
            message = "Email Address is not valid.",
            onDialogDismiss = {
                invalidEmailPopup = false
            }
        )
    }
    if (subscribedPopup) {
        MessagePopUp(
            message = responseMessage,
            onDialogDismiss = {
                subscribedPopup = false
            }
        )
    }

    Box (
        modifier = Modifier
            .margin(topBottom = 100.px)
            .padding(topBottom = 50.px)
            .fillMaxWidth()
            .backgroundColor(Theme.SecondaryLight.rgb)
            .maxWidth(PAGE_WIDTH.px)
    ){
        NewsLetterContent(
            breakpoint = breakpoint,
            onSubscribed = {
                responseMessage = it
                scope.launch {
                    subscribedPopup = true
                    delay(2000)
                    subscribedPopup = false
                }
            },
            onInvalidEmail = {
                scope.launch {
                    invalidEmailPopup = true
                    delay(2000)
                    invalidEmailPopup = false
                }
            }
        )
    }
}

/**
 * Composable function representing the content for a newsletter section.
 *
 * @param breakpoint The breakpoint at which the content is displayed.
 * @param onSubscribed Callback for when the user successfully subscribes.
 * @param onInvalidEmail Callback for when the entered email is invalid.
 */
@Composable
fun NewsLetterContent(
    breakpoint: Breakpoint,
    onSubscribed: (String) -> Unit,
    onInvalidEmail: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ){
        SpanText(
            modifier = Modifier
                .fillMaxWidth()
                .fontFamily(FONT_FAMILY)
                .color(Theme.White.rgb)
                .fontSize(35.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center),
            text = "Don't miss any New Post."
        )
        SpanText(
            modifier = Modifier
                .fillMaxWidth()
                .fontFamily(FONT_FAMILY)
                .fontSize(35.px)
                .color(Theme.LighterGray.rgb)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center),
            text = "Sign up to our Newsletter"
        )
        SpanText(
            modifier = Modifier
                .margin(top = 5.px)
                .fillMaxWidth()
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Gray.rgb)
                .textAlign(TextAlign.Center),
            text = "Keep up with the latest news and blogs."
        )
        if (breakpoint > Breakpoint.SM) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 40.px),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                SubscriptionForm(
                    vertical = false,
                    onSubscribed = onSubscribed,
                    onInvalidEmail = onInvalidEmail
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 40.px),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SubscriptionForm(
                    vertical = true,
                    onSubscribed = onSubscribed,
                    onInvalidEmail = onInvalidEmail
                )
            }
        }
    }
}

/**
 * Composable function representing a subscription form.
 *
 * @param vertical Indicates if the form should be displayed vertically.
 * @param onSubscribed Callback for when the user subscribes.
 * @param onInvalidEmail Callback for when the email entered is invalid.
 */
@Composable
fun SubscriptionForm(
    vertical: Boolean,
    onSubscribed: (String) -> Unit,
    onInvalidEmail: () -> Unit
) {
    val scope = rememberCoroutineScope()
    Input(
        type = InputType.Text,
        attrs = Modifier
            .id(Res.Id.emailInput)
            .width(300.px)
            .height(55.px)
            .color(Theme.White.rgb)
            .backgroundColor(Theme.SecondaryLight.rgb)
            .padding(leftRight = 25.px)
            .margin(
                right = if (vertical) 0.px else 20.px,
                bottom = if (vertical) 20.px else 0.px
            )
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .borderRadius(100.px)
            .toAttrs{
                attr("placeholder", "Email Address")
            }
    )
    Button (
        attrs = Modifier
            .onClick {
                val  email = (document.getElementById(Res.Id.emailInput) as HTMLInputElement).value
                if (validateEmail(email = email)) {
                    scope.launch {
                        onSubscribed(
                            subscribeToNewsLetter(
                                newsLetter = NewsLetter(email = email)
                            )
                        )
                    }
                } else {
                    onInvalidEmail()
                }
            }
            .height(55.px)
            .backgroundColor(Theme.Primary.rgb)
            .borderRadius(100.px)
            .padding(leftRight = 50.px)
            .noBorder()
            .cursor(Cursor.Pointer)
            .toAttrs()
    ){
        SpanText(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Medium)
                .color(Theme.White.rgb),
            text = "Subscribe"
        )
    }
}