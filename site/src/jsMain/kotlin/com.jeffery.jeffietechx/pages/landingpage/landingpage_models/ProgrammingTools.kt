package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res


enum class ProgrammingTools(
    val title: String,
    val icon: String,
    val iconDescription: String
) {
    Kotlin(
        title = "Kotlin",
        icon = Res.Icon.kotlin,
        iconDescription = "Kotlin Icon"
    ),
    Ktor(
        title = "Ktor",
        icon = Res.Icon.ktor,
        iconDescription = "Ktor Icon"
    ),
    JetpackCompose(
        title = "Compose",
        icon = Res.Icon.compose,
        iconDescription = "Jetpack Compose Icon"
    ),
    Kobweb(
        title = "Kobweb",
        icon = Res.Icon.kobweb,
        iconDescription = "Kobweb Icon"
    ),
    Python(
        title = "Python",
        icon = Res.Icon.python,
        iconDescription = "Python Icon"
    ),
    Figma(
        title = "Figma",
        icon = Res.Icon.figma,
        iconDescription = "Figma Icon"
    )
}