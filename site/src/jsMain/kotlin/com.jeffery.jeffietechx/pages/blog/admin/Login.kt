package com.jeffery.jeffietechx.pages.blog.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_models.User
import com.jeffery.jeffietechx.pages.blog.blog_models.UserWithoutPassword
import com.jeffery.jeffietechx.pages.blog.blog_styles.LoginButtonStyle
import com.jeffery.jeffietechx.pages.blog.blog_styles.LoginInputStyle
import com.jeffery.jeffietechx.pages.blog.blog_util.checkUserExistence
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
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
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.set

@Page
@Composable
fun SignInScreen() {
    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    var textError by remember { mutableStateOf(" ") }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Theme.SecondaryLight.rgb),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .padding(leftRight = 30.px, top = 75.px, bottom = 25.px)
                .backgroundColor(Colors.Transparent)
                .borderRadius(r = 25.px)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .margin(bottom = 45.px)
                    .width(150.px),
                src = Res.Image.logoBlog,
                desc = "Logo",
            )

            Input(
                type = InputType.Text,
                attrs =  LoginInputStyle.toModifier()
                    .id("usernameInput")
                    .margin(bottom = 10.px)
                    .width(300.px)
                    .height(50.px)
                    .padding(leftRight = 20.px)
                    .color(Theme.White.rgb)
                    .backgroundColor(Colors.Transparent)
                    .borderRadius(r = 15.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(15.px)
                    .outline(
                        width = 0.px,
                        style = LineStyle.None,
                        color = Colors.Transparent
                    )
                    .toAttrs{
                        attr("placeholder", "Username")
                    }
            )

            Input(
                type = InputType.Password,
                attrs =  LoginInputStyle.toModifier()
                    .id("passwordInput")
                    .margin(bottom = 20.px)
                    .width(300.px)
                    .height(50.px)
                    .padding(leftRight = 20.px)
                    .color(Theme.White.rgb)
                    .borderRadius(r = 15.px)
                    .backgroundColor(Colors.Transparent)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(15.px)
                    .outline(
                        width = 0.px,
                        style = LineStyle.None,
                        color = Colors.Transparent
                    )
                    .toAttrs {
                        attr("placeholder", "Password")
                    }
            )
            Button (
                attrs = LoginButtonStyle.toModifier()
                    .margin(bottom = 25.px)
                    .width(300.px)
                    .height(50.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .border(
                        width = 2.px,
                        style = LineStyle.Solid,
                        color = Theme.Secondary.rgb
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Medium)
                    .fontSize(15.px)
                    .cursor(Cursor.Pointer)
                    .onClick {
                        scope.launch {
                            val username =
                                (document.getElementById(Res.Id.usernameInput) as HTMLInputElement).value
                            val password =
                                (document.getElementById(Res.Id.passwordInput) as HTMLInputElement).value
                            if (username.isNotEmpty() && password.isNotEmpty()) {
                                val user = checkUserExistence(
                                    user = User(
                                        username = username,
                                        password = password
                                    )
                                )
                                if (user != null) {
                                    rememberLogIn(remember = true, user = user)
                                    context.router.navigateTo(Screen.AdminHome.route)
                                } else {
                                    textError = "The user doesn't exist."
                                    delay(3000)
                                    textError = " "
                                }
                            } else {
                                textError = "Input fields are empty."
                                delay(3000)
                                textError = " "
                            }
                        }
                    }
                    .toAttrs()
            ){
                SpanText(text = "Log In")
            }
            SpanText(
                modifier = Modifier
                    .width(300.px)
                    .color(Colors.Red)
                    .textAlign(TextAlign.Center)
                    .fontFamily(FONT_FAMILY),
                text = textError
            )
        }
    }
}

private fun rememberLogIn(
    remember: Boolean,
    user: UserWithoutPassword? = null
) {
    localStorage["remember"] = remember.toString()
    if (user != null) {
        localStorage["userId"] = user._id
        localStorage["username"] = user.username
    }
}