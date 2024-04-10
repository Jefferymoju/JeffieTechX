package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

/**
 * Enum class representing different skills.
 *
 * @property title The title of the skill.
 * @property percentage The percentage of proficiency in the skill.
 */
enum class Skill(
    val title: String,
    val percentage: String,
) {
    Creative(
        title = "Creative",
        percentage = "80%"
    ),
    Accountable(
        title = "Accountable",
        percentage = "90%"
    ),
    HardWorking(
        title = "Hard Working",
        percentage = "90%"
    ),
    Value(
        title = "Cost-Effective",
        percentage = "85%"
    ),
    Delivery(
        title = "OTD",
        percentage = "75%"
    )
}