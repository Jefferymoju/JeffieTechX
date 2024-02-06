package com.jeffery.jeffietechx.pages.blog.blog_components

import androidx.compose.runtime.Composable
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_styles.CategoryItemStyle
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun CategoryNavigationItems (
    selectedCategory: Category? = null,
    vertical : Boolean = false
){
    val context = rememberPageContext()
    Category.values().forEach { category ->
        Link(
            modifier = CategoryItemStyle.toModifier()
                .thenIf(
                    condition = vertical,
                    other = Modifier.margin(bottom = 25.px)
                )
                .thenIf(
                    condition = !vertical,
                    other = Modifier.margin(right = 25.px)
                )
                .thenIf(
                    condition = selectedCategory == category,
                    other = Modifier.color(Theme.Primary.rgb)
                )
                .fontFamily(FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Medium)
                .textDecorationLine(TextDecorationLine.None)
                .onClick {
                    context.router.navigateTo(Screen.SearchPage.searchByCategory(category))
                },
            path = "",
            text = category.name
        )
    }
}