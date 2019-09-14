package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.BuildConfig
import com.erel.githubchallenge.features.repo.data.RepoDataModule
import dagger.Module
import dagger.Provides
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton


@Module(
    includes = [
        RepoDataModule::class
    ]
)
internal class DataModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        addInterceptor(HttpLoggingInterceptor().apply { level = BASIC })
        build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = with(Retrofit.Builder()) {
        baseUrl(BuildConfig.BASE_URL)
        client(client)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }

}