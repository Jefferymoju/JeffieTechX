package com.jeffery.jeffietechx.pages.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiListResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POSTS_PER_PAGE
import com.jeffery.jeffietechx.pages.blog.blog_models.PostWithoutDetails
import com.jeffery.jeffietechx.pages.blog.blog_sections.PostsSection
import com.jeffery.jeffietechx.pages.blog.blog_util.fetchPortfolioPosts
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.pages.portfolio.sections.PortfolioHeaderSection
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch

@Page
@Composable
fun PortfolioPage() {

    val breakpoint = rememberBreakpoint()
    val context = rememberPageContext()
    val scope = rememberCoroutineScope()
    val portfolioPost = remember { mutableStateListOf<PostWithoutDetails>() }
    var portfolioPostsToSkip by remember { mutableStateOf(0) }
    var showMorePortfolio by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        fetchPortfolioPosts(
            skip = portfolioPostsToSkip,
            onSuccess = { response ->
                if (response is ApiListResponse.Success) {
                    portfolioPost.addAll(response.data)
                    portfolioPostsToSkip += POSTS_PER_PAGE
                    if (response.data.size >= POSTS_PER_PAGE) showMorePortfolio = true
                }
            },
            onError = {}
        )
    }

    Column (
        modifier = Modifier
            .backgroundColor(Theme.Secondary.rgb)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PortfolioHeaderSection(
            breakpoint = breakpoint
        )
        PostsSection(
            breakpoint = breakpoint,
            posts = portfolioPost,
            title = "Portfolio",
            showMoreVisibility = showMorePortfolio,
            onShowMore = {
                scope.launch {
                    fetchPortfolioPosts(
                        skip = portfolioPostsToSkip,
                        onSuccess = { response ->
                            if (response is ApiListResponse.Success) {
                                if (response.data.isNotEmpty()){
                                    if (response.data.size < POSTS_PER_PAGE) {
                                        showMorePortfolio = false
                                    }
                                    portfolioPost.addAll(response.data)
                                    portfolioPostsToSkip += POSTS_PER_PAGE
                                } else {
                                    showMorePortfolio = false
                                }
                            }
                        },
                        onError = {}
                    )
                }
            },
            onClick =  { context.router.navigateTo(Screen.PostPage.getPost(id = it)) }
        )
    }
}