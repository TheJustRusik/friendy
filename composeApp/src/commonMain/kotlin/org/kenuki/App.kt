package org.kenuki

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.ktor.client.*
import io.ktor.client.request.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kenuki.components.ChatBody
import org.kenuki.components.ChatHeader
import org.kenuki.components.messages.Message
import org.kenuki.components.messages.TextMessage

@Composable
@Preview
fun App() {
    val messages by remember { mutableStateOf(mutableListOf<Message>()) }
    messages.add(TextMessage("Hello world",true))
    MaterialTheme {
        Column {
            ChatHeader("Имя Фамилия")
            ChatBody(messages)
        }
    }
}