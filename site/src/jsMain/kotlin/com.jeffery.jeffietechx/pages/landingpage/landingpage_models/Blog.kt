package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res


enum class Blog(
    val title: String,
    val subtitle: String,
    val image: String,
    val date: String,
    val imageDesc: String
) {
    One(
        title = "Android Today",
        subtitle = "Google update on android for the first quater of 2024",
        date = "December 2, 2023",
        image = Res.Image.study,
        imageDesc = "blog Image"
    ),
    Two(
        title = "Jetpack Compose",
        subtitle = "New features update on jetpack compose",
        date = "January 20, 2023",
        image = Res.Image.about,
        imageDesc = "Blog Image"
    )
}