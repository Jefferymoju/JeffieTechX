package com.jeffery.jeffietechx.api

import com.jeffery.jeffietechx.pages.blog.blog_models.User
import com.jeffery.jeffietechx.pages.blog.blog_models.UserWithoutPassword
import com.jeffery.jeffietechx.pages.data.MongoDB
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

/**
 * Checks the existence of a user in the database based on the provided credentials.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "usercheck")
suspend fun userCheck(context : ApiContext){
    try{
        val userRequest =
            context.req.body?.decodeToString()?.let { Json.decodeFromString<User>(it) }
        val user = userRequest?.let {
            context.data.getValue<MongoDB>().checkUserExistence(
                User(username = it.username, password = hashPassword(it.password))
            )
        }
        if (user != null){
            context.res.setBodyText(
                Json.encodeToString(
                    UserWithoutPassword(_id = user._id, username = user.username)
                )
            )
        } else {
            context.res.setBodyText(Json.encodeToString(Exception("User doesn't exist")))
        }
    }catch (e: Exception){
        context.res.setBodyText(Json.encodeToString(Exception(e.message)))
    }
}

/**
 * Checks if a user ID exists in the database.
 * @param context The API context containing the request and access to the database.
 */
@Suppress("unused")
@Api(routeOverride = "checkuserid")
suspend fun checkUserId(context: ApiContext) {
    try {
        val idRequest =
            context.req.body?.decodeToString()?.let { Json.decodeFromString<String>(it) }
        val result = idRequest?.let {
            context.data.getValue<MongoDB>().checkUserId(it)
        }
        if (result != null) {
            context.res.setBodyText(Json.encodeToString(result))
        } else {
            context.res.setBodyText(Json.encodeToString(false))
        }
    } catch (e: Exception){
        context.res.setBodyText(Json.encodeToString(false))
    }
}

/**
 * Hashes the provided password using SHA-256 algorithm.
 * @param password The password to be hashed.
 * @return The hashed password as a hexadecimal string.
 */
private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    val hexString = StringBuffer()

    for (byte in hashBytes) {
        hexString.append(String.format("%02x", byte))
    }

    return hexString.toString()
}