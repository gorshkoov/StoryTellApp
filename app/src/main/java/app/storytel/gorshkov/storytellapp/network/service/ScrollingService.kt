package app.storytel.gorshkov.storytellapp.network.service

import app.storytel.gorshkov.storytellapp.network.response.PostResponse
import retrofit2.http.GET

interface ScrollingService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponse>
}