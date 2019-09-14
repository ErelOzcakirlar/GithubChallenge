package com.erel.githubchallenge.core.domain

data class DataHolder<Response>(
    val type: DataHolderType,
    val data: Response? = null,
    val error: String? = null
)

enum class DataHolderType {
    LOADING,
    SUCCESS,
    FAIL
}