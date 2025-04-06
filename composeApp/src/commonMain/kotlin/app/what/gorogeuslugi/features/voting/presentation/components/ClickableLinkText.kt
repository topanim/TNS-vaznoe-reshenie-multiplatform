package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import app.what.gorogeuslugi.theme.buttonGreen


fun buildLinkText(
    text: String,
    link: String
) = buildAnnotatedString {
    withLink(LinkAnnotation.Url(url = link)) {
        append(text)
    }
}


@Composable
fun ClickableLinkText(text: String, link: String) {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        withLink(LinkAnnotation.Url(url = link)) {
            append(text)
        }
    }

    Text(
        text = annotatedLinkString,
        textDecoration = TextDecoration.Underline,
        color = buttonGreen
    )
}