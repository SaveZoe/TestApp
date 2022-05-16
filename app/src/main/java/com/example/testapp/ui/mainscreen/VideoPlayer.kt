package com.example.testapp.ui.mainscreen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.VideoItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_NONE
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun VideoPlayer(
    exoPlayer: ExoPlayer,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val video: List<VideoItem> = viewModel.video.collectAsState().value

    exoPlayer.addMediaItem(MediaItem.fromUri(video[0].mediaUrl))
    exoPlayer.addMediaItem(MediaItem.fromUri(video[1].mediaUrl))
    exoPlayer.addMediaItem(MediaItem.fromUri(video[2].mediaUrl))

    AndroidView({
        StyledPlayerView(context).apply {
            player = exoPlayer
            setRepeatToggleModes(REPEAT_TOGGLE_MODE_NONE)
        }
    })

    LaunchedEffect(exoPlayer) {
        exoPlayer.prepare()
        exoPlayer.play()
    }

}