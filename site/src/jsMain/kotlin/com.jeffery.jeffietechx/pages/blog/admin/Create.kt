package com.jeffery.jeffietechx.pages.blog.admin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.blog.blog_components.AdminPageLayout
import com.jeffery.jeffietechx.pages.blog.blog_components.ControlPopUp
import com.jeffery.jeffietechx.pages.blog.blog_components.MessagePopUp
import com.jeffery.jeffietechx.pages.blog.blog_models.ApiResponse
import com.jeffery.jeffietechx.pages.blog.blog_models.Category
import com.jeffery.jeffietechx.pages.blog.blog_models.Constants.POST_ID_PARAM
import com.jeffery.jeffietechx.pages.blog.blog_models.ControlStyle
import com.jeffery.jeffietechx.pages.blog.blog_models.EditorControl
import com.jeffery.jeffietechx.pages.blog.blog_models.Post
import com.jeffery.jeffietechx.pages.blog.blog_styles.CategoryDropDownStyle
import com.jeffery.jeffietechx.pages.blog.blog_styles.EditorKeyStyle
import com.jeffery.jeffietechx.pages.blog.blog_util.addPost
import com.jeffery.jeffietechx.pages.blog.blog_util.applyControlStyle
import com.jeffery.jeffietechx.pages.blog.blog_util.applyStyle
import com.jeffery.jeffietechx.pages.blog.blog_util.fetchSelectedPost
import com.jeffery.jeffietechx.pages.blog.blog_util.getEditor
import com.jeffery.jeffietechx.pages.blog.blog_util.getSelectedText
import com.jeffery.jeffietechx.pages.blog.blog_util.isUserLoggedIn
import com.jeffery.jeffietechx.pages.blog.blog_util.noBorder
import com.jeffery.jeffietechx.pages.blog.blog_util.updatePost
import com.jeffery.jeffietechx.pages.blog.navigation.Screen
import com.jeffery.jeffietechx.util.Constants.FONT_FAMILY
import com.jeffery.jeffietechx.util.Constants.SIDE_PANEL_WIDTH
import com.jeffery.jeffietechx.util.Res
import com.jeffery.jeffietechx.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.Resize
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.file.loadDataUrlFromDisk
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.disabled
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.onKeyDown
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.resize
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Switch
import com.varabyte.kobweb.silk.components.forms.SwitchSize
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.get
import kotlin.js.Date

/**
 * Represents the Ui State for the create page
 * With a function reset that creates a copy of the current instance with all
 * properties set to their default values, effectively resetting the UI state.
 */
data class CreatePageUiState(
    var id: String = "",
    var title:String = "",
    var subtitle: String = "",
    var thumbnail: String = "",
    var thumbnailInputDisabled: Boolean = true,
    var content: String = "",
    var category: Category = Category.Programming,
    var buttonText: String = "Create",
    var popular: Boolean = false,
    var sponsored: Boolean = false,
    var main: Boolean = false,
    var imagePopUp: Boolean = false,
    var linkPopup: Boolean = false,
    val messagePopup: Boolean = false,
    var editorVisibility: Boolean = true
){
    fun reset() = this.copy(
        id = "",
        title = "",
        subtitle = "",
        thumbnail = "",
        content = "",
        category = Category.Programming,
        buttonText = "Create",
        popular = false,
        sponsored = false,
        main = false,
        imagePopUp = false,
        editorVisibility = true,
        messagePopup = false,
        linkPopup = false
    )
}

@Page
@Composable
fun CreatePage(){
    isUserLoggedIn {
        CreateScreen()
    }
}

