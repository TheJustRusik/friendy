package org.kenuki.components.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch

class TextMessage(
    private val text: String,
    private val isMine: Boolean
): Message {
    suspend fun fetchText(): String {
        try {
            val httpClient = HttpClient()
            val res = httpClient.get("https://ktor.io/docs/")
            return res.bodyAsText()
        } catch (e: Exception) {
            return "Error: ${e.message}"
        }
    }
    @Composable
    override fun draw() {
        var text by remember { mutableStateOf("Loading...") }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isMine) Arrangement.End else Arrangement.Start
        ) {
            Card(
                backgroundColor = if (isMine) Color.Blue else Color.Gray,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                rememberCoroutineScope().launch {
                    text = fetchText()
                }
                Text(
                    text = text,
                    color = Color.White,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}