package com.jeffery.androidapp.screens.home

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.models.Post
import com.jeffery.androidapp.util.RequestState

@Composable
fun HomeScreen(
    posts: RequestState<List<Post>>,
    searchedPosts: RequestState<List<Post>>,
    query: String,
    searchBarOpened: Boolean,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    onQueryChange: (String) -> Unit,
    onCategorySelect: (Category) -> Unit,
    onSearchBarChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    onPostClick: (String) -> Unit
){
    val scope = rememberCompositionContext()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

}