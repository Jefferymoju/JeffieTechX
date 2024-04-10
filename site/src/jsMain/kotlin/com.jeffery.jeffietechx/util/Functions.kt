package com.jeffery.jeffietechx.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

/**
 * Observes whether a section enters the viewport and triggers a callback when it does.
 *
 * @param sectionId The ID of the section to observe.
 * @param distanceFromTop The distance from the top of the viewport at which the section is considered entered.
 * @param onViewportEntered The callback function to execute when the section enters the viewport.
 */
@Composable
fun ObserveViewPortEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
){
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop){
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewportEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        } else {
            window.addEventListener(type = "scroll", callback = listener)
        }
    }
}

/**
 * Animates numbers incrementally up to a specified number.
 *
 * @param number The final number to animate up to.
 * @param delay The delay between each increment in milliseconds.
 * @param onUpdate The callback function to execute after each number increment.
 */
suspend fun animateNumbers(
    number: Int,
    delay: Long = 100L,
    onUpdate: (Int) -> Unit
) {
    (0 .. number).forEach{
        delay(delay)
        onUpdate(it)
    }
}