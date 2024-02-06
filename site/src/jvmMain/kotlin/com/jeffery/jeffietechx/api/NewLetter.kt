package com.jeffery.jeffietechx.api

import com.jeffery.jeffietechx.pages.blog.blog_models.NewsLetter
import com.jeffery.jeffietechx.pages.data.MongoDB
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue

@Api(routeOverride = "subscribe")
suspend fun subscribeToNewsLetter(
    context: ApiContext
) {
    try {
        val newsLetter = context.req.getBody<NewsLetter>()
        context.res.setBody(newsLetter?.let {
            context.data.getValue<MongoDB>().subscribe(newsletter = it)
        })
    } catch (e: Exception) {
        context.res.setBody(e.message)
    }
}