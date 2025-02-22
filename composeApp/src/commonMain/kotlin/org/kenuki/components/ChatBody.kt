package org.kenuki.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.kenuki.components.messages.Message

@Composable
@Preview
fun ChatBody (messages: List<Message>, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxSize(),
            reverseLayout = true
        ) {
            items(messages) { message ->
                message.draw()
            }
        }
    }
}