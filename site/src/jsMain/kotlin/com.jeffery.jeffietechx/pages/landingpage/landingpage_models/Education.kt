package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

/**
 * Enum class representing different educational experiences.
 *
 * @property date The duration or date of the educational experience.
 * @property title The title or name of the educational institution or course.
 * @property subtitle Additional information or specialization.
 */
enum class Education (
    val date: String,
    val title: String,
    val subtitle: String
) {
    Uniben(
        date = "2018 - 2023",
        title = "University Of Benin Nigeria",
        subtitle = "Computer Science and Education"
    ),
    Android(
        date = "2022 - 2023",
        title = "Udemy",
        subtitle = "Android 14 & Kotlin Development"
    ),
    Python(
        date = "2024 .........",
        title = "Udemy",
        subtitle = "100 days of coding Python Bootcamp"
    ),
    Ktor(
        date = "2023",
        title = "Udemy",
        subtitle = "Modern Api With Ktor Server"
    ),
    Website(
        date = "2023",
        title = "Udemy",
        subtitle = "Website with Kotlin and Jetpack Compose"
    ),
    Blog (
        date = "2023",
        title = "Udemy",
        subtitle = "Fullstack Kotlin Multiplatform KMP"
    ),
}