@Composable
fun CreateScreen() {
    val scope = rememberCoroutineScope()
    val context = rememberPageContext()
    val breakpoint = rememberBreakpoint()
    var uiState by remember { mutableStateOf(CreatePageUiState()) }

    val hasPostIdParam = remember (key1 = context.route){
        context.route.params.containsKey(POST_ID_PARAM)
    }

    LaunchedEffect(hasPostIdParam) {
        if (hasPostIdParam) {
            val postId = context.route.params[POST_ID_PARAM] ?: ""
            val response = fetchSelectedPost(id = postId)
            if (response is ApiResponse.Success) {
                (document.getElementById(Res.Id.editor) as HTMLTextAreaElement).value =
                    response.data.content
                uiState = uiState.copy(
                    id = response.data._id,
                    title = response.data.title,
                    subtitle = response.data.subtitle,
                    content = response.data.content,
                    category = response.data.category,
                    thumbnail = response.data.thumbnail,
                    buttonText = "Update",
                    main = response.data.main,
                    popular = response.data.popular,
                    sponsored = response.data.sponsored,
                )
            }
        } else {
            (document.getElementById(Res.Id.editor) as HTMLTextAreaElement).value = ""
            uiState = uiState.reset()
        }
    }

    AdminPageLayout {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .margin(topBottom = 50.px)
                .backgroundColor(Theme.SecondaryLighter.rgb)
                .padding(left =  if (breakpoint > Breakpoint.MD) SIDE_PANEL_WIDTH.px else 0.px),
            contentAlignment = Alignment.TopCenter
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .maxWidth(700.px),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                SimpleGrid(numColumns = numColumns(base = 1, sm = 3)) {
                    Row (
                        modifier = Modifier
                            .margin(
                                right = 24.px,
                                bottom = if (breakpoint < Breakpoint.MD) 14.px else 0.px
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Switch(
                            modifier = Modifier.margin(right = 10.px),
                            checked = uiState.main,
                            onCheckedChange = { uiState = uiState.copy(main = it) },
                            size = SwitchSize.LG
                        )
                        SpanText(
                            modifier = Modifier
                                .fontSize(15.px)
                                .fontFamily(FONT_FAMILY)
                                .color(Theme.Gray.rgb),
                            text = "Main"
                        )
                    }
                    Row (
                        modifier = Modifier
                            .margin(
                                right = 24.px,
                                bottom = if (breakpoint < Breakpoint.MD) 14.px else 0.px
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Switch(
                            modifier = Modifier.margin(right = 10.px),
                            checked = uiState.popular,
                            onCheckedChange = { uiState = uiState.copy(popular = it) },
                            size = SwitchSize.LG
                        )
                        SpanText(
                            modifier = Modifier
                                .fontSize(15.px)
                                .fontFamily(FONT_FAMILY)
                                .color(Theme.Gray.rgb),
                            text = "Popular"
                        )
                    }
                    Row (
                        modifier = Modifier
                            .margin(
                                right = 24.px,
                                bottom = if (breakpoint < Breakpoint.MD) 14.px else 0.px
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Switch(
                            modifier = Modifier.margin(right = 10.px),
                            checked = uiState.sponsored,
                            onCheckedChange = { uiState = uiState.copy(sponsored = it) },
                            size = SwitchSize.LG
                        )
                        SpanText(
                            modifier = Modifier
                                .fontSize(15.px)
                                .fontFamily(FONT_FAMILY)
                                .color(Theme.Gray.rgb),
                            text = "Sponsored"
                        )
                    }
                }
                Input(
                    type = InputType.Text,
                    attrs = Modifier
                        .id(Res.Id.titleInput)
                        .fillMaxWidth()
                        .height(55.px)
                        .margin(top = 25.px, bottom = 15.px)
                        .padding(leftRight = 20.px)
                        .backgroundColor(Theme.SecondaryLight.rgb)
                        .borderRadius(r = 5.px)
                        .color(Theme.White.rgb)
                        .border(
                            width = 1.px,
                            style = LineStyle.Solid,
                            color = Theme.Primary.rgb
                        )
                        .outline(
                            width = 0.px,
                            style = LineStyle.None,
                            color = Colors.Transparent
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .toAttrs{
                            attr("placeholder", "Title")
                            attr("value", uiState.title)
                        }
                )
                Input(
                    type = InputType.Text,
                    attrs = Modifier
                        .id(Res.Id.subtitleInput)
                        .fillMaxWidth()
                        .height(55.px)
                        .margin(topBottom = 15.px)
                        .padding(leftRight = 20.px)
                        .backgroundColor(Theme.SecondaryLight.rgb)
                        .borderRadius(r = 5.px)
                        .color(Theme.White.rgb)
                        .border(
                            width = 1.px,
                            style = LineStyle.Solid,
                            color = Theme.Primary.rgb
                        )
                        .outline(
                            width = 0.px,
                            style = LineStyle.None,
                            color = Colors.Transparent
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .toAttrs{
                            attr("placeholder", "Subtitle")
                            attr("value", uiState.subtitle)
                        }
                )
                CategoryDropDown(
                    selectedCategory = uiState.category,
                    onCategorySelect = { uiState = uiState.copy(category = it) }
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .margin(topBottom = 15.px),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Switch(
                        modifier = Modifier.margin(right = 10.px),
                        checked = !uiState.thumbnailInputDisabled,
                        onCheckedChange = { uiState = uiState.copy(thumbnailInputDisabled = !it)},
                        size = SwitchSize.LG
                    )
                    SpanText(
                        modifier = Modifier
                            .fontSize(15.px)
                            .fontFamily(FONT_FAMILY)
                            .color(Theme.Gray.rgb),
                        text = "Paste Image Url Instead"
                    )
                }
                ThumbnailUploader(
                    thumbnail = uiState.thumbnail,
                    thumbnailInputDisabled = uiState.thumbnailInputDisabled,
                    onThumbnailSelect = {filename, file ->
                        (document.getElementById(Res.Id.thumbnailInput) as HTMLInputElement)
                            .value = filename
                        uiState = uiState.copy(thumbnail = file)
                    }
                )
                EditorControl(
                    breakpoint = breakpoint,
                    editorVisibility = uiState.editorVisibility,
                    onEditorVisibilityChange = {
                        uiState = uiState.copy(
                            editorVisibility = !uiState.editorVisibility
                        )
                    },
                    onLinkClick = {
                        uiState = uiState.copy(linkPopup = true)
                    },
                    onImageClick = {
                        uiState = uiState.copy(imagePopUp = true)
                    }
                )
                Editor(editorVisibility = uiState.editorVisibility)
                CreateButton(
                    text = uiState.buttonText,
                    onClick = {
                        uiState =
                            uiState.copy(title = (document.getElementById(Res.Id.titleInput) as HTMLInputElement).value)
                        uiState =
                            uiState.copy(subtitle = (document.getElementById(Res.Id.subtitleInput) as HTMLInputElement).value)
                        uiState =
                            uiState.copy(content = (document.getElementById(Res.Id.editor) as HTMLTextAreaElement).value)
                        if (!uiState.thumbnailInputDisabled){
                            uiState =
                                uiState.copy(thumbnail = (document.getElementById(Res.Id.thumbnailInput) as HTMLInputElement).value)
                        }
                        if (
                            uiState.title.isNotEmpty() &&
                            uiState.subtitle.isNotEmpty() &&
                            uiState.thumbnail.isNotEmpty() &&
                            uiState.content.isNotEmpty()
                        ) {
                            scope.launch {
                                if (hasPostIdParam) {
                                    val result = updatePost(
                                        Post(
                                            _id = uiState.id,
                                            title = uiState.title,
                                            subtitle = uiState.subtitle,
                                            thumbnail = uiState.thumbnail,
                                            content = uiState.content,
                                            category = uiState.category,
                                            popular = uiState.popular,
                                            main = uiState.main,
                                            sponsored = uiState.sponsored,
                                        )
                                    )
                                    if (result) {
                                        context.router.navigateTo(Screen.AdminSuccess.postUpdated())
                                    }
                                } else {
                                    val result = addPost(
                                        Post(
                                            author = localStorage["username"].toString(),
                                            title = uiState.title,
                                            subtitle = uiState.subtitle,
                                            date = Date.now(),
                                            thumbnail = uiState.thumbnail,
                                            content = uiState.content,
                                            category = uiState.category,
                                            popular = uiState.popular,
                                            main = uiState.main,
                                            sponsored = uiState.sponsored,
                                        )
                                    )
                                    if (result) {
                                        context.router.navigateTo(Screen.AdminSuccess.route)
                                    }
                                }
                            }
                        } else {
                            scope.launch {
                                uiState = uiState.copy(messagePopup = true)
                                delay(2000)
                                uiState = uiState.copy(messagePopup = false)
                            }
                        }
                    }
                )
            }
        }
    }
    if (uiState.messagePopup) {
        MessagePopUp(
            message = "Please fill out all fields.",
            onDialogDismiss = { uiState = uiState.copy(messagePopup = false) }
        )
    }
    if (uiState.linkPopup) {
        ControlPopUp(
            editorControl = EditorControl.Link,
            onDialogDismiss = { uiState = uiState.copy(linkPopup = false) },
            onAddClick = { href, title ->
                applyStyle(
                    ControlStyle.Link(
                        selectedText = getSelectedText(),
                        href = href,
                        title = title
                    )
                )
            }
        )
    }
    if (uiState.imagePopUp) {
        ControlPopUp(
            editorControl = EditorControl.Image,
            onDialogDismiss = { uiState = uiState.copy(imagePopUp = false) },
            onAddClick = { imageUrl, description ->
                applyStyle(
                    ControlStyle.Image(
                        selectedText = getSelectedText(),
                        imageUrl = imageUrl,
                        desc = description
                    )
                )
            }
        )
    }
}

/**
 *  Custom composable function for creating a dropdown menu for selecting
 *  categories in the create page
 */
@Composable
fun CategoryDropDown(
    selectedCategory: Category,
    onCategorySelect: (Category) -> Unit
) {
    Box (
        modifier = Modifier
            .margin(topBottom = 15.px)
            .classNames("dropdown")
            .fillMaxWidth()
            .height(55.px)
            .backgroundColor(Theme.SecondaryLight.rgb)
            .borderRadius(r = 5.px)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
            .cursor(Cursor.Pointer)
            .attrsModifier {
                attr("data-bs-toggle", "dropdown")
            }
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .borderRadius(r = 5.px)
                .backgroundColor(Theme.SecondaryLight.rgb)
                .padding(leftRight = 20.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            SpanText(
                modifier = Modifier
                    .fillMaxWidth()
                    .color(Theme.White.rgb)
                    .fontSize(15.px)
                    .fontFamily(FONT_FAMILY),
                text = selectedCategory.name
            )
            Box(
                modifier = Modifier
                    .color(Theme.White.rgb)
                    .classNames("dropdown-toggle"))
        }
        Ul (
            attrs = Modifier
                .fillMaxWidth()
                .classNames("dropdown-menu")
                .backgroundColor(Theme.SecondaryLighter.rgb)
                .toAttrs()
        ){
            Category.values().forEach { category ->
                Li {
                    A (
                        attrs = CategoryDropDownStyle.toModifier()
                            .classNames("dropdown-item")
                            .backgroundColor(Theme.SecondaryLighter.rgb)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(15.px)
                            .onClick { onCategorySelect(category) }
                            .toAttrs()
                    ){
                        Text(value = category.name)
                    }
                }
            }
        }
    }
}

/**
 * Ui component/function for handling thumbnail Image upload
 */
@Composable
fun ThumbnailUploader(
    thumbnail: String,
    thumbnailInputDisabled: Boolean,
    onThumbnailSelect: (String, String) -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 20.px)
            .height(55.px)
    ){
        Input(
            type = InputType.Text,
            attrs = Modifier
                .id(Res.Id.thumbnailInput)
                .fillMaxSize()
                .margin(right = 13.px)
                .padding(leftRight = 20.px)
                .backgroundColor(Theme.SecondaryLight.rgb)
                .color(Theme.White.rgb)
                .borderRadius(r = 5.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .fontFamily(FONT_FAMILY)
                .fontSize(15.px)
                .thenIf(
                    condition = thumbnailInputDisabled,
                    other = Modifier.disabled()
                )
                .toAttrs {
                    attr("placeholder", "Thumbnail")
                    attr("value", thumbnail)
                }
        )
        Button (
            attrs = Modifier
                .onClick {
                    document.loadDataUrlFromDisk (
                        accept = "image/png, image/jpg",
                        onLoaded = {
                            onThumbnailSelect(filename, it)
                        }
                    )
                }
                .fillMaxHeight()
                .padding(leftRight = 25.px)
                .backgroundColor(if (!thumbnailInputDisabled) Theme.Gray.rgb else Theme.Primary.rgb)
                .color(if (!thumbnailInputDisabled) Theme.LighterGray.rgb else Colors.White)
                .borderRadius(r = 5.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .fontFamily(FONT_FAMILY)
                .fontSize(15.px)
                .fontWeight(FontWeight.Medium)
                .thenIf(
                    condition = !thumbnailInputDisabled,
                    other = Modifier.disabled()
                )
                .toAttrs()
        ){
            SpanText(text = "Upload")
        }
    }
}

@Composable
fun Editor( editorVisibility: Boolean) {
    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        TextArea(
            attrs = Modifier
                .id(Res.Id.editor)
                .fillMaxWidth()
                .height(400.px)
                .maxHeight(400.px)
                .resize(Resize.None)
                .margin(top = 8.px)
                .padding(all = 20.px)
                .color(Theme.White.rgb)
                .backgroundColor(Theme.SecondaryLight.rgb)
                .borderRadius(r = 5.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .visibility(
                    if (editorVisibility) Visibility.Visible
                    else Visibility.Hidden
                )
                .onKeyDown {
                    if (it.code == "Enter" && it.shiftKey){
                        applyStyle(
                            controlStyle = ControlStyle.Break(
                                selectedText = getSelectedText()
                            )
                        )
                    }
                }
                .fontFamily(FONT_FAMILY)
                .fontSize(16.px)
                .toAttrs {
                    attr("placeholder", "Type here...")
                }
        )
        Div(
            attrs = Modifier
                .id(Res.Id.editorPreview)
                .fillMaxWidth()
                .height(400.px)
                .maxHeight(400.px)
                .margin(top = 8.px)
                .padding(all = 20.px)
                .color(Theme.White.rgb)
                .backgroundColor(Theme.SecondaryLight.rgb)
                .borderRadius(r = 5.px)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .visibility(
                    if (editorVisibility) Visibility.Hidden
                    else Visibility.Visible
                )
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .toAttrs()
        )
    }
}

@Composable
fun EditorControlView(
    control: EditorControl,
    onClick: ()-> Unit
) {
    Box (
        modifier = EditorKeyStyle.toModifier()
            .fillMaxHeight()
            .margin(leftRight = (10.6).px)
            .padding(leftRight = 12.px)
            .borderRadius(r = 5.px)
            .cursor(Cursor.Pointer)
            .onClick { onClick() },
        contentAlignment = Alignment.Center
    ){
        Image(
            src = control.icon,
            desc = "${control.name} Icon"
        )
    }
}

@Composable
fun EditorControl(
    breakpoint: Breakpoint,
    editorVisibility: Boolean,
    onLinkClick: () -> Unit,
    onImageClick: () -> Unit,
    onEditorVisibilityChange: () -> Unit
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
    ){
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(),
            numColumns = numColumns(base = 1, sm = 2)
        ) {
            Row (
                modifier = Modifier
                    .backgroundColor(Theme.SecondaryLight.rgb)
                    .borderRadius(r = 5.px)
                    .border(
                        width = 1.px,
                        style = LineStyle.Solid,
                        color = Theme.Primary.rgb
                    )
                    .height(55.px)
            ){
                EditorControl.values().forEach {
                    EditorControlView(
                        control = it,
                        onClick = {
                            applyControlStyle(
                                editorControl = it,
                                onLinkClick = onLinkClick,
                                onImageClick = onImageClick
                            )
                        }
                    )
                }
            }
            Box (
                contentAlignment = Alignment.CenterEnd
            ){
                Button (
                    attrs = Modifier
                        .height(55.px)
                        .thenIf(
                            condition = breakpoint < Breakpoint.SM,
                            other = Modifier.fillMaxWidth()
                        )
                        .margin(topBottom = if (breakpoint < Breakpoint.SM) 10.px else 0.px)
                        .padding(leftRight = 25.px)
                        .borderRadius(r = 5.px)
                        .backgroundColor(
                            if (editorVisibility) Theme.Gray.rgb
                            else Theme.Primary.rgb
                        )
                        .color(
                            if (editorVisibility) Theme.Secondary.rgb
                            else Theme.White.rgb
                        )
                        .noBorder()
                        .onClick {
                            onEditorVisibilityChange()
                            document.getElementById(Res.Id.editorPreview)?.innerHTML = getEditor().value
                            js("hljs.highlightAll()") as Unit
                        }
                        .toAttrs()
                ){
                    SpanText(
                        modifier = Modifier
                            .fontSize(15.px)
                            .fontFamily(FONT_FAMILY)
                            .fontWeight(FontWeight.Medium),
                        text = "Preview"
                    )
                }
            }
        }
    }
}

@Composable
fun CreateButton(
    text : String,
    onClick: () -> Unit
) {
    Button (
        attrs = Modifier
            .onClick { onClick() }
            .fillMaxWidth()
            .height(55.px)
            .margin(top = 25.px)
            .backgroundColor(Theme.Primary.rgb)
            .color(Theme.White.rgb)
            .borderRadius(r = 5.px)
            .noBorder()
            .fontFamily(FONT_FAMILY)
            .fontSize(16.px)
            .toAttrs()
    ){
        SpanText(text = text)
    }
}