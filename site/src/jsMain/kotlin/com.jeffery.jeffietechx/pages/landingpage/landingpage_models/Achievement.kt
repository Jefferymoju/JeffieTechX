package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res

/**
 * Enum class representing different achievements.
 *
 * @property icon The icon representing the achievement.
 * @property number The number associated with the achievement.
 * @property description The description of the achievement.
 */
enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.checkmark,
        number = 15,
        description = "Completed Projects"
    ),
    Active(
        icon = Res.Icon.shield,
        number = 3,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Icon.happy,
        number = 10,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Res.Icon.user,
        number = 1,
        description = "Team Members"
    )
}