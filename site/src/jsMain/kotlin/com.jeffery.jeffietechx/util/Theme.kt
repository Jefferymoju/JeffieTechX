package com.jeffery.jeffietechx.util

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme (
    val hex: String,
    val rgb: CSSColorValue
){
    Primary(hex = "#535EDC", rgb = rgb(r = 83, g = 94, b = 220)),
    Secondary(hex = "#2b2c31", rgb(r = 43, g = 44, b = 49)),
    SecondaryLight(hex = "#2C2C36", rgb(r = 44, g = 44, b = 54) ),
    White(hex = "FFFFFF", rgb = rgb(r = 255, g = 255, b = 255)),
    Gray(hex = "#808080", rgb = rgb(r = 128, g = 128, b = 128)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249)),
    SecondaryLighter(hex = "#3C3E4D", rgb = rgb(r = 60, g = 62, b = 77)),
    Green(
        hex = "#00FF94",
        rgb = rgb(r = 0, g = 255, b = 148)
    ),
    Yellow(
        hex = "#FFEC45",
        rgb = rgb(r = 255, g = 236, b = 69)
    ),
    Purple(
        hex = "#8B6DFF",
        rgb = rgb(r = 139, g = 109, b = 255)
    ),
    Red(
        hex = "#FF6359",
        rgb = rgb(r = 255, g = 99, b = 89)
    ),
    Blue(
        hex = "#0000FF",
        rgb = rgb(r = 0, g = 0, b = 225)
    ),
    Sponsored(
        hex = "#3300FF",
        rgb = rgb(r = 51, g = 0, b = 255)
    )

}