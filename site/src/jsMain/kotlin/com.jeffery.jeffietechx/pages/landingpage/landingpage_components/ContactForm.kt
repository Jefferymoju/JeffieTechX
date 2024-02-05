package com.jeffery.jeffietechx.pages.landingpage.landingpage_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.util.Constants.FORM_LINK
import com.jeffery.jeffietechx.util.Theme
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.InputStyle
import com.jeffery.jeffietechx.pages.landingpage.landingpage_styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun ContactForm(breakpoint: Breakpoint) {
   Box (
       modifier = Modifier
           .margin(all = 20.px)
           .padding(all = 20.px)
           .borderRadius(r = 10.px)
           .border(
               width = 3.px,
               style = LineStyle.Solid,
               color = Theme.Primary.rgb
           )
           .fillMaxHeight(),
       contentAlignment = Alignment.Center,
   ){
       Form (
           action = FORM_LINK,
           attrs = Modifier
               .attrsModifier {
                   attr("method", "POST")
               }
               .toAttrs()
       ){
           Input(
               type = InputType.Text,
               attrs = InputStyle.toModifier()
                   .id("inputName")
                   .classNames("form-control")
                   .padding(top = 20.px)
                   .margin(topBottom = 15.px)
                   .width(
                       if (breakpoint >= Breakpoint.MD) 300.px
                       else 150.px
                   )
                   .backgroundColor(Theme.Secondary.rgb)
                   .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                   .attrsModifier {
                       attr("placeholder", " Name")
                       attr("name", "name")
                       attr("required", "true")
                   }
                   .toAttrs(),
           )
           Input(
               type = InputType.Text,
               attrs = InputStyle.toModifier()
                   .id("inputEmail")
                   .classNames("form-control")
                   .margin(bottom = 10.px)
                   .width(
                       if (breakpoint >= Breakpoint.MD) 300.px
                       else 150.px
                   )
                   .backgroundColor(Theme.Secondary.rgb)
                   .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                   .attrsModifier {
                       attr("placeholder", "Email")
                       attr("name", "email")
                       attr("required", "true")
                   }
                   .toAttrs(),
           )
           TextArea (
               attrs = InputStyle.toModifier()
                   .id("inputMessage")
                   .classNames("form-control")
                   .height(170.px)
                   .margin(bottom = 20.px)
                   .width(
                       if (breakpoint >= Breakpoint.MD) 300.px
                       else 150.px
                   )
                   .backgroundColor(Theme.Secondary.rgb)
                   .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                   .attrsModifier {
                       attr("placeholder", "Message")
                       attr("name", "message")
                       attr("required", "true")
                   }
                   .toAttrs(),
           )
           Box (
               modifier = Modifier
                   .fillMaxWidth()
                   .margin(bottom = 15.px)
                   .padding(bottom = 15.px)
               ,
               contentAlignment = Alignment.Center
           ){
               Button(
                   attrs = MainButtonStyle.toModifier()
                       .height(40.px)
                       .border(width = 0.px)
                       .borderRadius(r = 5.px)
                       .backgroundColor(Theme.Primary.rgb)
                       .color(Colors.White)
                       .cursor(Cursor.Pointer)
                       .toAttrs()
               ) {
                   Text("Submit")
               }
           }
       }
   }
}