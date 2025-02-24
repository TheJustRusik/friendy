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
import org.kenuki.services.HttpClientService

class TextMessage(
    private val text: String,
    private val isMine: Boolean,
    private val httpClient: HttpClient = HttpClientService.getClient()
): Message {

    private fun myPadding() =
        if (isMine)
            Modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
        else
            Modifier.padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)

    @Composable
    override fun draw() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if (isMine) Arrangement.End else Arrangement.Start
        ) {
            Card(
                backgroundColor = if (isMine) Color.Blue else Color.Gray,
                shape = RoundedCornerShape(16.dp),
                modifier = myPadding()
            ) {
                Text(
                    text = text,
                    color = Color.White,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}