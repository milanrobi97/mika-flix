package com.mika.mfilmovi.mikaflix

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesContainer = findViewById<LinearLayout>(R.id.moviesContainer)

        // Učitaj filmove u background
        GlobalScope.launch(Dispatchers.Main) {
            val movies = withContext(Dispatchers.IO) {
                ApiService.fetchMovies()
            }

            if (movies != null && movies.isNotEmpty()) {
                moviesContainer.removeAllViews()
                for (movie in movies) {
                    val movieView = android.view.LayoutInflater.from(this@MainActivity)
                        .inflate(R.layout.movie_item, moviesContainer, false)
                    
                    // Popuni podatke
                    val titleView = movieView.findViewById<android.widget.TextView>(R.id.movieTitle)
                    val descView = movieView.findViewById<android.widget.TextView>(R.id.movieDescription)
                    val ratingView = movieView.findViewById<android.widget.TextView>(R.id.movieRating)
                    val imgView = movieView.findViewById<android.widget.ImageView>(R.id.moviePoster)
                    val playBtn = movieView.findViewById<android.widget.Button>(R.id.playButton)

                    titleView.text = movie.title
                    descView.text = movie.description
                    ratingView.text = "⭐ ${movie.rating}"

                    // Učitaj sliku
                    try {
                        com.squareup.picasso.Picasso.get()
                            .load(movie.imageUrl)
                            .placeholder(android.R.drawable.ic_menu_gallery)
                            .error(android.R.drawable.ic_menu_gallery)
                            .into(imgView)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    // Play dugme
                    playBtn.setOnClickListener {
                        val intent = android.content.Intent(this@MainActivity, PlayerActivity::class.java)
                        intent.putExtra("videoUrl", movie.videoUrl)
                        intent.putExtra("title", movie.title)
                        startActivity(intent)
                    }

                    moviesContainer.addView(movieView)
                }
            } else {
                Toast.makeText(this@MainActivity, "Greška pri učitavanju filmova!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
