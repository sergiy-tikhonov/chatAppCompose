package com.tikhonov.chatapp.components
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.tikhonov.chatapp.R
import androidx.compose.runtime.getValue // <-- WITHOUT THAT IT WOULDN'T WORK
import androidx.compose.runtime.setValue // <-- WITHOUT THAT IT WOULDN'T WORK
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tikhonov.chatapp.ui.theme.ChatAppTheme

@Composable
fun ChatApp() {
    var user1Message by remember { mutableStateOf("") }
    var user2Message by remember { mutableStateOf("") }
    var chat: MutableList<String> by remember {
        mutableStateOf(mutableListOf())
    }
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            UserArea(
                userName = stringResource(id = R.string.user1_name),
                avatar = R.drawable.boy,
                message = user1Message,
                onMessageChanged = {
                    user1Message = it
                },
                modifier = Modifier.weight(1.0f),
                onMessageAdd = {
                    chat.add(user1Message)
                    user1Message = ""
                }
            )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            UserArea(
                userName = stringResource(id = R.string.user2_name),
                avatar = R.drawable.girl,
                message = user2Message,
                onMessageChanged = {
                    user2Message = it
                },
                modifier = Modifier.weight(1.0f),
                onMessageAdd = {
                    chat.add(user2Message)
                    user2Message = ""
                }
            )
        }
        ChatArea()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultChatAppPreview() {
    ChatAppTheme {
        ChatApp()
    }
}