package com.example.testapp.ui.mainscreen

import androidx.lifecycle.ViewModel
import com.example.testapp.data.VideoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {
    private val _video: MutableStateFlow<List<VideoItem>> = MutableStateFlow(
        listOf(
            VideoItem(0, "file:///android_asset/vid1.mp4"),
            VideoItem(1, "file:///android_asset/vid2.mp4"),
            VideoItem(2, "file:///android_asset/vid3.mp4")
        )
    )
    val video: StateFlow<List<VideoItem>> = _video.asStateFlow()
}