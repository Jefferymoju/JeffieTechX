package com.jeffery.jeffietechx.pages.blog.search

import LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_components.CategoryNavigationItems
import com.jeffery.jeffietechx.pages.blog.blog_components.OverflowSidePanel
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiListResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.CATEGORY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POSTS_PER_PAGE
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.QUERY_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.pages.blog.blog_sections.FooterSection
import com.jeffery.jeffietechx.pages.blog.blog_sections.HeaderSection
import com.jeffery.jeffietechx.pages.blog.blog_sections.PostsSection
import com.jeffery.jeffietechx.pages.blog.blog_util.searchPostsByCategory
import com.jeffery.jeffietechx.pages.blog.blog_util.searchPostsByTitle
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLInputElement

/**
 * Composable function for rendering the search page.
 */
@Suppress("unused")
@Page(routeOverride = "query")
@Composable
fun SearchPage() {
    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    val scope = rememberCoroutineScope()

    var apiResponse by remember { mutableStateOf<ApiListResponse>(ApiListResponse.Idle) }
    var overflowOpened by remember { mutableStateOf(false) }
    val searchedPosts = remember { mutableStateListOf<PostWithoutDetails>() }
    var postsToSkip by remember { mutableStateOf(0) }
    var showMorePosts by remember { mutableStateOf(false) }

    val hasCategoryParam = remember(key1 = context.route) {
        context.route.params.containsKey(CATEGORY_PARAM)
    }
    val hasQueryParam = remember(key1 = context.route) {
        context.route.params.containsKey(QUERY_PARAM)
    }
    val value = remember(key1 = context.route) {
        if (hasCategoryParam) {
            context.route.params.getValue(CATEGORY_PARAM)
        } else if (hasQueryParam) {
            context.route.params.getValue(QUERY_PARAM)
        } else {
            ""
        }
    }

    LaunchedEffect(key1 = context.route) {
        (document.getElementById(Res.Id.adminSearchBar) as HTMLInputElement).value = ""
        showMorePosts = false
        postsToSkip = 0
        if (hasCategoryParam) {
            searchPostsByCategory(
                category = runCatching { Category.valueOf(value) }
                    .getOrElse { Category.Programming },
                skip = postsToSkip,
                onSuccess = { response ->
                    apiResponse = response
                    if (response is ApiListResponse.Success) {
                        searchedPosts.clear()
                        searchedPosts.addAll(response.data)
                        postsToSkip += POSTS_PER_PAGE
                        if (response.data.size >= POSTS_PER_PAGE) showMorePosts = true
                    }
                },
                onError = {}
            )
        } else if (hasQueryParam) {
            (document.getElementById(Res.Id.adminSearchBar) as HTMLInputElement).value = value
            searchPostsByTitle(
                query = value,
                skip = postsToSkip,
                onSuccess = { response ->
                    apiResponse = response
                    if (response is ApiListResponse.Success) {
                        searchedPosts.clear()
                        searchedPosts.addAll(response.data)
                        postsToSkip += POSTS_PER_PAGE
                        if (response.data.size >= POSTS_PER_PAGE) showMorePosts = true
                    }
                },
                onError = {}
            )
        }
    }

    Column(
        modifier = Modifier
            .backgroundColor(Theme.Secondary.rgb)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (overflowOpened) {
            OverflowSidePanel(
                onMenuClosed = { overflowOpened = false },
                content = {
                    CategoryNavigationItems(
                        selectedCategory = if (hasCategoryParam) runCatching {
                            Category.valueOf(value)
                        }.getOrElse { Category.Programming } else null,
                        vertical = true
                    )
                }
            )
        }
        HeaderSection(
            breakpoint = breakpoint,
            selectedCategory = if (hasCategoryParam) runCatching {
                Category.valueOf(value)
            }.getOrElse { Category.Programming } else null,
            logo = Res.Image.logoBlog,
            onMenuOpen = { overflowOpened = true }
        )
        if (apiResponse is ApiListResponse.Success) {
            if (hasCategoryParam) {
                SpanText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                        .color(Theme.Primary.rgb)
                        .margin(top = 60.px, bottom = 30.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(36.px),
                    text = value.ifEmpty { Category.Programming.name }
                )
            }
            PostsSection(
                breakpoint = breakpoint,
                posts = searchedPosts,
                showMoreVisibility = showMorePosts,
                onShowMore = {
                    scope.launch {
                        if (hasCategoryParam) {
                            searchPostsByCategory(
                                category = runCatching { Category.valueOf(value) }
                                    .getOrElse { Category.Programming },
                                skip = postsToSkip,
                                onSuccess = { response ->
                                    if (response is ApiListResponse.Success) {
                                        if (response.data.isNotEmpty()) {
                                            if (response.data.size < POSTS_PER_PAGE) {
                                                showMorePosts = false
                                            }
                                            searchedPosts.addAll(response.data)
                                            postsToSkip += POSTS_PER_PAGE
                                        } else {
                                            showMorePosts = false
                                        }
                                    }
                                },
                                onError = {}
                            )
                        } else if (hasQueryParam) {
                            searchPostsByTitle(
                                query = value,
                                skip = postsToSkip,
                                onSuccess = { response ->
                                    if (response is ApiListResponse.Success) {
                                        if (response.data.isNotEmpty()) {
                                            if (response.data.size < POSTS_PER_PAGE) {
                                                showMorePosts = false
                                            }
                                            searchedPosts.addAll(response.data)
                                            postsToSkip += POSTS_PER_PAGE
                                        } else {
                                            showMorePosts = false
                                        }
                                    }
                                },
                                onError = {}
                            )
                        }
                    }
                },
                onClick = { context.router.navigateTo(Screen.PostPage.getPost(id = it)) }
            )
        } else {
            LoadingIndicator()
        }
        FooterSection()
    }
}