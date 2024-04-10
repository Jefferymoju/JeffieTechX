package com.jeffery.androidapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Composable function to display an empty UI state.
 *
 * @param loading Whether to display a loading indicator.
 * @param hideMessage Whether to hide the empty message.
 * @param message The message to display when there are no items to show.
 */
@Composable
fun EmptyUI(
    loading : Boolean = false,
    hideMessage: Boolean = false,
    message: String = "No posts to show."
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (loading) {
            CircularProgressIndicator()
        } else {
            if (!hideMessage) {
                Text(text = message)
            }
        }
    }
}