package app.storytel.gorshkov.storytellapp.network.interceptor

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class LoggerInterceptorCreator(private val isHttpLog: Boolean) : InterceptorCreator {
    override fun createInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Timber.tag("OkHttp").v(message)
                }
            }
        )

        if (isHttpLog) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        return interceptor
    }
}