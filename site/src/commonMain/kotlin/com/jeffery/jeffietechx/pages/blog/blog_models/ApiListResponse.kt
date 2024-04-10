package com.jeffery.jeffietechx.pages.blog.blog_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject


/**
 * Sealed class representing various responses from the API that return a list of data.
 */
@Serializable(ApiListResponseSerializer::class)
sealed class ApiListResponse {
    @Serializable
    @SerialName("idle")
    object Idle : ApiListResponse()

    @Serializable
    @SerialName("success")
    data class Success(val data: List<PostWithoutDetails>) : ApiListResponse()

    @Serializable
    @SerialName("error")
    data class Error(val message: String) : ApiListResponse()
}

/**
 * Sealed class representing various responses from an API.
 */
@Serializable(ApiResponseSerializer::class)
sealed class ApiResponse {
    @Serializable
    @SerialName("idle")
    object Idle : ApiResponse()

    @Serializable
    @SerialName("success")
    data class Success(val data: Post) : ApiResponse()

    @Serializable
    @SerialName("error")
    data class Error(val message: String) : ApiResponse()
}

/**
 * Serializer for [ApiListResponse] sealed class to handle polymorphic serialization/deserialization.
 * This serializer selects the appropriate deserializer based on the structure of the JSON element.
 * Selects the appropriate deserializer based on the JSON element's structure.
 * @param element The JSON element to deserialize.
 * @return The serializer for the corresponding [ApiListResponse] subclass.
 */
object ApiListResponseSerializer :
    JsonContentPolymorphicSerializer<ApiListResponse>(ApiListResponse::class) {
    override fun selectDeserializer(element: JsonElement) = when {
        "data" in element.jsonObject -> ApiListResponse.Success.serializer()
        "message" in element.jsonObject -> ApiListResponse.Error.serializer()
        else -> ApiListResponse.Idle.serializer()
    }
}

/**
 * Serializer for [ApiResponse] sealed class to handle polymorphic serialization/deserialization.
 * This serializer selects the appropriate deserializer based on the structure of the JSON element.
 * Selects the appropriate deserializer based on the JSON element's structure.
 * @param element The JSON element to deserialize.
 * @return The serializer for the corresponding [ApiResponse] subclass.
 */
object ApiResponseSerializer :
    JsonContentPolymorphicSerializer<ApiResponse>(ApiResponse::class) {
    override fun selectDeserializer(element: JsonElement) = when {
        "data" in element.jsonObject -> ApiResponse.Success.serializer()
        "message" in element.jsonObject -> ApiResponse.Error.serializer()
        else -> ApiResponse.Idle.serializer()
    }
}
