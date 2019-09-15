package com.erel.githubchallenge.features.user.data

import com.google.gson.annotations.SerializedName

data class UserRaw(
    @SerializedName("login") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("avatar_url") val profileImage: String?,
    @SerializedName("company") val company: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("bio") val bio: String?
) {
    companion object {
        fun default() = UserRaw(
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }
}