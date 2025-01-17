package com.jeffery.androidapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jeffery.androidapp.R
import com.jeffery.androidapp.models.Category

/**
 * Composable function to display a navigation drawer.
 *
 * @param drawerState The state of the drawer, controlling its open and close actions.
 * @param onCategorySelect Callback function invoked when a category is selected.
 * @param content The main content of the screen.
 */
@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    onCategorySelect: (Category) -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                content = {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 100.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo Image"
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(0.5f)
                            .padding(start = 20.dp, bottom = 12.dp),
                        text = "Categories"
                    )
                    Category.values().forEach { category ->
                        NavigationDrawerItem(
                            label = {
                                    Text(
                                        modifier = Modifier.padding(horizontal = 12.dp),
                                        text = category.name,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                            },
                            selected = false,
                            onClick = { onCategorySelect(category) }
                        )
                    }
                }
            )
        },
        content = { content() }
    )
}