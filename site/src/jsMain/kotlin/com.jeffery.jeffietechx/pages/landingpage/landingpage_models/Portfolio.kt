package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res

/**
 * Enum class representing different portfolio items.
 *
 * @property image The image associated with the portfolio item.
 * @property title The title or name of the portfolio item.
 * @property description The description or details of the portfolio item.
 */
enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.boruto,
        title = "Boruto",
        description = "App Development"
    ),
    Two(
        image = Res.Image.quiz,
        title = "Quiz app with room database",
        description = "Mobile Development"
    ),
    Three(
        image = Res.Image.weather,
        title = "Weather App",
        description = "App Development"
    )
}