package org.kenuki

import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kenuki.components.ChatBody
import org.kenuki.components.ChatFooter
import org.kenuki.components.ChatHeader
import org.kenuki.components.messages.Message
import org.kenuki.components.messages.TextMessage

@Composable
fun App() {
    val messages = remember { mutableStateListOf<Message>() }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            ChatHeader("Имя Фамилия")
            ChatBody(messages, listState, modifier = Modifier.weight(1f))
            ChatFooter {
                messages.add(0, TextMessage(it, true))
                coroutineScope.launch {
                    listState.scrollToItem(1)
                    listState.animateScrollToItem(0)
                }

            }
        }
    }
}

