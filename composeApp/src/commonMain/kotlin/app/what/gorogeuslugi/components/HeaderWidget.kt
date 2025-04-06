package app.what.gorogeuslugi.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Show
import app.what.gorogeuslugi.foundation.ui.bclick
import app.what.gorogeuslugi.theme.buttonBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderWidget(
    title: String,
    onBack: (() -> Unit)? = null
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Left
            )
        },
        navigationIcon = {
            onBack?.let { action ->
                Icons.AutoMirrored.Filled.ArrowBack.Show(
                    modifier = Modifier.bclick {
                        action()
                    },
                    color = buttonBlack
                )
            }
        })
}