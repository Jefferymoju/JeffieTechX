package com.jeffery.jeffietechx.pages.blog.blog_models

import com.jeffery.jeffietechx.util.Res

enum class EditorControl(
    val icon: String,
) {
    Bold(icon = Res.Icon.bold),
    Italic(icon = Res.Icon.italic),
    Link(icon = Res.Icon.link),
    Title(icon = Res.Icon.title),
    Subtitle(icon = Res.Icon.subtitle),
    Quote(icon = Res.Icon.quote),
    Code(icon = Res.Icon.code),
    Image(icon = Res.Icon.image),
    Ul(icon = Res.Icon.underline),
    SuperScript(icon = Res.Icon.superscript),
    SubScript(icon = Res.Icon.subscript),
    StrikeThrough(icon = Res.Icon.strikethrough),
    UnorderedList(icon = Res.Icon.unorderedlist)
}