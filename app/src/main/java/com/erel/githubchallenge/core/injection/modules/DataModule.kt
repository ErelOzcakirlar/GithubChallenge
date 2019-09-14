package com.erel.githubchallenge.core.injection.modules

import com.erel.githubchallenge.BuildConfig
import com.erel.githubchallenge.features.repo.data.RepoDataModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(
    includes = [
        RepoDataModule::class
    ]
)
internal class DataModule {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        addInterceptor {
            val request = with(it.request().newBuilder()) {
                addHeader(AUTHORIZATION_HEADER, BuildConfig.BASE_USER)
                build()
            }
            it.proceed(request)
        }
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