package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

import com.jeffery.jeffietechx.util.Res

/**
 * Enum class representing different services offered.
 *
 * @property icon The icon associated with the service.
 * @property imageDesc The description of the image/icon.
 * @property title The title of the service.
 * @property description The description of the service.
 */
enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    Android(
        icon = Res.Icon.android,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = "I bring your vision to life, pixel by pixel, line by line. As a skilled " +
                "Android developer fluent in the art of Kotlin, I translate your ideas into " +
                "captivating mobile experiences."
    ),
//    IOS(
//        icon = Res.Icon.apple,
//        imageDesc = "Apple Icon",
//        title = "IOS Development",
//        description = "As an iOS developer proficient in Kotlin Multiplatform and SwiftUI," +
//                " I transform app visions into captivating realities. Let's create something " +
//                "exceptional together!"
//    ),
    Web(
        icon = Res.Icon.web,
        imageDesc = "Desktop Icon",
        title = "Web Development",
        description = "I'm a web developer who crafts engaging, dynamic experiences without leaving" +
                " the familiar shores of Compose. Ditch the complexity, embrace the future, and " +
                "watch your website come alive with Compose Web."
    ),
    Design(
        icon = Res.Icon.design,
        imageDesc = "Design Icon",
        title = "  UI/UX Designing",
        description = "I'm not just a pixel pusher, I'm a storyteller. I weave user journeys that " +
                "captivate, guide, and leave a lasting impression. Let's craft interfaces that tell " +
                "your brand's story and make your users fall in love."
    )
}