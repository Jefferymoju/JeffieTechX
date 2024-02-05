package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res


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