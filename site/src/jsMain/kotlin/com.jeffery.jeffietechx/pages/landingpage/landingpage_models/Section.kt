package com.jeffery.jeffietechx.pages.landingpage.landingpage_models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    About(
        id = "about",
        title = "About",
        subtitle = "Why Hire Me?",
        path = "#about"
    ),
    Service(
        id = "service",
        title = "Service",
        subtitle = "Best Services",
        path = "#service"
    ),
    Project(
        id = "project",
        title = "Portfolio",
        subtitle = "My Project",
        path = "#project"
    ),
    Blog(
        id = "blog",
        title = "News & Article",
        subtitle = "Latest News",
        path = "#blog"
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "Get In Touch",
        path = "#contact"
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subtitle = "Personal Achievements",
        path = "#achievements"
    ),
    Skills(
        id = "skills",
        title = "My Skills",
        subtitle = "Notable Skills",
        path = "#skills"
    ),
    Education(
        id = "education",
        title = "",
        subtitle = "Education",
        path = "#education"
    )
}