package com.mika.mfilmovi.mikaflix

import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.io.IOException
import java.util.concurrent.TimeUnit

data class Movie(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val videoUrl: String = "",
    val rating: Double = 0.0
)

data class MovieResponse(
    val movies: List<Movie> = emptyList()
)

object ApiService {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()
    
    private val gson = Gson()

    fun fetchMovies(): List<Movie>? {
        return try {
            val request = okhttp3.Request.Builder()
                .url("https://www.streamex.net/api/movies")
                .addHeader("User-Agent", "Mozilla/5.0")
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val jsonString = response.body?.string()
                if (jsonString != null) {
                    val movieResponse = gson.fromJson(jsonString, MovieResponse::class.java)
                    movieResponse.movies
                } else {
                    null
                }
            } else {
                getDummyMovies()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            getDummyMovies()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun getDummyMovies(): List<Movie> {
        return listOf(
            Movie(
                id = "1",
                title = "Akcijski Spektakl",
                description = "Epska priča punih adrenalinskih scena i nevjerojatnog scenarija.",
                imageUrl = "https://via.placeholder.com/300x400?text=Action+Movie",
                videoUrl = "https://www.w3schools.com/html/mov_bbb.mp4",
                rating = 8.5
            ),
            Movie(
                id = "2",
                title = "Ljubavna Drama",
                description = "Dirljuća priča o ljubavi i odricanju.",
                imageUrl = "https://via.placeholder.com/300x400?text=Romance",
                videoUrl = "https://www.w3schools.com/html/mov_bbb.mp4",
                rating = 7.8
            ),
            Movie(
                id = "3",
                title = "Misterija u Polnoći",
                description = "Detektivska priča puna okreta i iznenađenja.",
                imageUrl = "https://via.placeholder.com/300x400?text=Mystery",
                videoUrl = "https://www.w3schools.com/html/mov_bbb.mp4",
                rating = 8.2
            ),
            Movie(
                id = "4",
                title = "Znanstvena Fantastika",
                description = "Putovanje kroz svemir i vremenske dimenzije.",
                imageUrl = "https://via.placeholder.com/300x400?text=Sci+Fi",
                videoUrl = "https://www.w3schools.com/html/mov_bbb.mp4",
                rating = 8.9
            )
        )
    }
}
