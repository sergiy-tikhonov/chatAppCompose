package com.tikhonov.chatapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

@Composable
fun ChatApp() {
    Column() {
        Row() {
            UserArea(userName = "User1")
            UserArea(userName = "User2")
        }
        ChatArea()
    }
}