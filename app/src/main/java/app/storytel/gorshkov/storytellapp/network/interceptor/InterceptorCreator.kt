package app.storytel.gorshkov.storytellapp.network.interceptor

import okhttp3.Interceptor

interface InterceptorCreator {
    fun createInterceptor(): Interceptor
}