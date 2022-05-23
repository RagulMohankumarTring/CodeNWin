package com.example.codenwin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.codenwin.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView

class SplashActivity : AppCompatActivity(), Player.Listener {
    private lateinit var player:ExoPlayer
    private lateinit var playerView:PlayerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.i("check","Splash")
        setUpPlayer()
        addMp4Files()
    }
    fun setUpPlayer(){
        player = ExoPlayer.Builder(this).build()
        playerView=findViewById(R.id.splashVideo)
        playerView.player = player
        player.addListener(this)
        player.play()
    }

    override fun onStop() {
        super.onStop()
        player.stop()
    }
    private fun addMp4Files(){
        val mediaItem = MediaItem.fromUri(getString(R.string.splash_screen_video_2))
        player.addMediaItem(mediaItem)
        player.prepare()
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        if (playbackState == ExoPlayer.STATE_ENDED){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun addMp3Files(){
        val mediaItem = MediaItem.fromUri(getString(R.string.splash_screen_video_1))
        player.addMediaItem(mediaItem)
        player.prepare()
    }
}