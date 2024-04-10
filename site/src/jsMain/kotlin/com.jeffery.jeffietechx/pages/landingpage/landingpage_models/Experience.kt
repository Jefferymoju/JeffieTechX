package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

/**
 * Enum class representing different educational experiences.
 *
 * @property date The duration or date of the educational experience.
 * @property title The title or name of the educational institution or course.
 * @property subtitle Additional information or specialization.
 */

enum class Experience(
    val title : String,
    val subtitle: String,
    val subject: String,
    val date: String
) {
    Ebenezer(
        title = "Ebenezer Children's Academy",
        subtitle = "Teaching Practice",
        subject = "Computer Science",
        date = "2022"
    ),
    UDSS(
        title = "UDSS",
        subtitle = "Teaching Practice",
        subject = "Computer Science",
        date = "2023"
    ),
    TR(
        title = "Tech-Royale Studios",
        subtitle = "Instructor",
        subject = "Android Development",
        date = "2023..."
    )
}