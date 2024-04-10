package com.jeffery.jeffietechx.pages.blog.blog_util


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_models.ControlStyle
import com.jeffery.jeffietechx.pages.blog.blog_models.EditorControl
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Res
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.core.rememberPageContext
import kotlinx.browser.document
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.get
import org.w3c.dom.set
import kotlin.js.Date

/**
 * isUserLoggedIn : Composable fun to control the content access based on user login status
 * remeberU :  to remember the user
 * userId : The stored userId
 * userIdExistence : Tracks user existence status
 */
@Composable
fun isUserLoggedIn(content: @Composable () -> Unit) {
    val context = rememberPageContext()
    val remembered = remember { localStorage["remember"].toBoolean() }
    val userId = remember { localStorage["userId"] }
    var userIdExists by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        userIdExists = if (!userId.isNullOrEmpty()) checkUserId(id = userId) else false
        if (!remembered || !userIdExists) {
            context.router.navigateTo(Screen.AdminLogin.route)
        }
    }

    if (remembered && userIdExists) {
        content()
    } else {
        println("Loading...")
    }
}

/**
 * Modifier extension function to remove border and outline from a composable.
 *
 * @return Modified Modifier with no border and outline.
 */
fun Modifier.noBorder(): Modifier {
    return this.border(
        width = 0.px,
        style = LineStyle.None,
        color = Colors.Transparent
    ).outline(
        width = 0.px,
        style = LineStyle.None,
        color = Colors.Transparent
    )
}

/**
 * Retrieves the editor element.
 *
 * @return The HTMLTextAreaElement representing the editor.
 */
fun getEditor() = document.getElementById(Res.Id.editor) as HTMLTextAreaElement


/**
 * Retrieves the selected range of integers in the editor.
 *
 * @return IntRange representing the selected range, or null if no range is selected.
 */
fun getSelectedIntRange(): IntRange? {
    val editor = getEditor()
    val start = editor.selectionStart
    val end = editor.selectionEnd
    return if (start != null && end != null) {
        IntRange(start, (end - 1))
    } else null
}

/**
 * Retrieves the selected text in the editor.
 *
 * @return The selected text, or null if no text is selected.
 */
fun getSelectedText(): String? {
    val range = getSelectedIntRange()
    return if (range != null) {
        getEditor().value.substring(range)
    } else null
}

/**
 * Applies the specified control style to the selected text in the editor.
 *
 * @param controlStyle The control style to apply.
 */
fun applyStyle(controlStyle : ControlStyle) {
    val selectedText = getSelectedText()
    val selectedIntRange = getSelectedIntRange()
    if (selectedIntRange != null && selectedText != null) {
        getEditor().value = getEditor().value.replaceRange(
            range = selectedIntRange,
            replacement = controlStyle.style
        )
        document.getElementById(Res.Id.editorPreview)?.innerHTML = getEditor().value
    }
}

/**
 * Applies the specified editor control to the selected text in the editor or triggers a click event for image or link controls.
 *
 * @param editorControl The editor control to apply.
 * @param onLinkClick Callback function for link click event.
 * @param onImageClick Callback function for image click event.
 */
fun applyControlStyle(
    editorControl: EditorControl,
    onLinkClick: () -> Unit,
    onImageClick: () -> Unit
) {
    when (editorControl) {
        EditorControl.Bold -> {
            applyStyle(
                ControlStyle.Bold(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Italic -> {
            applyStyle(
                ControlStyle.Italic(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Link -> {
            onLinkClick()
        }

        EditorControl.Title -> {
            applyStyle(
                ControlStyle.Title(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Subtitle -> {
            applyStyle(
                ControlStyle.Subtitle(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Quote -> {
            applyStyle(
                ControlStyle.Quote(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Code -> {
            applyStyle(
                ControlStyle.Code(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.Image -> {
            onImageClick()
        }

        EditorControl.Ul -> {
            applyStyle(
                ControlStyle.Ul(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.SuperScript -> {
            applyStyle(
                ControlStyle.SuperScript(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.SubScript -> {
            applyStyle(
                ControlStyle.SubScript(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.StrikeThrough -> {
            applyStyle(
                ControlStyle.StrikeThrough(
                    selectedText = getSelectedText()
                )
            )
        }

        EditorControl.UnorderedList -> {
            applyStyle(
                ControlStyle.UnorderedList(
                    selectedText = getSelectedText()
                )
            )
        }
    }
}

/**
 * Parses the switch text based on the number of selected posts.
 *
 * @param posts The list of posts.
 * @return A string indicating the number of selected posts.
 */
fun parseSwitchText(posts: List<String>): String {
    return if (posts.size == 1) "1 Post Selected" else "${posts.size} Posts Selected"
}

/**
 * Parses a long value representing a date to a string date format.
 *
 * @return The parsed string date.
 */
fun Long.parseDateString() = Date(this).toLocaleDateString()

/**
*logout clears the user data from the local storage to log the user out
 */
fun logout() {
    localStorage["remember"] = "false"
    localStorage["userId"] = ""
    localStorage["username"] = ""
}


/**
 * Validates an email address using regex pattern matching.
 *
 * @param email The email address to validate.
 * @return True if the email is valid, false otherwise.
 */
fun validateEmail(email: String): Boolean {
    val regex = "^[A-Za-z](.*)(@)(.+)(\\.)(.+)"
    return regex.toRegex().matches(email)
}