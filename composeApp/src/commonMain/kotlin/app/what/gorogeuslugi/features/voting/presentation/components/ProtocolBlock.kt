package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.runtime.Composable

@Composable
fun ProtocolBlock(docsUrl: String) {
    ClickableLinkText("Скачать протоколы по ссылке", docsUrl)
}