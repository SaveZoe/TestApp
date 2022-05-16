package com.example.testapp.ui.mainscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.ExoPlayer

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        VideoPlayer(
            exoPlayer = exoPlayer
        )
    }
}