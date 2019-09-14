package com.erel.githubchallenge.core.domain

import retrofit2.HttpException

abstract class BaseInteractor<Params, Response> {

    abstract suspend fun block(params: Params): Response

    suspend fun execute(params: Params): DataHolder<Response> {
        return try {
            DataHolder(DataHolderType.SUCCESS, data = block(params))
        } catch (ex: HttpException) {
            DataHolder(DataHolderType.FAIL, error = ex.response()?.errorBody()?.string())
        }
    }
}