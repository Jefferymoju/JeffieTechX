package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.checkmark,
        number = 20,
        description = "Completed Projects"
    ),
    Active(
        icon = Res.Icon.shield,
        number = 12,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Icon.happy,
        number = 14,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Res.Icon.user,
        number = 1,
        description = "Team Members"
    )
}