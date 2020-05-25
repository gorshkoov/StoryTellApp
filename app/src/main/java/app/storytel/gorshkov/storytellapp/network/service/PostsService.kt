package app.storytel.gorshkov.storytellapp.network.service

import app.storytel.gorshkov.storytellapp.network.response.CommentResponse
import app.storytel.gorshkov.storytellapp.network.response.PhotoResponse
import app.storytel.gorshkov.storytellapp.network.response.PostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {
    @GET("posts")
    suspend fun getPosts(): List<PostResponse>

    @GET("photos")
    suspend fun getPhotos(): List<PhotoResponse>

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id: Int): List<CommentResponse>
}