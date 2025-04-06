package app.what.gorogeuslugi.features.protocols.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolActions
import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolsState
import app.what.gorogeuslugi.features.protocols.presentation.ui.components.PastVoteWidget
import app.what.gorogeuslugi.foundation.ui.Gap

@Composable
fun ProtocolView(state: ProtocolsState, action: ProtocolActions?) =
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)

    ) {
        HeaderWidget("Протоколы")
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
        Gap(20)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(5) {
                PastVoteWidget("Завершенно 30 октября,12.00")
                Gap(10)
            }
        }

    }