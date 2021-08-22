package com.tikhonov.chatapp.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun UserArea(userName: String) {
    Text(text = userName)
}