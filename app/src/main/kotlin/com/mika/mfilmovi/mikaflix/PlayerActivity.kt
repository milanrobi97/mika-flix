package com.mika.mfilmovi.mikaflix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private lateinit var playerView: StyledPlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        playerView = findViewById(R.id.playerView)

        val videoUrl = intent.getStringExtra("videoUrl") ?: ""
        val title = intent.getStringExtra("title") ?: "Video"

        if (videoUrl.isNotEmpty()) {
            playVideo(videoUrl)
        }
    }

    private fun playVideo(url: String) {
        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(url)
        player?.addMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
        player = null
    }
}
