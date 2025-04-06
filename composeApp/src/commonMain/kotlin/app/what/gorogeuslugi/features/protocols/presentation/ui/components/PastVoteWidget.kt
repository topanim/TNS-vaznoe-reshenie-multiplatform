package app.what.gorogeuslugi.features.protocols.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonGreen

@Composable
fun PastVoteWidget(time: String) = Card(
    modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 16.dp),
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
    Row(
        modifier = Modifier.fillMaxSize().padding(13.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = time,
                fontSize = 10.sp,
                fontWeight = FontWeight(500),
                lineHeight = 10.sp,
                color = buttonGreen
            )
            Gap(5)
            Text(
                "Тема голосования",
                color = buttonBlack,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight(600)
            )
            Gap(7)
            FlowRow(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
//                EventFormat(meet.meeting_link)
//                EventFormat(meet.meeting_link)
//                EventFormat(meet.meeting_link)
//                EventFormat(meet.meeting_link)

            }

        }
        Column(modifier = Modifier.wrapContentSize()) {
            Text(
                "За: 18",
                fontWeight = FontWeight(600),
                fontSize = 10.sp,
                lineHeight = 10.sp,
                color = buttonBlack
            )
            Gap(7)
            Text(
                "Против: 3",
                fontWeight = FontWeight(600),
                fontSize = 10.sp,
                lineHeight = 10.sp,
                color = buttonBlack
            )
            Gap(7)
            Text(
                "Воздержался: 3",
                fontWeight = FontWeight(600),
                fontSize = 10.sp,
                lineHeight = 10.sp,
                color = buttonBlack
            )
        }
    }
}