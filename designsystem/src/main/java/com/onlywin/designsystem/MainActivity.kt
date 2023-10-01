package com.onlywin.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import tech.thdev.compose.extensions.keyboard.state.foundation.collectIsKeyboardAsState
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuckTheme {

            }
        }
    }
}

val isKeyboardShowed
    @Composable get() = LocalMutableExKeyboardStateSourceOwner.current.collectIsKeyboardAsState()
