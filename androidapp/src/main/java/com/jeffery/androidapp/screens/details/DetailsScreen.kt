package com.jeffery.androidapp.screens.details

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Composable function for displaying the details of a post in a web view.
 *
 * @param url The URL of the web page to load in the web view.
 * @param onBackPress Callback function to handle back button press.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun DetailsScreen(
    url : String,
    onBackPress: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                Text(text = "Details")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPress()
                    }) {
                       Icon(
                           imageVector = Icons.Default.ArrowBack,
                           contentDescription = "Back Arrow Icon"
                       )
                    }
                }
            )
        }
    ) {
        // AndroidView to embed Android-specific views in Compose
        AndroidView(
            modifier = Modifier
                .padding(top = it.calculateTopPadding()),
            factory = { context ->
                // Create a WebView in the Android context
                WebView(context).apply {
                    layoutParams= ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(url)
                    Log.d("Details Screen", "URL loaded: $url")
                }
            }
        )
    }
}