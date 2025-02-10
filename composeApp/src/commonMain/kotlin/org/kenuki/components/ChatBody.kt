package org.kenuki.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ChatBody (content: List<Message>, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxSize(),
            reverseLayout = true
        ) {
            items(messages) { message ->
                MessageBubble(message)
            }
        }
    }
}

data class Message(
    val text: String,
    val isMine: Boolean,
)