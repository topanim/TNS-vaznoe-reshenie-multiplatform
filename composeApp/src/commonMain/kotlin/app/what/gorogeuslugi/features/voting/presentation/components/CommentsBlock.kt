package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.foundation.ui.bclick
import app.what.gorogeuslugi.foundation.ui.useSave
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun CommentsBlock(comment: String) = Column(
    modifier = Modifier.fillMaxWidth()
) {
    val (expanded, setExpanded) = useSave(false)

    Text(
        "Комментарий нейросети",
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        lineHeight = 20.sp,
        color = buttonBlack
    )
    Gap(10)
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xFFF5F6F8))
            .bclick { setExpanded(!expanded) }
    ) {
        Box(Modifier.width(4.dp).fillMaxHeight().background(Color(0xFF9E9C9F)))

        Gap(18)

        Text(
            comment,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            lineHeight = 14.sp,
            color = Color(0xFF9E9C9F),
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            maxLines = if (expanded) Int.MAX_VALUE else 12
        )
    }

}