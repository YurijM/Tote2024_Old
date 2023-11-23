package com.mu.tote2024.presentation.screen.main_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {
    var isAdmin by mutableStateOf(false)
}
