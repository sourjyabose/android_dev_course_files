package com.example.video

import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val video:VideoView=findViewById<VideoView>(R.id.videoView)
        val mediacontroller: MediaController= MediaController(this)
        mediacontroller.setAnchorView(video)
        val uri: Uri =parse("android.resource://"+packageName+"/"+R.raw.alpha)
        video.setMediaController(mediacontroller)
        video.setVideoURI(uri)
        video.requestFocus()
        video.start()


    }
}