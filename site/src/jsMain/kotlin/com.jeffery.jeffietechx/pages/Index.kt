package com.jeffery.jeffietechx.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.BackToTop
import com.jeffery.jeffietechx.pages.landingpage.landingpage_components.OverflowMenu
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.AboutSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.AchievementsSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.BlogSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.ContactSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.EducationSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.FooterSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.MainSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.PortfolioSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.ServiceSection
import com.jeffery.jeffietechx.pages.landingpage.landingpage_section.SkillsSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage(){
    var menuOpened by remember { mutableStateOf(false) }
    Box (modifier = Modifier
        .fillMaxSize()
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MainSection(onMenuClicked = {menuOpened = true})
            ServiceSection()
            AboutSection()
            PortfolioSection()
            AchievementsSection()
            SkillsSection()
            EducationSection()
            ContactSection()
            BlogSection()
            FooterSection()
        }
        BackToTop()
        if (menuOpened) {
            OverflowMenu(onMenuClosed = {menuOpened = false})
        }
    }
}