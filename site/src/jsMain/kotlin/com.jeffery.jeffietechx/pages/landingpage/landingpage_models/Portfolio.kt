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
        image = Res.Image.portfolio1,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Landing Page for NFT",
        description = "FrontEnd"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "NFT Application",
        description = "Frontend/Backend"
    )
}