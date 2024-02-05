package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.util.Constants
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import org.jetbrains.compose.web.css.px

/**
 *  Handles the entire structure of the admin page and integrates a responsive sidepanel
 */

@Composable
fun AdminPageLayout(content: @Composable () -> Unit) {
    var overflowOpened by remember { mutableStateOf(false) }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Theme.SecondaryLighter.rgb)
        ,
        contentAlignment = Alignment.Center
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(Constants.PAGE_WIDTH.px)
        ){
            SidePanel(onMenuClicked = {
                overflowOpened = true
            })
            if (overflowOpened){
                OverflowSidePanel(
                    onMenuClosed = {
                        overflowOpened = false
                    },
                    content = {
                        NavigationItems()
                    }
                )
            }
            content()
        }
    }
}