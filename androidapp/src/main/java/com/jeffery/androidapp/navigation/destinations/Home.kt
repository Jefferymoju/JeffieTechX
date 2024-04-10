package com.jeffery.androidapp.navigation.destinations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.navigation.Screen
import com.jeffery.androidapp.screens.home.HomeScreen
import com.jeffery.androidapp.screens.home.HomeViewModel

/**
 * Defines the composable route for the home screen.
 *
 * @param onCategorySelect Callback function invoked when a category is selected.
 * @param onPostClick Callback function invoked when a post is clicked.
 */
fun NavGraphBuilder.homeRoute(
    onCategorySelect: (Category) -> Unit,
    onPostClick: (String) -> Unit
) {
    composable(route = Screen.Home.route) {
        // Initialize the view model to access data related to the home screen
        val viewModel: HomeViewModel = viewModel()

        // State variables for search functionality and search bar visibility
        var query by remember { mutableStateOf("") }
        var searchBarOpened by remember { mutableStateOf(false) }
        var active by remember { mutableStateOf(false) }

        HomeScreen(
            posts = viewModel.allPosts.value,
            searchedPosts = viewModel.searchedPosts.value,
            query = query,
            searchBarOpened = searchBarOpened,
            active = active,
            onActiveChange = { active = it},
            onQueryChange = { query = it},
            onCategorySelect = onCategorySelect,
            onSearchBarChange = { opened ->
                searchBarOpened = opened
                if (!opened) {
                    query = ""
                    active = false
                    viewModel.resetSearchedPosts()
                }
            },
            onSearch =  viewModel::searchPostsByTitle,
            onPostClick = onPostClick
        )
    }
}