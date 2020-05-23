package app.storytel.gorshkov.storytellapp.di

import app.storytel.gorshkov.storytellapp.network.service.ScrollingService
import app.storytel.gorshkov.storytellapp.network.interceptor.LoggerInterceptorCreator
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

const val TIME_OUT: Long = 20
const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

val CONTENT_TYPE = "application/json".toMediaType()
val TIME_UNIT = TimeUnit.SECONDS

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json(JsonConfiguration(ignoreUnknownKeys = true))
                    .asConverterFactory(CONTENT_TYPE)
            )
            .client(get())
            .build()
    }

    single {
        val loggerInterceptorCreator: LoggerInterceptorCreator = get()
        OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TIME_UNIT)
            .readTimeout(TIME_OUT, TIME_UNIT)
            .addInterceptor(loggerInterceptorCreator.createInterceptor())
            .build()
    }
    single { LoggerInterceptorCreator(true) }
}

val servicesModule = module {
    single { (get() as Retrofit).create(ScrollingService::class.java) }
}
