package app.what.gorogeuslugi.features.general.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.components.CustomTextField
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.general.presentation.models.GeneralEvents
import app.what.gorogeuslugi.features.general.presentation.models.GeneralState
import app.what.gorogeuslugi.features.general.presentation.ui.components.SheetContents
import app.what.gorogeuslugi.features.general.presentation.ui.components.TimeFilterRow
import app.what.gorogeuslugi.features.general.presentation.ui.components.VoteWidget
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.navigation.core.rememberSheetController

@Composable
fun GeneralView(state: GeneralState, listener: Listener<GeneralEvents>) {
    val sheetState = rememberSheetController()
    val sheetContent: @Composable () -> Unit = {
        SheetContents(state, listener)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HeaderWidget("Личный кабинет")
        CustomTextField("Поиск...", inputText = {}) {
            sheetState.open(false) {
                sheetContent()
            }
        }
        Gap(20)
        TimeFilterRow(selectedFilter = state.timeEvent) {
            listener(GeneralEvents.SelectTimeFilter(it))
        }
        Gap(20)
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(state.data) {
                VoteWidget(it) {
                    listener(GeneralEvents.NavigationToDetail(it.id))
                }
                Gap(10)
            }
        }
        CustomButton(
            title = "Создать голосование",
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            listener(GeneralEvents.NavigationToCreateEvent)
        }
    }
}