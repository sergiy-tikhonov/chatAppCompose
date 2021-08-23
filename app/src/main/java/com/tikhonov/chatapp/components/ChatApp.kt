package com.tikhonov.chatapp.components
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.tikhonov.chatapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tikhonov.chatapp.Message
import com.tikhonov.chatapp.ui.theme.ChatAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun ChatApp() {
    var user1Message by remember { mutableStateOf("") }
    var user2Message by remember { mutableStateOf("") }
    val chat = remember {mutableStateListOf<Message>()}  // <-- mutableStateOf doesn't work

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
                modifier = Modifier.weight(1.0f).padding(16.dp),
                onMessageAdd = {
                    chat.add(Message(user1Message, true))
                    user1Message = ""
                }
            )
            UserArea(
                userName = stringResource(id = R.string.user2_name),
                avatar = R.drawable.girl,
                message = user2Message,
                onMessageChanged = {
                    user2Message = it
                },
                modifier = Modifier.weight(1.0f).padding(16.dp),
                onMessageAdd = {
                    chat.add(Message(user2Message, false))
                    user2Message = ""
                }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        ChatArea(
            chat = chat,
            onMessageDelete = {
                    message -> chat.remove(message)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultChatAppPreview() {
    ChatAppTheme {
        ChatApp()
    }
}