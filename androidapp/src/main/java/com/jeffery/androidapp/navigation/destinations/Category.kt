package com.jeffery.androidapp.navigation.destinations

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.navigation.Screen
import com.jeffery.androidapp.screens.category.CategoryScreen
import com.jeffery.androidapp.screens.category.CategoryViewModel
import com.jeffery.androidapp.util.Constants.CATEGORY_ARGUMENT

/**
 * Defines a composable route for displaying posts of a specific category.
 *
 * @param onBackPress Callback function to handle back navigation.
 * @param onPostClick Callback function to handle post item click.
 */
fun NavGraphBuilder.categoryRoute(
    onBackPress: () -> Unit,
    onPostClick: (String) -> Unit
) {
    composable(
        route = Screen.Category.route,
        arguments = listOf(navArgument(name = CATEGORY_ARGUMENT) {
            type = NavType.StringType
        })
    ) {
        val viewModel: CategoryViewModel = viewModel()
        val selectedCategory = it.arguments?.getString(CATEGORY_ARGUMENT) ?: Category.Programming.name
        CategoryScreen(
            posts = viewModel.categoryPosts.value ,
            category = Category.valueOf(selectedCategory),
            onBackPress = onBackPress,
            onPostClick = onPostClick
        )
    }
}