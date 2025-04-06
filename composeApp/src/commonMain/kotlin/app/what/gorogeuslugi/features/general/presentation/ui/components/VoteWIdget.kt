package app.what.gorogeuslugi.features.general.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.foundation.ui.bclick
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonGreen
import gorogeuslugi.composeapp.generated.resources.Res
import gorogeuslugi.composeapp.generated.resources.video
import org.jetbrains.compose.resources.painterResource

@Composable
fun VoteWidget(
    meet: Api.Meetings.GetAll.Response.Meeting,
    selected: () -> Unit
) = Card(
    modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 16.dp)
        .bclick { selected() },
    shape = RoundedCornerShape(10.dp),
    colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    border = BorderStroke(
        width = 1.dp,
        color = Color(0xFFDBDBDB)
    ),
    elevation = CardDefaults.cardElevation(5.dp)
) {
    Column(
        modifier = Modifier.wrapContentSize()
            .padding(13.dp)
    ) {
        Text(
            text = "заглушка",
            fontSize = 10.sp,
            fontWeight = FontWeight(500),
            lineHeight = 10.sp,
            color = buttonGreen
        )
        Gap(5)
        Text(
            meet.title,
            color = buttonBlack,
            fontSize = 14.sp,
            lineHeight = 14.sp,
            fontWeight = FontWeight(600)
        )
        Gap(7)
        EventFormat(meet.meeting_link)

    }
}

@Composable
fun EventFormat(
    meetingLink: String
) = Row(verticalAlignment = Alignment.CenterVertically) {
    Image(
        painter = painterResource(Res.drawable.video), "",
        modifier = Modifier.size(12.dp)
    )
    Gap(2)
    Text(
        meetingLink,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF9E9C9F)
    )
}


