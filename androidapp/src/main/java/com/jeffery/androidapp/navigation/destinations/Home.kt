package com.jeffery.androidapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jeffery.androidapp.models.Category
import com.jeffery.androidapp.navigation.Screen

fun NavGraphBuilder.homeRoute(
    onCategorySelect: (Category) -> Unit,
    onPostClick: (String) -> Unit
) {
    composable(route = Screen.Home.route) {
    }
}